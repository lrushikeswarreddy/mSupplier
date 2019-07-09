package com.cr.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends Component {
	WebElement uniqId=null;
    String parentId=null;
    String label="";
  /**
   * Find the Button base on the label
   * @param label
   * @return true if found, else false
   * 
   */
	public boolean findByLabel(String label) {
		this.label=label;
		try{
			parentId="//input[@value='"+label+"']";
			uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(label)));
			//reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"Page","Button"+label+"is found","pass");
			 return true;
		}catch(Exception e){
			//reportEvent.Status(e1.getClassName().toString().replace("com.ung.vbr.panels.","")+"page","button"+label+"is Not Found","Fail");
			return false;
		}
	}
	/**
	 * Find button based on Xpath ideally used a page has more then one element withsame label
	 * @param btnXpath
	 */
	 public void findByXpath(String btnXpath){
		 try{
			 uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnXpath)));
		//	 reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","Button with Xpath"+btnXpath+"is found","pass");
		 }catch(Exception e){
		//	 reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","Button with Xpath"+btnXpath+"is Not found","Fail");
			 return;
			 
		 }
	 }
	 /**
	  * Clicks the button identified by Label
	  */
    public void click(){
   	 try{
   		 uniqId.click();
   		// reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","Button"+label+"is clcicked","Pass");
   	 }catch(Exception e){
   		// reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","Button"+label+"isNot Clicked","Fail");
   		 
   	 }
    }
   	 
   	 /**
   	  * validates the button is enabled
   	  * @return true if enabled,else false
   	  */
   	 public boolean isButtonEnabled(){
   		 return uniqId.isEnabled();
   	 }
   	 /**
   	  * validates the button is present
   	  * @return true if enabled,else false
   	  */
   	 public boolean isButtonPresent(String strButtonLabel){
   		 boolean btnPresent=false;
   		 ;
   		   		 if (findByLabel(strButtonLabel)){
   			 btnPresent=true;
   		 }
   		 return btnPresent;
   
   	 
    
   	 
    }


}
