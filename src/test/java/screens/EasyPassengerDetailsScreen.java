package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerTitleButton")
	public MobileElement titleBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerTitleButton")
	public List<MobileElement> titleBtns;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerFirstNameText")
	public MobileElement firstNameField;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerFirstNameText")
	public List<MobileElement> firstNameFields;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerLastNameText")
	public MobileElement lastNameField;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerLastNameText")
	public List<MobileElement> lastNameFields;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerDateOfBirthButton")
	public MobileElement dobBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerDateOfBirthButton")
	public List<MobileElement> dobBtns;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/captionText")
	public MobileElement captionText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/captionText")
	public List<MobileElement> captionTexts;
	
	@AndroidFindBy(className="android.widget.ScrollView")
	public MobileElement scrollView;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	public List<MobileElement> linearLayout;	
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> selectTitles;//Adult:Mr, Mrs, Ms, Miss. Child: Mr, Ms. No title for infants
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> selectAges;//Adult:16, 17, 18+. Child: 2 - 15. No age selection for infants
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submitButton")
	public MobileElement submitButton;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/actionbar_home_logo")
	public MobileElement homeLogo;
	
	public void homeLogo(){
		homeLogo.click();
	}
	
	public void clickTitleBtn(){
		titleBtn.click();
	}
	//List<AbstractPassenger> 
	public void getPassengers(){
		List<AbstractPassenger> passengers = null;
		
		int count = EasyPassengerCountScreen.adultCt+= EasyPassengerCountScreen.childCt+EasyPassengerCountScreen.infantCt;
		log.debug("*******Number of Passengers is "+count+"*******");
		for(int i=0; i<count; i++){
			int pcount = i + 1;
			String text = "Passenger "+pcount;
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
			List<MobileElement> captions = scrollView.findElements(MobileBy.xpath("//*"));
			System.out.println("******* Passenger "+pcount+"******* "+captions.size()+" ******* ");
			log.debug("******* "+text+"******* "+captions.size()+"******* ");
		}
		
	}
	

}
