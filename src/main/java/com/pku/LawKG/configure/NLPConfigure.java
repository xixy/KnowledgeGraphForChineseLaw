/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年7月18日 上午10:19:35
 */
package com.pku.LawKG.configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NLPConfigure {
	private static Properties pro = new Properties();
	private static String coreNLPChinesePropertyPath;
	static{
		try {
			InputStream inStream = new FileInputStream(new File("src/main/resources/system.properties"));
			pro.load(inStream);
			coreNLPChinesePropertyPath=pro.getProperty("coreNLPChinesePropertyPath");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static String getCoreNLPChinesePropertyPath() {
		return coreNLPChinesePropertyPath;
	}

}
