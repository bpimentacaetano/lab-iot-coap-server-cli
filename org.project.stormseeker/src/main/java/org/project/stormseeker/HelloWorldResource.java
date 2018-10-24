package org.project.stormseeker;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class HelloWorldResource extends CoapResource {
	
	String message;
	
	//Constructor
	public HelloWorldResource(String name) {
		super(name);
	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond(ResponseCode.CONTENT,"Hello World Coap!",MediaTypeRegistry.TEXT_PLAIN);
	}
	
	@Override
	public void handlePOST(CoapExchange exchange) {
		exchange.accept();
		
		if(exchange.getRequestOptions() != null) {
			
			this.message = exchange.getRequestText();
			System.out.println(exchange.getRequestText());
		}
		
		exchange.respond("teste"+ this.message);
	}
}
