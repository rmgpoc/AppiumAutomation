package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
 
public class Screenshot {
	
	private AppiumDriver<MobileElement> driver;
	public static DateFormat dateFormat;
	private final String folderPath = "./src/test/resources/screenshots/";
		
	public Screenshot(AppiumDriver<MobileElement> driver) {		
		this.driver = driver;
		validateFolderExists();
	}
	
	private void validateFolderExists() {
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdir();
	}
		
	public void capture(String fileName) {
		// Set date
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		try {        	    
            String name = folderPath + fileName + dateFormat.format(new Date()) + ".png";                          
			FileOutputStream file = new FileOutputStream(name);
			file.write(
				((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES));
			file.close();        	
		} 
		catch (Exception ex) {
			throw new RuntimeException("cannot create screenshot;", ex);
		}
	        
	}
 
}
