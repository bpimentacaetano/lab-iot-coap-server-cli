package org.project.stormseeker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LedTest {
	
	/*static LedResource led;
		
	@BeforeEach
	static void setUpBeforeClass() throws Exception{
		led = new LedResource("led",26);
		System.out.println("led created");
	}*/
	
	
	@Test
	 void initialState() throws Exception {
		LedResource led = new LedResource("led",26);
		assertFalse(led.state);
		System.out.println("Run!!!!");
	}
	
	@Test
	void ledOnTest() throws Exception {
		LedResource led_2 = new LedResource("led_2",26);
		led_2.ledOn();
		assertTrue(led_2.state);
	}
	
	@Test
	void ledOffTest() throws Exception {
		LedResource led = new LedResource("led", 26);
		led.ledOff();
		assertFalse(led.state);
		
	}
	
	@Test
	void blinkTest() throws Exception {
		LedResource led = new LedResource("led", 26);
		led.blink();
		assertTrue(led.state);
	}
}
