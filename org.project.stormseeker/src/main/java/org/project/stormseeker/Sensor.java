package org.project.stormseeker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sensor {
	float humidity = 0;
	float temperature = 0;
	
	String humidityMeasure;
	String temperatureMeasure;
		
	private String line;
	private String[] data;
	
	public void getTemperatureAndHumidity() throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("python /home/pi/teste_python_sensor_2.py");
		BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
		///System.out.println(line);
		if ((line = bri.readLine())!= null) {
			data = line.split(";");
			//System.out.println(data);
			temperature = Float.parseFloat(data[0]);
			humidity = Float.parseFloat(data[1]);
		}
		
		bri.close();
		p.waitFor();
		
	}
	
}
