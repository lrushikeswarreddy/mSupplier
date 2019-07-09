package com.cr.components;

public class Component extends com.cr.automationcore.Driver {
	
	/**
	 * Load the class and creat instance at runtime
	 * @param componentname
	 * @return Object
	 */
	protected Object getComponents(String componentName){
		Object object = null;
		try{
			Class<?> c = null;
			if(componentName.contains(".")){
				c=Class.forName(componentName);
			}else{
				c=Class.forName("com.cr.components." +componentName);
			}
			object =c.newInstance();
		}catch(Exception e){
			System.out.println("Class not found");
			e.printStackTrace();
		}
		return object;
	}
	
	

}