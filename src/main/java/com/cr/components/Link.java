package com.cr.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Link extends Component {
	WebElement uniqId=null;

//  /**
//  *Find the link with text
//  *@return 
//  */
//  private void findLink(String strLabel){
//  	StackTraceElement el = new Exception("DEBUG").getStackTrace()[1];
//	try{
//	   uniqId=Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+strLabel+"')]")));
//	  reportEvent.Status(el.getclassName().toString().replace("uiToolKit.panels.","")+"Page","link "+strLabel, "PASS");
//	}catch(Exception e){
//		report.Event.Status(el.getClassName().toString().replace("uiToolKit.panels.","")+"Page","link" +strLabel +"Not found","FAIL");
	
//   }


	/**
	* clicks the link based on the label
	* @param label

	*/
	
	public void click (String label){
		try{
			
			uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(label)));
			uniqId.click();
			//reportEvent.Status("Link click Event","Link'"+label+"' is clicked","PASS");
		}catch(Exception e){
		//	reportEvent.Status("Link click Event","Link'"+label+"' is not clicked","Fail");
		}
	}
	
	public void xpathClick (String xpath){
		try{
			
			uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			uniqId.click();
			//reportEvent.Status("Link click Event","Link'"+xpath+"' is clicked","PASS");
		}catch(Exception e){
			//reportEvent.Status("Link click Event","Link'"+xpath+"' is not clicked","Fail");
		}
	}
	
	/**
	* clicks the link based on the partial label
	* @param label

	*/
	
	public void clickPartialText (String label){
		try{
			
			uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(label)));
			uniqId.click();
			//reportEvent.Status("Link click Event","Link'"+label+"' is clicked","PASS");
		}catch(Exception e){
		//	reportEvent.Status("Link click Event","Link'"+label+"' is not clicked","Fail");
		}
	}
	
	/**
	* clicks if the link present based on the link text
	* return true if found,else false

	*/
	
	public boolean isLinkPresent (String label){
		boolean isLink = false;
		try{
			
			driver.findElement(By.linkText(label));
			isLink=true;
		//	reportEvent.Status("Link Validation","Link'"+label+"' is avilable","PASS");
		}catch(Exception e){
			//reportEvent.Status("Link Validation","Link'"+label+"' is not avilable","Fail");
		}
		return isLink;
	}
	/**
	* clicks if the link is missing based on the link text
	* return true if found,else false

	*/
	
	public boolean isLinkMissing (String label){
		boolean isLinkMissing = false;
		try{
			
			driver.findElement(By.linkText(label));
		//	reportEvent.Status("Link Validation","Link'"+label+"' is avilable","PASS");
		}catch(Exception e){
			//reportEvent.Status("Link Validation","Link'"+label+"' is not avilable","Fail");
			isLinkMissing=true;
		}
		return isLinkMissing;
	}
	
	/**
	* clicks if the link present based on the partial link text
	* return true if found,else false

	*/
	
	public boolean isPartialLinkPresent (String label){
		boolean isLink = false;
		try{
			
			driver.findElement(By.linkText(label));
			isLink=true;
			//reportEvent.Status("Link Validation","Link'"+label+"' is avilable","PASS");
		}catch(Exception e){
			//reportEvent.Status("Link Validation","Link'"+label+"' is not avilable","Fail");
		}
		return isLink;
	}
	
	/**
	*Get link Href 
	**/
	
	public String getHref (String label){
		String href="";
		try{
			
			driver.findElement(By.linkText(label)).getAttribute("href");
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","link source"+label,"PASS");
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","link source"+label,"FAIL");
		}
		return href;
	}

}
