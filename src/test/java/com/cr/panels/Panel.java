package com.cr.panels;
import com.cr.components.Button;
import com.cr.components.CheckBox;
import com.cr.components.Component;
import com.cr.components.Link;
import com.cr.components.RadioButton;
import com.cr.components.SelectDropdown;
import com.cr.components.Tab;
import com.cr.components.TextField;
public class Panel  extends Component{
	
	protected Link link=(Link)getComponents("Link");
	protected TextField textfield=(TextField)getComponents("TextField");
	protected Button button=(Button)getComponents("Button");
	protected Tab tab=(Tab)getComponents("Tab");
	//protected Calendar calendar=(Calendar)getComponents("Calendar");
	protected SelectDropdown select=(SelectDropdown)getComponents("SelectDropdown");
	protected RadioButton radioButton=(RadioButton)getComponents("RadioButton");
	protected CheckBox checkbox=(CheckBox)getComponents("CheckBox");
	
	protected Object getPanel(String panelName){
		Object object=null;
		try{
			Class<?> c=null;
			if(panelName.contains(".")){
				c=Class.forName(panelName);
			}else{
				c=Class.forName("com.cr.panels."+panelName);
			}
			object=c.newInstance();
		}catch(Exception e){
			System.out.println("Class not found");
			e.printStackTrace();
		}
		return panelName;
		
	}
}