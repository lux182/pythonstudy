package test;

/*
 * SwingWorker���԰��������ں�ִ̨�к�ʱ�����񣬶������������ǵ�Ӧ�ó��������û��о���ˬ��
SwingWorker��2������T , V
T��Ϊ���ս���� ��<T> the result type returned by this SwingWorker's doInBackground and get methods�������ĵ��Ľ��ܿ���֪�����������Ա�doInBackground��get�������ء�
V��Ϊ�м�������<V> the type used for carrying out intermediate results by this SwingWorker's publish and process methods��
��Ҫ�˽����SwingWorker�ļ������̣�
doInBackground�ǹ����̣߳���������ȷ����publich������ע��publish����ֻ��SwingWorker����ʵ�֣����Է����м���V��Ȼ������м����б����͵���EDT���¼��ɷ��̣߳��е�
process�����н��д���
��doInBackground������󣬻��Զ�����done��������T���͵������������֪��������������п��Ե���get������ȡ���ս����������氡��������
������һ�δ����������°ɣ�
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
//����û�м̳���SwingWorker���ˡ�TΪList<Image>,˵�����ս����ΪList<Image>.û������������������ͼ��Ȼ����ʾ��
//V����ΪString���������濴�£�publish�Ĳ�����String��
	private JTextArea logArea;
	private JPanel viewerPanel;
	private String[] fileNames;
	
	
	public ImageLoadingWorker(JTextArea logArea , JPanel viewerPanel , String[] fileNames){
		
		this.logArea = logArea;
		this.viewerPanel = viewerPanel;
		this.fileNames = fileNames;
		
	}
//ͨ��ִ����SwingWorker��execute������Ȼ��͵�����doInBackground�����������fileNames��Ӧ��Image���м��ء�����ÿһ��ͼ��
//���ص�ͬʱ��publish����������Ӧ��Ϣ�������Ϣ�ᷢ�͵�process�����н��д�����Ȼǰ������Ҫ��дprocess����������Ա�֤�ܰ�
//�����Ҫ����������ʾ���԰�
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
//done��������doInBackground������ɺ󣬲�ִ�еġ����Ǻ���ÿ��ͼ���Ǽ��غõ��ˡ�ֻҪ��ӽ�ȥ�Ϳ����ˡ�
//������һ����ʱ�����񣬾ͱ�SwingWorker���ɽ���ˡ�����һ����ǣ�done����EDT�еģ�����û���ƻ�Swing��
//���߳�ģʽ������һ����GUI��صĲ�������������EDT��ִ�С�
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
//�����������������ΪList<String> chunks����������������ǿ��Ըĵģ��������;ͱ���ˣ�����Ļ���publish�����౾����ˣ�����д
//�ľ�û�����ˣ���V�������������ͻ���String��
	@Override
	protected void process(List<String> chunks) {
		// TODO Auto-generated method stub
		for(String message:chunks){
			logArea.append(message);
			logArea.append("/r/n");
		}
	}		
}