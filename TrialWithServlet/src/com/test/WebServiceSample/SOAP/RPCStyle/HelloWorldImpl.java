package com.test.WebServiceSample.SOAP.RPCStyle;

import javax.jws.WebService;  
//Service Implementation  
@WebService(endpointInterface = "com.test.WebServiceSample.SOAP.RPCStyle.HelloWorld")  
public class HelloWorldImpl implements HelloWorld{  
    @Override  
    public String getHelloWorldAsString(String name) {  
        return "Hello World JAX-WS " + name;  
    }  
} 
