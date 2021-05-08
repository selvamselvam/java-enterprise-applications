package com.siva;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPBinding;

@WebService(targetNamespace = "http://tempuri.org/", portName = "authenticationSoap12HttpPort")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class authentication {
    
    @Resource
    WebServiceContext webServiceContext;
    
    public authentication() {
        super();
    }
    

    public String sayHello(String str){
        String localStr = "Hello "+ str;
        
        MessageContext messageContext = webServiceContext.getMessageContext();
        
          // get request headers
          Map<?,?> requestHeaders = (Map<?,?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
          List<?> usernameList = (List<?>) requestHeaders.get("username");
          List<?> passwordList = (List<?>) requestHeaders.get("password");
    
          String username = "";
          String password = "";
    
          if (usernameList != null) {
              username = usernameList.get(0).toString();
          }
    
          if (passwordList != null) {
              password = passwordList.get(0).toString();
          }
    
          // of course this is not real validation
          // you should validate your users from stored databases credentials
          if (username.equals("siva") && password.equals("password")) {
              localStr =  "Valid User :" + localStr;
          } else {
              localStr =  "Unknown User!";
          }
            
       
        System.out.println(localStr);
        return localStr;
    }
}
