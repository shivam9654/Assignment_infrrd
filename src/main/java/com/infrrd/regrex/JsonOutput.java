package com.infrrd.regrex;

public class JsonOutput {
	
	String match;
	boolean error;
	
	JsonOutput(String match,boolean error)
	{
		this.match= match;
		this.error= error;
	}
	
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public boolean getError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}

}
