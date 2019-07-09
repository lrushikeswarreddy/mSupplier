package com.cr.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RadioButton extends Component {
	
	WebElement uniqId = null;
	String ParentId = null;
	String label ="";
	
	/**
	 * Find the radio button based on the label
	 * @param label
	 * @return true if found,else false
	 */
	
	public boolean findByLabel(String label){
		this.label=label;
		try{
			ParentId="//input[@Value='"+label+"']";
			uniqId  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ParentId)));
					return true;
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Radio button"+label+"is NOT Found","PASS");
			return false;
		}
	}
	
	/**
	 * Find the radio button based on the xpath,ideally used when a page has more than one element with same label
	 * @param chkxpath
	 * @return true if found,else false
	 */
	
	public boolean findByxpath(String rdbXpath){
		
		try{
			uniqId  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rdbXpath)));
		//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Radio button with xpath"+rdbXpath+"is  Found","PASS");
			return true;
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Radio button with xpath"+rdbXpath+"is NOT Found","FAIL");
			return false;
		}
	}
	
	/**
	 *select the radio button identified
	 **/
	
	public void selectRadioButton(){
		
		try{
			if(!uniqId.isSelected()){
				uniqId.click();	
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Radio button"+label+"is  selected","PASS");
		}
			else{
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Radio button"+label+"is selected","PASS");
		}
		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Radio button"+label+"is NOT selected","FAIL");
			
		}
	}
	
	/**
	 *Validates the radio button is enabled
	 *@return true if enabled,else false
	 **/
	public boolean isRadioButtonSelected(){
		return uniqId.isEnabled();
	}

}
