package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.Pom.EnterTimeTrackPage;
import com.actitime.Pom.TaskListPage;
import com.actitime.generic.BaseClass;
@Listeners(com.actitime.generic.ListenerImplementation.class)

public class CustomerModule extends BaseClass {


	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		
		String customerName = f.getExcelData("CreateCustomer",2,2);
		String customerDescription = f.getExcelData("CreateCustomer", 2, 3);
		Reporter.log("CreateCustomer",true);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustOptions().click();
		t.getEnterCustNameTbx().sendKeys(customerName);
		t.getEnterCustDescTbx().sendKeys(customerDescription);
		t.getSelectCustDD().click();
		t.getOurCompany().click();
		t.getCreateCustBtn().click();
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomer(), customerName));
		//String actualCustText = t.getActualCustomer().getText();
		//Assert.assertEquals(actualCustText, customerName);
	}


}
