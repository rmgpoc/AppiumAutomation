package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyTravelSportsEquipmentScreen extends ScreenBase{

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public EasyTravelSportsEquipmentScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/sport_background_wrapper")
	public List<MobileElement> sportsWrapper;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/plus_btn")
	public List<MobileElement> plusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/minus_btn")
	public List<MobileElement> minusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/count_text")
	public List<MobileElement> countText;
	
	@AndroidFindBy(className="android.widget.TextView")
	public List<MobileElement> textView;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/smallItemCost")
	public MobileElement smallItemEquipCost;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/largeItemCost")
	public MobileElement largeItemEquipCost;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/additionalCost")
	public MobileElement additionalCost;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submitButton")
	public MobileElement submitButton;
	
	public void addGolfEquipment20kg(int count){
		log.debug("*******Testing is being executed on: " + textView.get(1).getText().trim() + " Screen.*******");
		if(count == 0){
			log.debug("*******Golf Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusGolfEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(0).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSkiEquipment20kg(int count){
		if(count == 0){
			log.debug("*******Ski Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusSkiEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(1).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSnowboardEquipment20kg(int count){
		if(count == 0){
			log.debug("*******Snowboard Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusSnowboardEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(2).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addSportFirearmsEquipment20kg(int count){
		if(count == 0){
			log.debug("*******SportFirearms Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusSportFirearmsEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(3).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addOtherSmallSportsEquipment20kg(int count){
		if(count == 0){
			log.debug("*******Other Small Sports Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusOtherSmallSportsEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(4).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addBicycleEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Bicycle Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusBicycleEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(5).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addCanoeEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Canoe/Kayak Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusCanoeEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(6).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addWindSurferEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Wind Surfer Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusWindSurferEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(7).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void addHangGliderEquipment32kg(int count){
		if(count == 0){
			log.debug("*******Hang Glider Equipment not required*******");
		}else{
			for(int i=0; i<count; i++){
				sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/plus_btn").click();
			}
		}
	}
	
	public void minusHangGliderEquipment20kg(int count){
		int equipCount = Integer.parseInt(sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/count_text").getText());
		for(int i=equipCount; i>count; i--){
			sportsWrapper.get(8).findElementById("com.mttnow.droid.easyjet:id/minus_btn").click();
		}
	}
	
	public void totalSportsEquipAddtionalCost(){
		log.debug("*******Additional Sports Equipment Cost is " + additionalCost.findElementsByClassName("android.widget.TextView").get(1).getText().trim() + additionalCost.findElementsByClassName("android.widget.TextView").get(2).getText().trim() + ":" + additionalCost.findElementsByClassName("android.widget.TextView").get(3).getText().trim() + ".*******");
	}
	
	public void submitButton(){
		submitButton.click();
	}
	
	public void addSportsEquipment(int GolfCount, int SkiCount, int SnowBoardCount, int FirearmsCount, int SmallEquipCount, int BicycleCount, int CanoeCount, int WindSurferCount, int HangGliderCount){
		log.debug("*******"+smallItemEquipCost.getText()+"*******");
		addGolfEquipment20kg(GolfCount);
		addSkiEquipment20kg(SkiCount);
		addSnowboardEquipment20kg(SnowBoardCount);
		addSportFirearmsEquipment20kg(FirearmsCount);
		addOtherSmallSportsEquipment20kg(SmallEquipCount);
		log.debug("*******"+largeItemEquipCost.getText()+"*******");
		addBicycleEquipment32kg(BicycleCount);
		addCanoeEquipment32kg(CanoeCount);
		addWindSurferEquipment32kg(WindSurferCount);
		addHangGliderEquipment32kg(HangGliderCount);
		totalSportsEquipAddtionalCost();
		submitButton();
	}

}
