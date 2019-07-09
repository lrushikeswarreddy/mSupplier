package com.cr.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tab extends Component {
	WebElement uniqId=null;
	
	/**
	 * Clicks the link based on the label
	 * @param label
	 */
	public void click(String label){
		try{
			uniqId  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@id,'header:inactive')]/span[(@class='rf-tab-lbl') and (text()='"+label+"')]")));
			Actions action=new Actions(driver);
			action.click(uniqId).build().perform();
			//uniqId.click();
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Click link"+label,"FAIL");
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Click link"+label,"FAIL");
			return;
		}
	}
	
	/**
	 * Clicks if the tab is present based on the link text
	 * return true if found,else false
	 */
	public boolean isTabPresent(String label){
		boolean isLink=false;
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@id,'header:inactive')]/span[(@class='rf-tab-lbl') and (text()='"+label+"')]")));
			isLink=true;
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Tab found:"+label,"PASS");
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Tab found:"+label,"FAIL");
			
		}
		return isLink;
	}
	

}
