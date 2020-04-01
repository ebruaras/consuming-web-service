package com.example.demo;

import com.example.demo.wsdl.GetUserRequest;
import com.example.demo.wsdl.GetUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UserClient.class);
    public GetUserResponse getUser(String user){
        GetUserRequest request=new GetUserRequest();
        request.setName(user);
        log.info("Requesting location for " + user);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/bank", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetUserRequest"));

        return response;
    }
}
