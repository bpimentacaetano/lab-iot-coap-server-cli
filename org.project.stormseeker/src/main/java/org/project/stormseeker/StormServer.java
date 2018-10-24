package org.project.stormseeker;

//import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;

public class StormServer extends CoapServer {

	public static void main(String[] args) {
		
		//Create the server
		StormServer stormServer = new StormServer();
		
		//A hello world resource example
		HelloWorldResource hello = new HelloWorldResource("hello-world");
		stormServer.add(hello);
		
		//This resource store the maximum temperature value selected by the user
		ThresholdResource tempThreshold = new ThresholdResource("temp-threshold");
		stormServer.add(tempThreshold);
		
		//This resource Store the maximum temperature value selected by the user
		ThresholdResource humThreshold = new ThresholdResource("hum-threshold");
		stormServer.add(humThreshold);
		
		//Create the leds resource red to temperature e green to humidity
		LedResource red = new LedResource("red-led",26);
		LedResource green = new LedResource("green-led",25);
		stormServer.add(red,green);
		
		//Sensor resource
		SensorResource tempRes = new SensorResource("orchestrator",red, green, tempThreshold, humThreshold);
		tempRes.setObservable(true);
		tempRes.getAttributes().setObservable();
		stormServer.add(tempRes);
		
		stormServer.start();
	}

}
