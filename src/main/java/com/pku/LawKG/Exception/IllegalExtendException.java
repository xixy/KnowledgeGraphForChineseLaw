package com.pku.LawKG.Exception;

public class IllegalExtendException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalExtendException(String msg,Class<?> T){
		super(msg);
		System.out.println(T);
		
	}

}
