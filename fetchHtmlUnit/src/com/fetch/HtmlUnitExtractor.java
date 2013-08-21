package com.fetch;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.gargoylesoftware.htmlunit.TopLevelWindow;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.util.MyWebConnectionWrapper;


/**
 * @author Administrator
 * 失败后重复抽取
 */
public class HtmlUnitExtractor {
	
	private WebClient webClient;
	
	private String startPageUrl;
	
	private static final String DEFAULT_PROPERTIES = "default.properties"; 
	
	private static Map<String, String> cfgMap = new HashMap<String, String>(); 
	
	/**
	 * read config
	 * @return
	 */
	public InputStream getConfigFileInputStream() {
		InputStream is = HtmlUnitExtractor.class.getResourceAsStream("/"+DEFAULT_PROPERTIES);
		if (is==null) {
			return null;
		}
		return is;
	}
	
	/**
	 * 初始化
	 */
	public void initCfgMap(){
		InputStream is = this.getConfigFileInputStream();
		if (is != null) {
			Properties p = new Properties();
			try {
				p.load(is);
				for (Enumeration<?> enu = p.propertyNames(); enu.hasMoreElements();) {
					String key = (String) enu.nextElement();
					String value = (String) p.getProperty(key);
					cfgMap.put(key, value);
				}
			} catch (IOException e) {
				System.out.println("read default.properties failed!");
				e.printStackTrace();
			}
		} 
	}
	
	
	/**
	 * 抽取国家标准公告
	 * 
	 * @参数初始化
	 */
	public void initialize(){
		//参数初始化
		initCfgMap();
		//模拟一个浏览器
		webClient = new WebClient();
		//设置webClient的相关参数
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setTimeout(35000);
		webClient.setWebConnection(new MyWebConnectionWrapper(webClient.getWebConnection()));
		//http://www.sac.gov.cn/
		startPageUrl = cfgMap.get("indexurl");//起始地址
	}
	
	/**
	 * @author Administrator
	 * 
	 *	起始地址，并返回HtmlPage的页面信息
	 *	
	 */
	public HtmlPage getStartPage() {
		HtmlPage page = null;
		try {
			//模拟浏览器打开一个目标网址
			page = webClient.getPage(startPageUrl);//每个抓取得直接网址
		} catch (Exception ex) {
			System.out.println("打开网页失败-->"+startPageUrl); 
			ex.printStackTrace();
			return null;
		}
		return page;
	}
	/**
	 * @author Administrator
	 *	 返回当前页面的内容
	 */
	public HtmlPage getNextSearchResultPage(HtmlElement resultPageTrigger) {
		//模拟点击进入该链接
		HtmlPage currentPage = null;
		try {
			resultPageTrigger.click();
		} catch (Exception ex) {
			System.out.println("获取下一页内容失败!");
			ex.printStackTrace();
			return null;
		}
		//打开当前页
		currentPage = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
		
		//打印看看内容
		System.out.println(currentPage.asXml());
		return currentPage;
	}
		
	/**
	 * @author Administrator
	 *	获取下一页链接地址
	 */
	public HtmlElement getNextPageTrigger(HtmlPage page) {
		webClient.getOptions().setJavaScriptEnabled(true);
		//学习一下 getFirstByXPath的API
		HtmlElement nextPageTrigger = page.getFirstByXPath("//a[text()='下一页']");

		//打印看看内容
		System.out.println(nextPageTrigger.asText());
		
		return nextPageTrigger;
	}
	/**
	 * @author Administrator
	 *	抽取本结果页面中的所有结果集的链接地址
	 */
	@SuppressWarnings("unchecked")
	public List<HtmlElement> extractAnchors(HtmlPage page) {
		//查看页面源码：
		//<a href='./201310/' target="_blank" class="1430">•&nbsp; &nbsp;2013年第10号中国国家标准公告</a>
		//<a href='./201309/' target="_blank" class="1430">•&nbsp; &nbsp;2013年第9号中国国家标准公告</a></td>
		//<a href='./201308/' target="_blank" class="1430">•&nbsp; &nbsp;2013年第8号中国国家标准公告</a>
		List<HtmlElement> anchors = (List<HtmlElement>) page.getByXPath("//a[@class='1430']");
		for (HtmlElement a : anchors) {
			HtmlAnchor anchor = (HtmlAnchor) a;
			System.out.println(anchor.asXml());
		}
		return anchors;
	}
	
