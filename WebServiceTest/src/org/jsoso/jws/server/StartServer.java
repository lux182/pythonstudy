package org.jsoso.jws.server;   
  
import java.util.LinkedList;   
import java.util.List;   
import javax.xml.ws.Binding;   
import javax.xml.ws.Endpoint;   
import javax.xml.ws.handler.Handler;   
  
/**  
 * @author zsy ����web services����  
 */  
public class StartServer {   
  
    /**  
     * @param args  
     */  
    public static void main(String[] args) {   
        /*  
         * ����Example ����ʵ��  
         */  
        Example serverBean = new Example();   
        /*  
         * ����Web Service��http://localhost:8080/hello��ַ  
         */  
        Endpoint endpoint =    
           Endpoint.publish("http://localhost:8080/hello", serverBean);   
        Binding binding = endpoint.getBinding();   
        /*  
         * ����һ��SOAPЭ�鴦��ջ  
         * ����ͼ򵥵ô�ӡSOAP����Ϣ�ı�  
         */  
        List<Handler> handlerChain = new LinkedList<Handler>();   
        handlerChain.add(new TraceHandler());   
        binding.setHandlerChain(handlerChain);   
        System.out.println("���������� http://localhost:8080/hello");   
    }   
}  