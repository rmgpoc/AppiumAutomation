package models;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AbstractPassenger {
	
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerTitleButton")
	public MobileElement titleBtn;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerFirstNameText")
	public MobileElement firstNameField;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerLastNameText")
	public MobileElement lastNameField;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerDateOfBirthButton")
	public MobileElement dobBtn;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/captionText")
	public MobileElement captionText;
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> selectTitles;
	
	@AndroidFindBy(id="android:id/text1")
	public List<MobileElement> selectAges;
	
	@AndroidFindBy(id="android:id/text1")
	public MobileElement selectTitle;//Adult:Mr, Mrs, Ms, Miss. Child: Mr, Ms. No title for infants
	
	@AndroidFindBy(id="android:id/text1")
	public MobileElement selectAge;//Adult:16, 17, 18+. Child: 2 - 15. No age selection for infants

	public String resourceId;
	
	public String text;
	
	public boolean isComplete(){
		return false;
	}

	public void setData(String tOption, String tCOption, String dobOption, String dobCOption){
		
		titleBtn.click();
		for(MobileElement selectTitle: selectTitles){
			if(text.contains("Adult") && selectTitle.getText().equals(tOption)){
				selectTitle.click();
				break;
			}else if(text.contains("Child") && selectTitle.getText().equals(tCOption)){
				selectTitle.click();
				break;
			}
		}
	
					
		if(firstNameField.getText().isEmpty()){
			firstNameField.sendKeys("Happy");
		}
	
		if(lastNameField.getText().isEmpty()){
			lastNameField.sendKeys("Days");
		} 
	
		dobBtn.click();
		for(MobileElement selectAge: selectAges){
			if(text.contains("Adult") && selectAge.getText().equals(dobOption)){
				selectAge.click();
				break;
			}else if(text.contains("Child") && selectAge.getText().equals(dobCOption)){
				selectAge.click();
				break;
			}
		}
	}
}
