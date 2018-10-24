package org.project.stormseeker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class SensorTest {
	
	@Test
	void getTemperatureTest() throws Exception {
		
		float temperatureTest = 22;
		float temperatureDelta = 10;
		Sensor s = new Sensor();
		s.getTemperatureAndHumidity();
		//assertNotNull(s.temperature);
		assertEquals(temperatureTest,s.temperature,temperatureDelta);
	}
	
	@Test
	void getHumidityTest() throws Exception {
		float humidityTest  = 80;
		float humidityDelta = 10;
		
		Sensor s = new Sensor();
		s.getTemperatureAndHumidity();
		assertEquals(humidityTest, s.humidity, humidityDelta);
		
	}
	
}
