package screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase2;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import models.AbstractPassenger;

public class EasyPassengerDetailsScreen extends ScreenBase2{

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyPassengerDetailsScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	@AndroidFindBy(className="android.widget.ScrollView")
	public MobileElement scrollView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/captionText")
	public MobileElement caption;
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> selectTitles;
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> selectAges;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submitButton")
	public MobileElement submitButton;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/actionbar_home_logo")
	public MobileElement homeLogo;
	
	public void homeLogo(){
		homeLogo.click();
	}

	private List<AbstractPassenger> passengers = new ArrayList<AbstractPassenger>();
	
	private List<String> captionList = new ArrayList<String>();
	
	private int lastKnownCaption = 1;
	
	public boolean passengerExist(String text){
		
		for(String p : captionList){
			
			if(p.equals(text)){
				return true;
			}
		}
		
		return false;
	}
	
	public void  getPassengers(int count, int seed){
						
		if(lastKnownCaption  >= seed){
			submitButton.click();
			return;			
		}
		
		//log.debug("*******Number of Passengers is "+count+"*******");
		//List<AbstractPassenger> passengers = new ArrayList<AbstractPassenger>();
		AbstractPassenger currentPassenger = null;
		
		String lastElementOnScreen = "Continue";
		String text = "Passenger " + lastKnownCaption;
		//lastKnownCaption = lastKnownCaption==null? text : lastKnownCaption;
		//driver.swipe(500, 1585, 500, 138, 2000);
		
		if(caption.getText().startsWith(text)){
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		}else{
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+lastElementOnScreen+"\").instance(0))");
		}
		
		List<MobileElement> captions = scrollView.findElements(MobileBy.xpath("//*"));
			
		for(MobileElement mb: captions){
			
			String resourceId = mb.getAttribute("resourceId");
				
			if(null == resourceId) continue;
				
			log.debug(mb.getAttribute("resourceId"));
							
			//if(mb.getText().contains("Passenger ")){
			if(resourceId.equals("com.mttnow.droid.easyjet:id/captionText")){
				if(passengerExist(mb.getText())){
					currentPassenger=null;
					continue;
				}
				log.debug("*******Number of Passengers is "+ mb.getText() +"*******");
					
				AbstractPassenger currentPassenger1  = new AbstractPassenger();
				currentPassenger = currentPassenger1;
				currentPassenger1.resourceId = resourceId;
				currentPassenger1.text = mb.getText();
				passengers.add(currentPassenger1);
				captionList.add(mb.getText());
				lastKnownCaption += 1; 
				currentPassenger1.captionText = mb;
					
			}
			else if(currentPassenger!=null && resourceId.equals("com.mttnow.droid.easyjet:id/passengerTitleButton")){
					currentPassenger.titleBtn = mb;
			}
			else if(currentPassenger!=null && resourceId.equals("com.mttnow.droid.easyjet:id/passengerFirstNameText")){
					currentPassenger.firstNameField = mb;
			}				
			else if(currentPassenger!=null && resourceId.equals("com.mttnow.droid.easyjet:id/passengerLastNameText")){
					currentPassenger.lastNameField = mb;
			}				
			else if(currentPassenger!=null && resourceId.equals("com.mttnow.droid.easyjet:id/passengerDateOfBirthButton")){
					currentPassenger.dobBtn = mb;
			}				
		}
			
		for(AbstractPassenger passenger : passengers){
			passenger.setData(text, text, text, text);				
		}			
			
		getPassengers(++count, seed);			
	}
	
}
