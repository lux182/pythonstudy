package test;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "HelloWorldService", targetNamespace = "www.itcast.cn")
public class HelloWorldService {
	@WebMethod
	public String sayHelloAgain(String name) {
		System.out.println(name);
		return "Hello, " + name;
	}

	public static void main(String[] args) {
		// 终端，发布web service，参数1是服务公开的访问地址address，参数2是服务的具体实现implement
		Endpoint.publish("http://localhost:7070/HelloWorldService",
				new HelloWorldService());

	}
}