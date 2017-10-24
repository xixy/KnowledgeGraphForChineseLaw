/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.Exception;

public class IllegalExtendException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalExtendException(String msg, Class<?> T) {
		super(msg);
		System.out.println(T);

	}

}
