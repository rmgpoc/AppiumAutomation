package utility;

import java.io.File;
import java.io.IOException;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AppiumServer {
	
	//Starting the Appium Server
	
	public static AppiumDriverLocalService service;
	
	public static void start() {
		
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\ugbene.ositadinma\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\Appium.log")));
		
		service.start(); 

	}

	
	//Stopping the Appium Server
	
	public static void stop() throws IOException {

		service.stop();
	}


}
