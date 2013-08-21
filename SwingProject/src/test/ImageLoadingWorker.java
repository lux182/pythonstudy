package test;

/*
 * SwingWorker可以帮助我们在后台执行耗时的任务，而避免阻塞我们的应用程序，以让用户感觉不爽。
SwingWorker有2个参数T , V
T：为最终结果集 【<T> the result type returned by this SwingWorker's doInBackground and get methods】，由文档的介绍可以知道这个结果可以被doInBackground和get方法返回。
V：为中间结果集【<V> the type used for carrying out intermediate results by this SwingWorker's publish and process methods】
还要了解的是SwingWorker的几个流程：
doInBackground是工作线程，他可以明确调用publich方法（注意publish方法只在SwingWorker类中实现），以发送中间结果V，然后这个中间结果有被发送到在EDT（事件派发线程）中的
process方法中进行处理。
当doInBackground处理完后，会自动调用done方法，由T类型的描述那里可以知道，在这个方法中可以调用get方法获取最终结果集，多好玩啊，哈哈。
现在拿一段代码来分析下吧：
*/

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
public class ImageLoadingWorker extends SwingWorker<List<Image>, String>{
//看到没有继承与SwingWorker类了。T为List<Image>,说明最终结果集为List<Image>.没错，这个类就是用来加载图像，然后显示的
//V类型为String，拉到下面看下，publish的参数是String吧
	private JTextArea logArea;
	private JPanel viewerPanel;
	private String[] fileNames;
	
	
	public ImageLoadingWorker(JTextArea logArea , JPanel viewerPanel , String[] fileNames){
		
		this.logArea = logArea;
		this.viewerPanel = viewerPanel;
		this.fileNames = fileNames;
		
	}
//通过执行了SwingWorker的execute方法，然后就调用了doInBackground这个方法，对fileNames对应的Image进行加载。并在每一个图像
//加载的同时用publish方法发送相应信息，这个信息会发送到process方法中进行处理，当然前提是你要重写process这个函数，以保证能按
//照你的要求来进行显示，对吧
	@Override
	protected List<Image> doInBackground() throws Exception {
		// TODO Auto-generated method stub
		List<Image> images = new ArrayList<Image>();
		for(String imgName : fileNames){
			try {
				images.add(ImageIO.read(new File(imgName)));
				publish("loading " + imgName);
			} catch (Exception e) {
				// TODO: handle exception
				publish("error"+imgName);
			}
		}
		return images;
	}
//done方法是在doInBackground处理完成后，才执行的。于是乎，每个图像都是加载好的了。只要添加进去就可以了。
//这样，一个耗时的任务，就被SwingWorker轻松解决了。还有一点就是，done是在EDT中的，所以没有破坏Swing的
//单线程模式，而把一切与GUI相关的操作，都放在了EDT中执行。
	@Override
	protected void done() {
		// TODO Auto-generated method stub
		try {
			//get() : Waits if necessary for the computation to complete, and then retrieves its result. 
			for (Image image:get()) {
				viewerPanel.add(new JLabel(new ImageIcon(image)));
				viewerPanel.revalidate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//看看这个函数，参数为List<String> chunks，这个参数名字你是可以改的，但是类型就别改了，否则的话，publish发给类本身的了，你重写
//的就没意义了，如V类型所述，类型还是String。
	@Override
	protected void process(List<String> chunks) {
		// TODO Auto-generated method stub
		for(String message:chunks){
			logArea.append(message);
			logArea.append("/r/n");
		}
	}		
}