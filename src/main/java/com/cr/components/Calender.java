package com.cr.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Calender extends Component{
	WebElement uniqId=null;
	String ParentId=null;
	String label="";
	/**
	 * Find the calendar based on the label
	 * 
	 * @param label
	 * @return true if found,else false
	 */
	public boolean findByLabel1(String label){
		this.label=label;
		try{
			ParentId="//*[@id='extDocpopupFormId:Dateof"+label+"DateCalpopupButton']";
			uniqId=wait.until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(ParentId)));
			return true;
		}catch(Exception e){
		//	reportEvent.Status(
					//e1.getClassName().toString()
					//.replace("com.ung.vbr.panels.","")
				//	+"page","button"+label+"is NOT Found",
				//	"FAIL");
			  return false;
	       }
		}
	/*
	  *fin the Calendar based on the label
	  *
	  *@param label
	  *@return true if found,else false
	  */
	public boolean findByLabel(String label){
		this.label=label;
		try{
			ParentId = "//img[contains9@id,'"+label+"')and contains(@class,'rf-cal-btn')]";
			uniqId = wait.until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(ParentId)));
			return true;
		}catch (Exception e){
		//	reportEvent.Status(
			//		e1.getClassName().toString().replace("com.uhg.vbr.panels.","")+"page","button"+label+"is Not Found","FAIL");
			          return false;
	   }
	}

    }
