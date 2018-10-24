package org.project.stormseeker;

public class Led {
	static LedResource led_red;
	static Sensor tempAndHumidity;
	static float temp;
	static float hum;
	/*static boolean state = false;
	static float threshold;
	//private String gpioPin;
	static GpioPinDigitalOutput pin26;
	
	public Led() {
		System.out.println("Hello pin 26");
		GpioController gpio = GpioFactory.getInstance();
		pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
	}*/
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*System.out.println("Hello pin 26");
		GpioController gpio = GpioFactory.getInstance();
		pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);*/
		/*boolean ledOn = true;
		for (int i=0; i <10;i++){
			pin26.setState(ledOn);
			ledOn = !ledOn;
			Thread.sleep(1000);*/
		/*led_red = new LedResource();
		for (int i=0; i<5; i++) {
			led_red.ledOn();
			System.out.println("Led ON");
			Thread.sleep(1000);
			led_red.ledOff();
			System.out.println("Led OFF");
			Thread.sleep(1000);
		}
		*/
		tempAndHumidity = new Sensor();
		tempAndHumidity.getTemperatureAndHumidity();
		temp = tempAndHumidity.temperature;
		hum = tempAndHumidity.humidity;
		
		System.out.println("Temperatura: " + temp + " Humidity: " + hum + "!");
	}
	
	
	/*
	public static void ledOn() {
		//System.out.println("Hello pin 26");
		/*GpioController gpio = GpioFactory.getInstance();
		pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		state = true;*/
		//GpioController gpio = GpioFactory.getInstance();
		//GpioPinDigitalOutput pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
		/*pin26.setState(state);
	}
	
	public static void ledOff() {
		state = false;
		pin26.setState(state);
	}*/
	
	/*public static void setGpioPin(int pin) {
		gpio_pin= "GPIO_"
		
		
	}*/

}
