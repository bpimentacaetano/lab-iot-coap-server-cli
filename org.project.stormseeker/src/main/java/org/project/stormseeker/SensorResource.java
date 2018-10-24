package org.project.stormseeker;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class SensorResource extends CoapResource {
	
	float tempValue;
	float humValue;
	LedResource temp;
	LedResource hum;
	ThresholdResource tempThreshold;
	ThresholdResource humThreshold;
	
	public SensorResource(String name, LedResource temp, LedResource hum, ThresholdResource tempThreshold,ThresholdResource humThreshold) {
		super(name);
		this.temp = temp;
		this.hum = hum;
		
		this.tempThreshold = tempThreshold;
		this.humThreshold = humThreshold;
		
		Timer timer = new Timer();
		timer.schedule(new UpdateTask(this),0, 1000);
	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		String json;
		json = "{'temp_value' : " + tempValue + ", 'hum_value': " + humValue + ", 'temp_state' :"+ temp.state + ", 'hum_state' : " + hum.state+ "}";
		
		exchange.respond(ResponseCode.CONTENT, json, MediaTypeRegistry.TEXT_PLAIN);
	}
	
	
	private class UpdateTask extends TimerTask {
		private CoapResource mCoapRes;
		
		public UpdateTask(CoapResource coapRes) {
			mCoapRes = coapRes;
	}
	
		@Override
		public void run() {
			Sensor tRes = new Sensor();
			try {
				tRes.getTemperatureAndHumidity();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			tempValue=tRes.temperature;
			humValue=tRes.humidity;
			
			check_threshold(tempThreshold, humThreshold);
			
			mCoapRes.changed();
		}
		
	}
	
	public void check_threshold(ThresholdResource tempThreshold,ThresholdResource humThreshold) {
		
		System.out.println("tempThreshold = "+ tempThreshold.mean + " humThresold=" + humThreshold.mean);
		System.out.println("temp value" + tempValue + " hum value" + humValue);
		if((tempValue>tempThreshold.mean)&(humValue>humThreshold.mean)) {
						
			hum.blink();
			temp.blink();
			
		} else if(humValue>humThreshold.mean){
						
			hum.ledOn();
			temp.ledOff();
			
		} else if(tempValue>tempThreshold.mean){
			
			temp.ledOn();
			hum.ledOff();
		
		} else{
			
			hum.ledOff();
			temp.ledOff();
		}
		
		
	}
	
}
