package swingDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SwingDemo extends JFrame implements ActionListener {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//�ṩ����װ��(��߽硢�رմ��ڵ�С���������⡭��)
		JFrame frame = new SwingDemo();//����JFrame����,��ʼ���ɼ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ÿ�ܹرհ�ť�¼�
		frame.pack();//ѹ����ܵ���ʾ����
		frame.setVisible(true);//��ʾ���������
	}
	JButton b1;//������ť����

	JLabel l1, l2;//������ǩ����

	SwingDemo() {//���幹�췽��
		super("SwingӦ��ʵ��");//���ø��๹�췽��
		l1 = new JLabel("һ��GUIӦ�ó��������", JLabel.CENTER);//�����ǩ,���־���
		l2 = new JLabel("");//���������ֱ�ǩ
		b1 = new JButton("����ʱ��[T]");//���尴ť
		b1.setMnemonic(KeyEvent.VK_T);//���ð�ť��ݼ�
		b1.setActionCommand("time");//���ÿ�����
		b1.addActionListener(this);//ע�ᰴť�¼�
		add(l1, BorderLayout.NORTH);//��ӱ�ǩl1
		add(l2, BorderLayout.CENTER);//��ӱ�ǩl2
		add(b1, BorderLayout.SOUTH);//��ӱ�ǩb1
	}

	@Override
	public void actionPerformed(ActionEvent e) {//�԰�ť�����¼����
		// TODO Auto-generated method stub
		//��ȡϵͳ����
		Calendar c1 = Calendar.getInstance();
		//����ť�¼�
		if (e.getActionCommand().equals("time") ) {
			//���ñ�ǩ����
			l2.setText("���ڵ�ʱ����" + c1.get(Calendar.HOUR_OF_DAY) + "ʱ"
					+ c1.get(Calendar.MINUTE) + "��"+c1.get(Calendar.SECOND)+"��");
			//���ñ�ǩ���־��ж���
			l2.setHorizontalAlignment(JLabel.CENTER);
		} else {
			System.exit(0);
		}
	}
}
