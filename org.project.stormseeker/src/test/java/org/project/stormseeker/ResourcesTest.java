package org.project.stormseeker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Request;


public class ResourcesTest {
	
	//temp-threshold
	
	@Test
	void tempGETTest() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/temp-threshold");
		Request request = new Request(Code.GET);
		CoapResponse coapResp = client.advanced(request);
		System.out.println(Utils.prettyPrint(coapResp));
		assertTrue(coapResp.isSuccess());
	}
	
	@Test
	void tempPOSTTest() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/temp-threshold");
		//Request request = new Request(Code.POST);
		CoapResponse coapResp = client.post("90", MediaTypeRegistry.TEXT_PLAIN);
		//System.out.println("teste post");
		//System.out.println(coapResp.getCode());
		assertTrue(coapResp.isSuccess());
	}
	@Test
	void tempPUTTest() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/temp-threshold");
		//Request request = new Request(Code.POST);
		CoapResponse coapResp = client.put("80", MediaTypeRegistry.TEXT_PLAIN);
		//System.out.println("teste post");
		//System.out.println(coapResp.getCode());
		assertTrue(coapResp.isSuccess());
	}
	
	//hum-threshold
	@Test
	void humGETTest() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/hum-threshold");
		Request request = new Request(Code.GET);
		CoapResponse coapResp = client.advanced(request);
		System.out.println(Utils.prettyPrint(coapResp));
		assertTrue(coapResp.isSuccess());
	}
	
	@Test
	void humPOSTTest() throws Exception {
		CoapClient client = new CoapClient("coap://192.168.106:5683/hum-threshold");
		//Request request = new Request(Code.POST);
		CoapResponse coapResp = client.post("90", MediaTypeRegistry.TEXT_PLAIN);
		System.out.println("teste post");
		System.out.println(coapResp.getCode());
		assertTrue(coapResp.isSuccess());
	}	
	
		@Test
	void humPUTTest() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/hum-threshold");
		//Request request = new Request(Code.POST);
		CoapResponse coapResp = client.put("80", MediaTypeRegistry.TEXT_PLAIN);
		//System.out.println("teste post");
		//System.out.println(coapResp.getCode());
		assertTrue(coapResp.isSuccess());
	}
	
	//red-led
	@Test
	void ledTempGET() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/red-led");
		Request request = new Request(Code.GET);
		CoapResponse coapResp = client.advanced(request);
		System.out.println(Utils.prettyPrint(coapResp));
		assertTrue(coapResp.isSuccess());
	}
	
	//green-led
	@Test
	void ledHumGET() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/green-led");
		Request request = new Request(Code.GET);
		CoapResponse coapResp = client.advanced(request);
		System.out.println(Utils.prettyPrint(coapResp));
		assertTrue(coapResp.isSuccess());
	}
	
	//sensor
	@Test
	void SensorGET() throws Exception {
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/orchestrator");
		Request request = new Request(Code.GET);
		CoapResponse coapResp = client.advanced(request);
		System.out.println(Utils.prettyPrint(coapResp));
		assertTrue(coapResp.isSuccess());
	}
}

	