	/**
	 * @author Administrator
	 *	抽取本结果页面中的所有数据
	 */
	public List<Map<String, String>> extractStd(List<HtmlElement> tbtAnchors){
		webClient.getOptions().setJavaScriptEnabled(false);
		List<Map<String, String>> tbts = new ArrayList<Map<String, String>>();
		for (HtmlElement anchor : tbtAnchors){
			//开始一个新的页面 就是http://www.sac.gov.cn/gjbzgg/页面的第一个链接
			//http://www.sac.gov.cn/gjbzgg/201310/
			TopLevelWindow currentWindow = null;
			String href = anchor.getAttribute("href");
			try {
				//模拟浏览器的动作 打开网页
				anchor.click();
			} catch (IOException ex) {
				System.out.println("=====打开网页失败!=====");
				ex.printStackTrace();
			}
			//获取当前打开的页面 http://www.sac.gov.cn/gjbzgg/201310/
			currentWindow = (TopLevelWindow) webClient.getCurrentWindow();
			HtmlPage tbtPage = (HtmlPage) currentWindow.getEnclosedPage();
			if (tbtPage != null) {
				System.out.println(tbtPage.getUrl());
				Map<String, String> info = new HashMap<String, String>();;
				//获取这个页面的信息 并将页面上的信息保存到map中  最后将map数据添加的list<map>中
				info.put("lylj", tbtPage.getUrl().toString());// lylj 来源连接
				info.put("lyym", tbtPage.asXml().trim());// lyym 来源页面内容
				System.out.println(info.get("lylj")); 
				System.out.println(info.get("lyym")); 
				tbts.add(info);
				if (tbtPage.getUrl().toString().endsWith(href)) {
					currentWindow.close();
				}
				currentWindow.close();
			}
		}
		return tbts;
	}
	/**
	 * @author Administrator
	 *
	 */
	public void destory() {
		webClient.closeAllWindows();
	}
	/**
	 * @author Administrator
	 */
	public static void main(String[] args) {
		
		HtmlUnitExtractor  extractor = new HtmlUnitExtractor();
		extractor.initialize();
		
		HtmlPage startPage = extractor.getStartPage();
		if (startPage == null) {
			return;
		}
		
		//查看页面源码
		//td align="center"><a href="/gjbzgg/" target="_blank" class="lanse12">国家标准公告</a></td>
		HtmlElement resultPageTrigger = startPage.getAnchorByHref("/gjbzgg/");
		
		int pageCount = 5;
		
		while ( resultPageTrigger != null &&pageCount > 0) {
			
			HtmlPage resultPage = extractor.getNextSearchResultPage(resultPageTrigger);
			
			if (resultPage != null) {
				System.out.println("Result page \"" + resultPage.getUrl()+ "\" loaded;");
				
				//获取http://www.sac.gov.cn/gjbzgg/这个页面上面所有的页面链接地址 就是分页的第一页数据   20条记录
				List<HtmlElement> tbtAnchors = extractor.extractAnchors(resultPage);
				
				//对当前页的20条记录  逐个进行分析  
				//每一个页面分析的结果就放到一个Map中   所以结果最后都放到一个list里面去
				List<Map<String, String>> pageInfos =	extractor.extractStd(tbtAnchors);
				
				//对数据进行处理  保存到txt文本里面 或者保存到数据库  或者保存到nosql数据库上面
				for(Map<String, String> pageIfno: pageInfos){
					 System.out.print(pageIfno.size());
				}
				
				//对第二页的数据进行抽取
				resultPageTrigger = extractor.getNextPageTrigger(resultPage);//获取下一页链接地址				
			}			
			pageCount--;
		}
		extractor.destory();
	}
}
  