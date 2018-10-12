package screens;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

import base.ScreenBase;
import base.ScreenBase2;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyAddExtraScreen extends ScreenBase2{
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyAddExtraScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plus_btn")
	public MobileElement plusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/minus_btn")
	public MobileElement minusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/count_text")
	public MobileElement countText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/hold_luggage_price")
	public MobileElement luggagePriceText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plusNumberPickerView")
	public List<MobileElement> plusNumberPickerView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/title")
	public MobileElement title;
	
	@AndroidFindBy(className="android.widget.ScrollView")
	public List<MobileElement> scrollView;
	
	@AndroidFindBy(className="android.widget.LinearLayout")
	public List<MobileElement> linearLayout;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> textView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/sports_equip_frg_sports_button")
	public MobileElement addSportsEquip;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/text")
	public MobileElement sportsEquipText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/price")
	public MobileElement sportsEquipPrice;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/priceText")
	public MobileElement priceText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/pricingBreakDownLink")
	public MobileElement pricingBreakDownLink;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submitButton")
	public MobileElement passengerDetailsSubmitBtn;
	
	public void logPage(){
		List<String> price = new ArrayList<String>();
		List<MobileElement> selectFlexi = linearLayout.get(2).findElementsByClassName("android.widget.TextView");
		for(int i=0; i<selectFlexi.size(); i++){
			price.add(selectFlexi.get(i).getText());
			System.out.println(selectFlexi.get(i).getText());
		}
		log.debug("*******Testing is being executed on: " + selectFlexi.get(1).getText().trim() + " Screen.*******");
		
	}
	
	public void addBag15kg(int bag){
		logPage();
		if(bag == 0){
			log.debug("*******15kg bag not required*******");
		}else{
			for(int i=0; i<bag; i++){
				plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusBag15kg(int bag){
		int bagCount = Integer.parseInt(plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=bagCount; i>bag; i--){
				plusNumberPickerView.get(0).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addBag23kg(int bag){
		logPage();
		if(bag == 0){
			log.debug("*******23kg bag not required*******");
		}else{
			for(int i=0; i<bag; i++){
				plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusBag23kg(int bag){
		int bagCount = Integer.parseInt(plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=bagCount; i>bag; i--){
				plusNumberPickerView.get(1).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void getLuggagePrice(){
		logPage();
		List<String> price = new ArrayList<String>();
		List<MobileElement> selectFlexi = linearLayout.get(2).findElementsByClassName("android.widget.TextView");
		for(int i=0; i<selectFlexi.size(); i++){
			price.add(selectFlexi.get(i).getText());
			System.out.println(selectFlexi.get(i).getText());
		}
		log.debug("*******Additional Luggage Cost is " + selectFlexi.get(6).getText().trim() +" "+ selectFlexi.get(9).getText().trim() +" "+ selectFlexi.get(11).getText().trim() + selectFlexi.get(12).getText().trim() + ":" + selectFlexi.get(13).getText().trim() + ".*******");
		
	}
	public void addSportsEquipBtn(){
		addSportsEquip.click();
	}
	
	public void finalPrice(){
		String scrollDown = "Final Price";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+scrollDown+"\").instance(0))");
		List<MobileElement> luggagePrice = linearLayout.get(4).findElementsByClassName("android.widget.TextView");
		log.debug("*******Luggage Cost is " + luggagePrice.get(1).getText().trim() + luggagePrice.get(2).getText().trim() + ":" + luggagePrice.get(3).getText().trim() + ".*******");
		log.debug("*******Sports Equipment Cost is " + sportsEquipPrice.getText()+"*******");
		
		List<MobileElement> depPricelevel = linearLayout.get(20).findElementsByClassName("android.widget.TextView");
		log.debug("*******Outbound Flight Cost is " + depPricelevel.get(2).getText().trim() + depPricelevel.get(3).getText().trim() + ":" + depPricelevel.get(4).getText().trim() + ".*******");
		
		List<MobileElement> arrPricelevel = linearLayout.get(16).findElementsByClassName("android.widget.LinearLayout");
		List<MobileElement> inboundPrice = arrPricelevel.get(6).findElementsByClassName("android.widget.TextView");
		log.debug("*******Inbound Flight Cost is " + inboundPrice.get(2).getText().trim() + inboundPrice.get(3).getText().trim() + ":" + inboundPrice.get(4).getText().trim() + ".*******");
		
		List<MobileElement> totalPricelevel = linearLayout.get(7).findElementsByClassName("android.widget.LinearLayout");
		List<MobileElement> totalPric = totalPricelevel.get(1).findElementsByClassName("android.widget.LinearLayout");
		List<MobileElement> totalPrice = totalPric.get(1).findElementsByClassName("android.widget.TextView");
		log.debug("*******Total Flight Cost is " + totalPrice.get(1).getText() + totalPrice.get(2).getText() + ":" + totalPrice.get(3).getText() + ".*******");
		
		List<MobileElement> test = linearLayout.get(20).findElementsByClassName("android.widget.TextView");
		log.debug("*******Test Cost is " + test.get(5).getText() + test.get(6).getText() + ":" + test.get(7).getText() + ".*******");

		List<MobileElement> totalPriceleve = linearLayout.get(6).findElementsByClassName("android.widget.LinearLayout");
		List<MobileElement> totalPri = totalPriceleve.get(0).findElementsByClassName("android.widget.LinearLayout");
		List<MobileElement> totalP = totalPri.get(1).findElementsByClassName("android.widget.TextView");
		log.debug("*******Total Flight Cost is " + totalP.get(1).getText() + totalP.get(2).getText() + ":" + totalP.get(3).getText() + ".*******");
		
//		Total Flight Cost is Sports Equip. x2£164.00:Belfast Intl (BFS).*******
//		*******Test Cost is 13:10Arrives BFS:14:25.*******
//		
//		12/10/2018 09:50:00 devpinoyLogger *******Total Flight Cost is Belfast Intl (BFS)Arrives BFS:14:25.*******
//		12/10/2018 09:50:02 devpinoyLogger *******Test Cost is 16:30Arrives LTN:17:40.*******
//		12/10/2018 09:50:04 devpinoyLogger *******Total Flight Cost is London Luton (LTN)Belfast Intl (BFS):Departs LTN.*******
		
		passengerDetailsSubmitBtn();
	}
	
	public void passengerDetailsSubmitBtn(){
		passengerDetailsSubmitBtn.click();
	}

}
