package com.util;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebConnection;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.util.WebConnectionWrapper;

public class MyWebConnectionWrapper extends WebConnectionWrapper {

	public MyWebConnectionWrapper(WebConnection webConnection)
			throws IllegalArgumentException {
		super(webConnection);
	}

	@Override
	public WebResponse getResponse(WebRequest request) throws IOException {
		if (request.getUrl().toString().startsWith("http://stat.sac.gov.cn/phpstat/logcount.php?")) {
			WebResponse webResponse = new StringWebResponse("",request.getUrl());
			return webResponse;
		} 
		return super.getResponse(request);
	}

}
