package swingDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SwingDemo extends JFrame implements ActionListener {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//提供窗口装饰(如边界、关闭窗口的小部件、标题……)
		JFrame frame = new SwingDemo();//创建JFrame对象,初始不可见
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置框架关闭按钮事件
		frame.setSize(400, 300);
		frame.pack();//压缩框架的显示区域
		frame.setVisible(true);//显示框架主窗口
		JDialog dialog = new JDialog(frame, true);
		dialog.setSize(200, 100);
		dialog.setVisible(true);
	}
	JButton b1;//声明按钮对象

	JLabel l1, l2;//申明标签对象

	SwingDemo() {//定义构造方法
		super("Swing应用实例");//调用父类构造方法
		l1 = new JLabel("一个GUI应用程序的例子", JLabel.CENTER);//定义标签,文字居中
		l2 = new JLabel("");//定义无文字标签
		b1 = new JButton("现在时间[T]");//定义按钮
		b1.setMnemonic(KeyEvent.VK_T);//设置按钮快捷键
		b1.setActionCommand("time");//设置控制名
		b1.addActionListener(this);//注册按钮事件
		add(l1, BorderLayout.NORTH);//添加标签l1
		add(l2, BorderLayout.CENTER);//添加标签l2
		add(b1, BorderLayout.SOUTH);//添加标签b1
	}

	@Override
	public void actionPerformed(ActionEvent e) {//对按钮引发事件编程
		// TODO Auto-generated method stub
		//获取系统日期
		Calendar c1 = Calendar.getInstance();
		//捕获按钮事件
		if (e.getActionCommand().equals("time") ) {
			//设置标签文字
			l2.setText("现在的时间是" + c1.get(Calendar.HOUR_OF_DAY) + "时"
					+ c1.get(Calendar.MINUTE) + "分"+c1.get(Calendar.SECOND)+"秒");
			//设置标签文字居中对齐
			l2.setHorizontalAlignment(JLabel.CENTER);
		} else {
			System.exit(0);
		}
	}
}