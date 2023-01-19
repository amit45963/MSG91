package com.nitara.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;


public class DataProviderUtils {
	
	@DataProvider
	public static Object[] getData(Method m) throws IOException {
		List<Map<String,String>> list = new ArrayList<>();
		String testname = m.getName();
		String tname = m.getName();
		String sheet = tname.substring(0, testname.lastIndexOf("_"));
		
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(sheet);
		}
		
		return list.toArray();
		
		
	}
	

}
