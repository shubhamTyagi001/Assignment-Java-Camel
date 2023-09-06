package com.example.Camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component

public class ProcessorData implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		 String mockResponse = "{\"message\": \"This is a mock response\"}";

	      
	        exchange.getMessage().setBody(mockResponse);
		
	}

}
