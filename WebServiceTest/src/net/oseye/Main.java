package net.oseye;
 
import javax.xml.ws.Endpoint;
 
public class Main {
 
//	public static void main(String[] args) {
//		Endpoint.publish("http://localhost:8808/HelloService", new Hello());
//	}
	public static void main(String[] args) {
		HelloService helloService=new HelloService();
		String helloStr=helloService.getHelloPort().sayHello("oseye");
		System.out.println(helloStr); 
	}
 
}