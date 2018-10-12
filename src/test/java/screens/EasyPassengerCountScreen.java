package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EasyPassengerCountScreen extends ScreenBase{

	public EasyPassengerCountScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/numOfAdults")
	public MobileElement numOfAdultsText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/adultsPlus")
	public MobileElement adultsPlusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/adultsMinus")
	public MobileElement adultsMinusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/addPassengersTitle")
	public MobileElement logPage;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/numOfChildren")
	public MobileElement numOfChildrenText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/childrenPlus")
	public MobileElement childrenPlusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/childrenMinus")
	public MobileElement childrenMinusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/numOfInfants")
	public MobileElement numOfInfantsText;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/infantsPlus")
	public MobileElement infantsPlusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/infantsMinus")
	public MobileElement infantsMinusBtn;
	
	@AndroidFindBy(id="com.mttnow.droid.easyjet:id/submit_button")
	public MobileElement doneBtn;
	
	public void addAdultNumber(int adultCount){
		int countAdult = Integer.parseInt(numOfAdultsText.getText());
		if (countAdult<adultCount){
			addAdultCount(adultCount);
		}else if (countAdult>adultCount){
			minusAdultCount(adultCount);
		}
	}
	
	public void addAdultCount(int adultCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/adultsPlus");
			for(int i=1; i<adultCount; i++){
				adultsPlusBtn.click();			
			}

	}
	
	public void minusAdultCount(int adultCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/adultsMinus");
		int countAdult = Integer.parseInt(numOfAdultsText.getText());
		for(int i=countAdult; i>adultCount; i--){
			adultsMinusBtn.click();			
		}		
	}
	
	public void addChildNumber(int childCount){
		int countChild = Integer.parseInt(numOfChildrenText.getText());
		if (countChild<childCount){
			addChildNumberBtn(childCount);
		}else if (countChild>childCount){
			minusChildNumberBtn(childCount);
		}
	}
	
	public void addChildNumberBtn(int childCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/childrenPlus");
		for(int i=0; i<childCount; i++){
			childrenPlusBtn.click();
		}
	}
	
	public void minusChildNumberBtn(int childCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/childrenMinus");
		int countChild = Integer.parseInt(numOfChildrenText.getText());
		for(int i=countChild; i>childCount; i--){
			childrenMinusBtn.click();
		}
	}
	
	public void addInfantNumber(int infantCount){
		int countInfant = Integer.parseInt(numOfInfantsText.getText());
		if (countInfant<infantCount){
			addInfantNumberBtn(infantCount);
		}else if (countInfant>infantCount){
			minusInfantNumberBtn(infantCount);
		}
	}
	
	public void addInfantNumberBtn(int infantCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/infantsPlus");
		for(int i=0; i<infantCount; i++){
			infantsPlusBtn.click();
		}
	}
	
	public void minusInfantNumberBtn(int infantCount){
		waitforElementPresence(5, "com.mttnow.droid.easyjet:id/infantsMinus");
		int countInfant = Integer.parseInt(numOfInfantsText.getText());
		for(int i=countInfant; i>infantCount; i--){
			infantsMinusBtn.click();
		}
	}
	
	public void doneBtn(){
		doneBtn.click();
	}
	
	public void addPassengerCount(int adultCount, int childCount, int infantCount){
		log.debug("*******Testing is being executed on: " + logPage.getText().trim() + " Screen.*******");
		addAdultNumber(adultCount);
		addChildNumber(childCount);
		addInfantNumber(infantCount);
		doneBtn();
	}

}
