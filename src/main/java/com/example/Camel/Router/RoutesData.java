package com.example.Camel.Router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.example.Camel.processor.ProcessorData;

@Component
public class RoutesData extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	
        
      
    	from("direct:createGeneralingo")
    	.process(new ProcessorData())
        .to("mongodb:myinfo?database=Assign&collection=info&operation=insert");
 
        
        from("direct:getGeneralingo")
            .setHeader("CamelMongoDbCriteriaId").simple("${header.id}")
            .to("mongodb:myinfo?database=Assign&collection=info&operation=findOneByQuery");

       
        from("direct:updateGeneralingo")
            .setHeader("CamelMongoDbCriteriaId").simple("${header.id}")
            .to("mongodb:myinfo?database=Assign&collection=info&operation=update");


        from("direct:deleteGeneralingo")
            .setHeader("CamelMongoDbCriteriaId").simple("${header.id}")
            .to("mongodb:myinfo?database=Assign&collection=info&operation=remove");
        

        from("direct:callExternalApi")
            .setHeader("CamelHttpMethod", constant("GET"))
            .to("http://api.example.com/some-endpoint")
            .log("Response from external API: ${body}");
    }
}
