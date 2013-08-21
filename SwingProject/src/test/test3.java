package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class test3 extends test2 {
	private static Log log= LogFactory.getLog(test3.class);

	test3() {
		sayHello();
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		super.sayHello();
	}

	public static void main(String[] args) {
		new test3();
		log.info("ok");
		log.error("test");
	}
}