package org.jsoso.jws.server;   
  
import java.util.ArrayList;   
import javax.jws.WebMethod;   
import javax.jws.WebParam;   
import javax.jws.WebResult;   
import javax.jws.WebService;   
import javax.jws.WebParam.Mode;   
import javax.jws.soap.SOAPBinding;   
/*   
 * �ṩWebService�������   
 */   
@WebService(name="Example", targetNamespace="http://www.jsoso.com/wstest", serviceName="Example")   
@SOAPBinding(style=SOAPBinding.Style.RPC)   
public class Example {   
    private ArrayList<Person> persons = new ArrayList<Person>();;   
    /**  
     *   
     * ����һ���ַ���  
     * @param userName  
     * @return  
     */  
    @WebMethod(operationName="toSayHello",action="sayHello",exclude=false)   
    @WebResult(name="returnWord")//�Զ���÷�������ֵ��WSDL����ص�����   
    public String sayHello(@WebParam(name="userName")String userName) {   
        return "Hello:" + userName;   
    }   
  
    /**  
     * web services �����ķ���ֵ����������Ͳ���Ϊ�ӿ�  
     * @param person  
     * @return  
     * @throws HelloException  
     */  
    @WebMethod(operationName="sayHello", action="sayHello")   
    @WebResult(partName="personList")   
    public Person[] sayHello(@WebParam(partName="person", mode=Mode.IN)Person person,    
            String userName) throws Exception {   
        if (person == null || person.getName() == null) {   
            throw new Exception("˵hello��������Ϊ�ա���");   
        }   
        System.out.println(person.getName() + " �� " + userName + " ˵��Hello���ҽ���" + person.getAge() + "��");   
        persons.add(person);   
        return persons.toArray(new Person[0]);   
    }   
}