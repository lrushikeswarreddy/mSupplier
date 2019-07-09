package com.cr.automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static String browser,environment,platform,mailFeature,sendMail,mailsmokesubject,mailregrsubject,mailinglist,fromemail,smtpserver,mailattachmentdata,executionstatistics,updateQC,parallelrun;
	public static String DevUrl,TestUrl,StageUrl;
	
	
	
	private static Configuration conf = null;
	
	public Configuration(){}
	
	public static Configuration getConfiguration(){
		if (conf ==null) {
			Configuration configuration = new Configuration();
			return configuration;
		} else{
			return conf;
		}
	}
	
	
	public void getpropValues() throws IOException {
		Properties prop = new Properties();
		FileInputStream inputstream = new FileInputStream("./src/main/resources/Configuration/config.properties");
		
		if(inputstream != null) {
			try {
				prop.load(inputstream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//get the properties value from the properties file
		browser =prop.getProperty("Browser");
		environment =prop.getProperty("environment");
		platform =prop.getProperty("platform");
		
		DevUrl =prop.getProperty("Browser");
		TestUrl =prop.getProperty("TestUrl");
		StageUrl =prop.getProperty("StageUrl");
		
		mailFeature =prop.getProperty("mailFeature");
		sendMail =prop.getProperty("sendMail");
		mailsmokesubject =prop.getProperty("mailsmokesubject");
		mailregrsubject =prop.getProperty("mailregrsubject");
		mailinglist =prop.getProperty("mailinglist");
		fromemail =prop.getProperty("fromemail");
		smtpserver =prop.getProperty("smtpserver");
		mailattachmentdata =prop.getProperty("mailattachmentdata");
		executionstatistics =prop.getProperty("executionstatistics");
					
	}	

}
