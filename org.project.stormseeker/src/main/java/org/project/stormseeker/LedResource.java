package org.project.stormseeker;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class LedResource extends CoapResource {
	
	boolean blink = false;
	boolean state = false;
	float threshold;
	//private String gpioPin;
	GpioPinDigitalOutput pin;
		
	public LedResource(String name, int gpioPin) {
		super(name);
		GpioController gpio = GpioFactory.getInstance();
		if(gpioPin==26) {
			this.pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		}
		if (gpioPin==25) {
			this.pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25);
		}
	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond(ResponseCode.CONTENT, state+"", MediaTypeRegistry.TEXT_PLAIN);
	}
	
	public void ledOn() {
		state = true;
		this.pin.setState(state);
		System.out.println(state+"");
	}
	public void ledOff() {
		state = false;
		this.pin.setState(state);
		System.out.println(state+"");
	}
	
	public void blink() {
		state = true;
		this.pin.toggle();
		System.out.println("fake blinking");
	}
		
	
}