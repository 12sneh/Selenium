package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel(){

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("C:\\Users\\Monika appricott\\Documents\\Selenium Workspace\\Data_Driven_Test\\src\\main\\java\\com\\testdata\\Twelve_DataProvider.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		for(int rowNum =2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {

			String email = reader.getCellData("Sheet1", "Email", rowNum);
			String password = reader.getCellData("Sheet1", "Password", rowNum);

			Object ob[] = {email, password};
			myData.add(ob);
		}

		return myData;
	}
}
