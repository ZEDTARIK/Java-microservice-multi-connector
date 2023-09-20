package com.ettarak.microservices.multi.connecteur.configuration;

import com.ettarak.microservices.multi.connecteur.web.CustomerSoapController;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CfxConfigurationWebServiceSOAP {
    @Autowired
    private Bus bus;
    @Autowired
    private CustomerSoapController customerSoapController;

    @Bean
    public EndpointImpl endpoint(){
        EndpointImpl endpoint= new EndpointImpl(bus, customerSoapController);
        endpoint.publish("/CustomerServiceSoap");
        return  endpoint;
    }


}
