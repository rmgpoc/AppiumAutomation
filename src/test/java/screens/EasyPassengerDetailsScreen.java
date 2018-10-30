package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase2;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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
	
	public void selectTitleOption(String tOption){
		clickTitleBtn();
		for(MobileElement selectTitle: selectTitles){
			if(selectTitle.getText().equals(tOption)){
				selectTitle.click();
				break;
			}
		}
	}
	
	public void adultPassengerDetails(String tOption, String fName, String lName, String dobOption){
		int adultCount = EasyPassengerCountScreen.adultCt;
		for(MobileElement captionText: captionTexts){
			if(captionText.getText().contains("Adult")){
				for(int i=0; i<adultCount; i++){
					scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerTitleButton").get(i).click();
					for(MobileElement selectTitle: selectTitles){
						if(selectTitle.getText().equals(tOption)){
							selectTitle.click();
							break;
						}
					}
					scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerFirstNameText").get(i).click();
					scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerFirstNameText").get(i).sendKeys(fName);
					scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerLastNameText").get(i).click();
					scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerLastNameText").get(i).sendKeys(lName);
					scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerDateOfBirthButton").get(i).click();
					for(MobileElement selectAge: selectAges){
						if(selectAge.getText().equals(dobOption)){
							selectAge.click();
							break;
						}
					}
				}
			}
			break;
		}
	}
	
	public void childPassengerDetails(String tOption, String fName, String lName, String dobOption){
		int passenger = EasyPassengerCountScreen.adultCt + 1;
		String text = "Passenger "+passenger+": Child";
		driver.swipe(500, 1600, 500, 100, 20000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		int childCount = EasyPassengerCountScreen.childCt;
		for(int i=0; i<childCount; i++){
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerTitleButton").get(i).click();
			for(MobileElement selectTitle: selectTitles){
				if(selectTitle.getText().equals(tOption)){
					selectTitle.click();
					break;
				}
			}
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerFirstNameText").get(i).click();
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerFirstNameText").get(i).sendKeys(fName);
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerLastNameText").get(i).click();
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerLastNameText").get(i).sendKeys(lName);
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerDateOfBirthButton").get(i).click();
			for(MobileElement selectAge: selectAges){
				if(selectAge.getText().equals(dobOption)){
					selectAge.click();
					break;
				}
			}
		}
	}

	public void infantPassengerDetails(String fName, String lName){
		int passenger = EasyPassengerCountScreen.adultCt + EasyPassengerCountScreen.childCt + 1;
		//String text = "Passenger "+passenger+": Infant";
		String text = "Continue";
		driver.swipe(500, 1600, 500, 100, 20000);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		int infantCount = EasyPassengerCountScreen.infantCt;
		for(int i=0; i<infantCount; i++){
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerFirstNameText").get(i).click();
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerFirstNameText").get(i).sendKeys(fName);
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerLastNameText").get(i).click();
			scrollView.findElementsById("com.mttnow.droid.easyjet:id/passengerLastNameText").get(i).sendKeys(lName);
		}
	}
	
	public void inputFirstName(String fName){
		firstNameField.click();
		firstNameField.sendKeys(fName);
	}
	
	public void inputLastName(String lName){
		lastNameField.click();
		lastNameField.sendKeys(lName);
	}
	
	public void clickDOBBtn(){
		dobBtn.click();
	}
	
	public void selectDOBOption(String dobOption){
		clickDOBBtn();
		for(MobileElement selectAge: selectAges){
			if(selectAge.getText().equals(dobOption)){
				selectAge.click();
				break;
			}
		}
	}
	
	public void clickContinueBtn(){
		submitButton.click();
	}
	
	public void passengerCount(String adult, String tOption, String fName, String lName, String dobOption){
		int captions = captionTexts.size();
		if(captions == 1){
			for(MobileElement captionText: captionTexts){
				if(captionText.getText().contains("Adult")){
					addAdultPassengerDetail(tOption, fName, lName, dobOption);
				}else if(captionText.getText().contains("Child")){
					addChildPassengerDetail(tOption, fName, lName, dobOption);
				}else if(captionText.getText().contains("Infant")){
					addInfantPassengerDetail(fName, lName);
				}
				clickContinueBtn();
			}
		}else{
			for(MobileElement captionText: captionTexts){
				if(captionText.getText().contains("Adult")){
					addAdultPassengerDetails(tOption, fName, lName, dobOption);
				}else if(captionText.getText().contains("Child")){
					addChildPassengerDetails(tOption, fName, lName, dobOption);
				}else if(captionText.getText().contains("Infant")){
					addInfantPassengerDetails(fName, lName);
				}		
				clickContinueBtn();
			}
		}
	}
	
	public void addAdultPassengerDetails(String tOption, String fName, String lName, String dobOption){
		int adultCount = EasyPassengerCountScreen.adultCt;
		if(adultCount==1){
			addAdultPassengerDetail(tOption, fName, lName, dobOption);	
		}else{
			adultPassengerDetails(tOption, fName, lName, dobOption);
		}
	}
	
	public void addAdultPassengerDetail(String tOption, String fName, String lName, String dobOption){
		selectTitleOption(tOption);//Mr, Ms, Mrs, Miss
		inputFirstName(fName);
		inputLastName(lName);
		selectDOBOption(dobOption);//16, 17, 18+
	}
	
	public void addChildPassengerDetails(String tOption, String fName, String lName, String dobOption){
		int childCount = EasyPassengerCountScreen.childCt;
		if(childCount==1){
			addChildPassengerDetail(tOption, fName, lName, dobOption);	
		}else{
			childPassengerDetails(tOption, fName, lName, dobOption);
		}
	}
	
	public void addChildPassengerDetail(String tOption, String fName, String lName, String dobOption){
		int passenger = EasyPassengerCountScreen.adultCt + 1;
		String text = "Passenger "+passenger+": Child";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		selectTitleOption(tOption);//Mr, Ms
		inputFirstName(fName);
		inputLastName(lName);
		selectDOBOption(dobOption);//2-15
	}
	
	public void addInfantPassengerDetails(String fName, String lName){
		int infantCount = EasyPassengerCountScreen.infantCt;
		if(infantCount==1){
			addInfantPassengerDetail(fName, lName);	
		}else{
			infantPassengerDetails(fName, lName);
		}
	}
	
	public void addInfantPassengerDetail(String fName, String lName){
		int passenger = EasyPassengerCountScreen.adultCt + EasyPassengerCountScreen.childCt + 1;
		String text = "Passenger "+passenger+": Infant";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		inputFirstName(fName);
		inputLastName(lName);
	}
	
	public void addAdultPassengerCountDetails(int count, String tOption, String fName, String lName, String dobOption){
		if(count==1){
			addAdultPassengerDetails(tOption, fName, lName, dobOption);
		}else{
			for(int i=0; i<count; i++){
				addAdultPassengerDetails(tOption, fName, lName, dobOption);
			}			
		}
	}
	
	public void addChildPassengerCountDetails(int count, String tOption, String fName, String lName, String dobOption){
		if(count==0){
			log.debug("No Child travelling");
		}else if(count==1){
			addChildPassengerDetail(tOption, fName, lName, dobOption);
		}else{
			for(int i=0; i<count; i++){
				addChildPassengerDetail(tOption, fName, lName, dobOption);
			}			
		}
	}
	
	public void addInfantPassengerCountDetails(int count, String fName, String lName){
		if(count==0){
			log.debug("No Infant travelling");
		}else if(count==1){
			addInfantPassengerDetail(fName, lName);
		}else{
			for(int i=0; i<count; i++){
				addInfantPassengerDetail(fName, lName);
			}			
		}
	}
	

}
