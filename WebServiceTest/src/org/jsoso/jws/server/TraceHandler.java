package org.jsoso.jws.server;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class TraceHandler implements SOAPHandler<SOAPMessageContext> 
{
    public boolean handleMessage(SOAPMessageContext messageContext) 
    {
        trace(messageContext);
        return true;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) 
    {
        trace(messageContext);
        return true;
    }
    
    private void trace(SOAPMessageContext messageContext) 
    {
        Boolean outMessageIndicator = (Boolean)        
        messageContext.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if (outMessageIndicator.booleanValue()) 
        {
            System.out.println("\nOutbound SOAP:");
        } 
        else 
        {
            System.out.println("\nInbound SOAP:");
        }
        
        SOAPMessage message = messageContext.getMessage();
        try 
        {
            message.writeTo(System.out);
            System.out.println("");   
        } 
        catch (Exception exp) 
        {
            System.out.println("Exception in TraceHandler:trace(messageContext) : " + exp);
        }
    }

	@Override
	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
}