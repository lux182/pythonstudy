
package net.oseye;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Hello", targetNamespace = "http://oseye.net/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Hello {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SayHello")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "SayHello", targetNamespace = "http://oseye.net/", className = "net.oseye.SayHello")
    @ResponseWrapper(localName = "SayHelloResponse", targetNamespace = "http://oseye.net/", className = "net.oseye.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
