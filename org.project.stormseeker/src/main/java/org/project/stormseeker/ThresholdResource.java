package org.project.stormseeker;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;
//Sensor Resource
public class ThresholdResource extends CoapResource {
	
	float threshold=1000;
	int count=0;
	float mean;
		
	public ThresholdResource(String name) {
		super(name);
		//this.tempAndHumidity = new SensorResource();
		
	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		
		exchange.respond(ResponseCode.CONTENT,"Actual threshold is= "+this.mean,MediaTypeRegistry.TEXT_PLAIN);
			
	}
	
	@Override
	public void handlePOST(CoapExchange exchange) {
	
		exchange.accept();
		String message = exchange.getRequestText();
		threshold = 0;
		count = 1;
		
		threshold= Float.parseFloat(message);
		mean = (threshold/count);
		
		exchange.respond("Valor recebido com sucesso");
	}
	
	@Override
	public void handlePUT(CoapExchange exchange) {
		String message = exchange.getRequestText();
		threshold+= Float.parseFloat(message);
		count++;
		mean = (threshold/count);
		exchange.respond("New Threshold value=" + this.mean);
	}
	

}
