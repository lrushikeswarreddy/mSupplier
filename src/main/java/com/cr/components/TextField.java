package com.cr.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextField extends Component{
	
	WebElement uniqId=null;
	String parentId=null;
	String label="";
	String textelement="";
	
	/**
	 * Find the text button based on the label/name
	 * @param lable
	 */
	public Boolean findByLable(String label){
		this.label=label;
		try{
					parentId="//label[text()='"+label+":']/../../td/input";
							uniqId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentId)));
							return true;
				}catch(Exception e){
					e.printStackTrace();
				//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"page","Text field with label"+label+" NOT found","FAIL");
					return false;
				}
	}
	/**
	 * Find the text button based on xpath
	 * @param txtxpath
	 */
	public void findByXpath(String txtXpath){
		this.label=txtXpath;
		try{
			uniqId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtXpath)));
		}catch(Exception e){
	e.printStackTrace();
	//reportEvent.Status(el.getClassName ().toString().replace("com.uhg.vbr.panels.", "")+"page","Text field with xpath"+txtXpath+" NOT found","FAIL");
	 
		}
	}
	public boolean ValidateTextField(String txtXpath){
		this.textelement=txtXpath;
		try{
			uniqId = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtXpath)));
		//	reportEvent.Status("Cases page","Text field with xpath" +txtXpath+ "FOUND","PASS");
			return true;
		}catch (Exception e){
			e.printStackTrace();
		//	reportEvent.Status("Cases page","Text field with xpath" +txtXpath+ "Not FOUND","FAIL");
			return false;
		}
	}
	
	/**
	 * Type the values in the identified text box based on label
	 * @param value
	 */
	public void setValue(String value){
		try{
			uniqId.clear();
			uniqId.sendKeys(value);
			if(uniqId.getAttribute("name").equalsIgnoreCase("PASSWORD")){
				value="*********";
			}
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page",label +"is set with value" +value,"PASS");
		}catch(Exception e){
			e.printStackTrace();
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page",label +"is NOT set with value" +value,"FAIL ");
		}
	}
	
	/**
	 * Get the value uin the text box
	 * return String
	 */
	public String getValue(){
		return uniqId.getAttribute("value");
	}

}
