package test;

import java.awt.BorderLayout;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test5 implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8236069300468231271L;

	/**
	 * 
	 */

	public static void main(String[] args) {

		JFrame jf = new JFrame("SwingApplication");
		JPanel jp = new JPanel();
		jf.getContentPane().add(jp,BorderLayout.CENTER);
		jf.pack();
		jf.setVisible(true);
	}

}
