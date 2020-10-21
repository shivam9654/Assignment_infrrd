package com.infrrd.regrex;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher implements Runnable {
	
	String regex;
	String textBody;
	JsonOutput jsonOutput;
	
	PatternMatcher(String regex, String textBody, JsonOutput jsonOutput)
	{
		this.regex= regex;
		this.textBody= textBody;
		this.jsonOutput= jsonOutput;
	}
	
	@Override
	public void run()
	{
		ArrayList list = new ArrayList();
		JsonOutput jsonout;
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(textBody);
		
		while (matcher.find()) {
	         list.add(matcher.group());
	         
	     }
		
		
		if(list.isEmpty())
		{
			jsonOutput.setMatch("");
			jsonOutput.setError(false);
			
		}
		else
		{
			jsonOutput.setMatch(list.get(0).toString());
			jsonOutput.setError(false);
		}
		
				
	}

}
