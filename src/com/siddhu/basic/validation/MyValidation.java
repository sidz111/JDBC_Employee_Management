package com.siddhu.basic.validation;

public class MyValidation {

	public static boolean checkId(Integer id) {
		if(id<0) {
			return false;
		}
		return true;
	}
	
	public static boolean checkName(String name) {
		for(int i=0;i<name.length();i++) 
		{
			if(name.charAt(i)>48 && name.charAt(i)<57) 
			{
				return false;
			}
		}
		return true;
	}
}
