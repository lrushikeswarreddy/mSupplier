package com.cr.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBox extends Component{
	WebElement uniqId=null;
	String parentId=null;
	String label="";
	/**
	 * Find the check box based on the label
	 * @param label
	 * @return true if found,else false
	 */
	public boolean findByLabel(String label){
		this.label=label;
		try{
			parentId="//input[@value='"+label+"']";
		    uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentId)));
		    return true;
		}catch(Exception e){
			//reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","Checkbox "+label+"is Not found","FAIL");
	         return false;
		}
	}
	/**
	 * find checkbox based on Xpath, ideally used when a page has more then one element with
	 * @param chkXpath
	 * @return true if found, else false
	 * 
	 */
   public boolean findByXpath(String chkXpath){
	   try{
		   uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(chkXpath)));
		//	reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","Check box with Xpath"+chkXpath+"is  found","pass");
	        return true;
	 }catch(Exception e){
		// reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page"," Check box with Xpath"+chkXpath+"is NOT found","FAIL");
	    return false;
	 }
   }
   /**
    * check the check box identified
    */
   public void selectCheckBox(){
	   try{
		   if(!uniqId.isSelected()){
			   uniqId.click();
			//   reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","check Box"+label+"is Selected","Pass");
		   }
		   else{
			//   reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","check Box"+label+"is Selected","Pass"); 
		   }
	}catch(Exception e){
		//reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","check Box"+label+"is NOT Selected","FAIL"); 
	}
   }
	   /**
	    * un-check the check box identified
	    */
	   public void deselectCheckBox(){
		   try{
			    if(!uniqId.isSelected()){
			    	
			   // 	reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","check Box"+label+"is  deselected","PASS");	
			    }
			    else{
			    	  uniqId.click();
			    //	  reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","check Box"+label+"is  deselected","PASS");
			    }
		   }catch(Exception e){
			    //     reportEvent.Status(e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","check Box"+label+"isNOT  deselected","FALL"); 
		   }
	   }
	   /**
	    * validates the check box is enabled
	    * @return true if enabled ,else false
	    */
	   public boolean isCheckBOxEnabled(){
		   return uniqId.isEnabled();
	   }
 
   
   
   
   
}

 
