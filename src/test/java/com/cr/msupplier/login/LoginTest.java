package com.cr.msupplier.login;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.cr.panels.Panel;

import objectrepo.LoginObjectRepo;

public class LoginTest extends Panel{
	
	@Test
	@Parameters({"strDatalocation","strDatasheet","Browser"})
	public void TestSetup(String strDatalocation,String strDatasheet,String Browser){
		
		LoginTest gl=new LoginTest(); 
		try{
			gl.setup(strDatalocation, strDatasheet, Browser);
			gl.test();
			driver.quit();
			Reporter.log("Test Script pass");
		}catch(Exception e){
			e.printStackTrace();
			Reporter.log(" Test Script fail");
		}
       }
	
	public void test()  throws Exception {
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("lrushikeswarreddy@gmail.com");
		
		
		  textfield.findByXpath(LoginObjectRepo.username);
		  data.setActiveSheet("Gmail");
		  textfield.setValue(data.getIterationData("UserName", 1));
		  textfield.findByXpath(LoginObjectRepo.pwd);
		  textfield.setValue("Siri@145");
		  
		  button.findByXpath(LoginObjectRepo.Submit); 
		  button.click();
		 }
}

