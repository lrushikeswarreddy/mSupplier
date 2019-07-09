package com.cr.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownComplex extends Component {

	WebElement uniqId=null;
	String parentId=null;
	String parentXPath=null;
	String id=null;
	String label=null;
	Select se=null;
	
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
			return true;
		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select"+id+"is NOT Found","FAIL");
			return false;
		}
	}
	
	/**
	 *validate  complex dropdown value identified by ValueToValidate
	 **/
	public void validateDropdownValue(String ValueToValidate)
	{
		try{
			
			List<WebElement> option=uniqId.findElements(By.tagName("li"));
			for(int i=1;i<option.size();i++){
				 WebElement d = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath+"//li["+i+"]/input")));
				System.out.println(d.getAttribute("value")+",");
		if(d.getAttribute("value").equalsIgnoreCase(ValueToValidate)){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToValidate+"is Listed","PASS");
			break;
}
}
		}catch(Exception e){
			//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+ValueToValidate+"is NOT Listed","FAIL");			
			
		}
	}
	
	/**
	 *validate  complex dropdown all values
	 **/
	public void validateDropdownAllValue(String... strValues)
	{
		int j=1;
		List<WebElement> option=uniqId.findElements(By.tagName("li"));
		for(String strValue :strValues){
		try{
			
			for(int i=j;i<=option.size();i++){
				 WebElement d = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath+"//li["+i+"]/input")));
		if(d.getAttribute("value").equalsIgnoreCase(strValue)){
			//System.out.println("\""+strValue+"\",");
			j++;
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+strValue+"is Listed","PASS");
			break;
}
			}
		}
		catch(Exception e){
		//reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+strValue+"is NOT Listed","FAIL");			
		
	}
	
}
	
}
		
		/**
		 *Select values using check box for complex drop down 
		 **/
		public void selectDropdownComplexValue(String... strValueToSelct)
		{
			try{
				uniqId.click();
				Thread.sleep(3000);
				List<WebElement> option=uniqId.findElements(By.tagName("li"));
				for(String selectValue:strValueToSelct){
					for(int i=1;i<option.size();i++){
					 WebElement d = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath+"//li["+i+"]/input")));
						
					 //System.out.println(d,getAttribute("value")+",");
			if(d.getAttribute("value").equalsIgnoreCase(selectValue)){
				d.click();
			//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+selectValue+"is Listed","PASS");
				break;
	}
	}
			
				}
				}catch(Exception e){
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value is not selected","FAIL");			
			
		}
		
	}
		
		/**
		 *Select all or none using check box for complex drop down
		 **/
		public void selectDropdownComplexAllOrNone(String strValue)
		{
			uniqId.click();
			try{
				
				List<WebElement> option=uniqId.findElements(By.xpath("//span/a"));
				for(int i=1;i<=option.size();i++){
					 WebElement d = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentXPath+"//span/a["+i+"]")));
			if(d.getText().equalsIgnoreCase(strValue)){
				d.click();
			//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value'"+strValue+"'is Listed","PASS");
				break;
			}
		}
		
			}catch(Exception e){
			//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page","Select dropdown value"+strValue+"is NOT Listed","FAIL");			
				
			}
		}
		
	}
