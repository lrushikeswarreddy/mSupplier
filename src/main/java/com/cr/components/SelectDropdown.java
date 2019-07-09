package com.cr.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown extends Component{

	WebElement uniqId=null;
	String parentId=null;
	String parentXPath=null;
	String id=null;
	String label=null;
	Select se=null;
	
	/**
	 * Find the Select Dropdown based on the id
	 * @param id
	 * @return true if found,else false
	 */
	public boolean findById(String id){
		this.id=id;
		try{
			parentId="//select[@id='"+id+"']";
			uniqId  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentId)));
			se=new Select(uniqId);
					return true;
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+id+"is NOT Found","FAIL");
			return false;
		}
	}
	
	/**
	 * Find the Select Dropdown based on the xpath
	 * @param xpath
	 * @return true if found,else false
	 */
	public boolean findByXpath(String txtXpath){
		this.label=txtXpath;
		try{
			parentXPath=txtXpath;
			uniqId  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtXpath)));
			se=new Select(uniqId);
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+label+"is Found","PASS");
					return true;
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+id+"is NOT Found","FAIL");
			return false;
		}
	}
	
	/**
	 * To validate the drop down based on the xpath is missing
	 * @param xpath
	 * @return true if found,else false
	 */
	public boolean findByXpathMissingDropdow(String txtXpath){
		this.label=txtXpath;
		try{
			parentXPath=txtXpath;
			uniqId  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtXpath)));
			se=new Select(uniqId);
					return false;
		}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+id+"is NOT Found","PASS");
			return false;
		}
	}
	/**
	 *clicks the selected dropdown identified by id
	 **/
	public void click()
	{
		try{
			
			uniqId.click();
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+id+"is clicked","PASS");
			
		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+id+"is NOT clicked","FAIL");
			
		}
	}
	
	/**
	 *clicks the select dropdown value identified by ValueToSelect
	 **/
	public void selectDropdownValue(String ValueToSelect)
	{
		try{
			
			List<WebElement> option=se.getOptions();
			boolean elementfound=false;
			/*
			 for(int j=0;j<option.size();j++){
			 WebElement d = option.get(j);
			 System.out.println(d.getText());
			 */
			for(int i=0;i<option.size();i++){
				 WebElement d = option.get(i);
				 //System.out.println("CurrentElement:"+d.getText());
		if(d.getText().equalsIgnoreCase(ValueToSelect)){
			d.click();
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToSelect+"is Selected","PASS");
			elementfound=true;
			break;
		}
	}
	if(!elementfound){
				//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToSelect+"is Not Selected","FAIL");			
			}
		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToSelect+"is NOT Selected","FAIL");			
			
		}
	}
	
	/**
	 *validate  simple dropdown value identified by ValueToValidate
	 **/
	public void validateDropdownValue(String ValueToValidate)
	{
		try{
			
			List<WebElement> option=se.getOptions();
			for(int i=0;i<option.size();i++){
				 WebElement d = option.get(i);
				 //System.out.println("CurrentElement:"+d.getText());
		if(d.getText().equalsIgnoreCase(ValueToValidate)){
			d.click();
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToValidate+"is Listed","PASS");
			break;
}
}
		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToValidate+"is NOT Listed","FAIL");			
			
		}
	}
	

	/**
	 *validate  simple dropdown all value identified
	 **/
	public void validateDropdownAllValue(String... ValueToValidate)
	{
		try{
			
			List<WebElement> option=se.getOptions();
			boolean valueexists=false;
			for(String value:ValueToValidate){
			for(int i=0;i<option.size();i++){
				 WebElement d = option.get(i);
				 //System.out.println("CurrentElement:"+d.getText());
		if(d.getText().equalsIgnoreCase(value)){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+value+"is Listed","PASS");
			valueexists=true;
			break;
}
}
			
		if(!valueexists){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToValidate+"is NOT Listed","FAIL");			
					}
			}
		
			}catch(Exception e){
		//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ ValueToValidate +"is NOT Listed","FAIL");			
			}
	
	
}


	/**
	 *validate  simple dropdown current value identified by CurrentValueToValidate
	 **/
	public void validateDropdownCurrentValue(String CurrentValueToValidate)
	{
		WebElement d = se.getFirstSelectedOption();
		 //System.out.println("CurrentElement:"+d.getText());
		try{
			
			 
		if(d.getText().equalsIgnoreCase(CurrentValueToValidate)){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is having current value '"+CurrentValueToValidate+"as Selected","PASS");
			
			}
			}catch(Exception e){
		//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is having current value"+CurrentValueToValidate+"as Selected","FAIL");			
		
	}
	
}
	
	/**
	 *validate  dropdown label and items
	 **/
	public void validateDropdownOptionGroupAndOptions(String strOptionGroup,String...strOptions){
	String OptionID;
	boolean optiongroup=false;
	boolean option= false;
	List<WebElement> optionGroups=uniqId.findElements(By.tagName("optgroup"));
		try{
			
			
			for(int i=1;i<optionGroups.size();i++){
				 WebElement d = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath+"/optgroup["+i+"]")));
			
		if(d.getAttribute("label").equalsIgnoreCase(strOptionGroup)){
			optiongroup=true;
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is having valid 'Activity':"+strOptionGroup,"PASS");
			OptionID = parentXPath +"/optgroup["+i+"]/option";
			List<WebElement> Options=uniqId.findElements(By.xpath(OptionID));
			for(String strOption : strOptions){
				try{
					for(int j=1;j<=Options.size();j++){
						 WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath+"/optgroup["+i+"]/option["+j+"]")));
							if(e.getText().equalsIgnoreCase(strOption)){
							option=true;
				//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is having a valid 'task name':"+strOption,"PASS");
					break;
				}
			}


		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is not having a valid 'task name':"+strOption,"FAIL");			
			
		}
		if(!option){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is not having a valid 'task name':"+strOption,"FAIL");			
			
		}
	}
	break;
		}
		
			}
		}
catch(Exception e){
	//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is not having a valid 'Activity':"+strOptionGroup,"FAIL");			
	
}
if(!optiongroup){
//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown is not having a valid 'Activity':"+strOptionGroup,"FAIL");			
	
}
	
}

/**
 * Clicks the Selected Dropdown Value identified by ValueToSelect and visibleText
 */
public void selectDropdownValueVisibileText(String ValueToSelect)
{
	se.selectByVisibleText(ValueToSelect);
}

/**
 * Clicks the Select Dropdown Value identified by ValueToSelect and visibleText
 */
public void selectDropdownValueBasedOnValue(String ValueToSelect)
{
	se.selectByValue(ValueToSelect); 
}

public void selectDropdownValueBasedOnIndex(int ValueToSelect)
{
	se.selectByIndex(ValueToSelect);
}
}