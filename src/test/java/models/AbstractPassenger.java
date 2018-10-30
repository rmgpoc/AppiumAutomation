package models;

import io.appium.java_client.MobileElement;

public abstract class AbstractPassenger {
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerTitleButton")
	public MobileElement titleBtns;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerFirstNameText")
	public MobileElement firstNameFields;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerLastNameText")
	public MobileElement lastNameFields;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/passengerDateOfBirthButton")
	public MobileElement dobBtns;
	
	//@AndroidFindBy(id="com.mttnow.droid.easyjet:id/captionText")
	public MobileElement captionTexts;
	
	//@AndroidFindBy(id="android:id/text1")
	public MobileElement selectTitles;//Adult:Mr, Mrs, Ms, Miss. Child: Mr, Ms. No title for infants
	
	//@AndroidFindBy(id="android:id/text1")
	public MobileElement selectAges;//Adult:16, 17, 18+. Child: 2 - 15. No age selection for infants

	

}
