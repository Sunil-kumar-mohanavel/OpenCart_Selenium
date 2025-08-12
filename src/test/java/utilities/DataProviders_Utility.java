package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviders_Utility {


	


	    // DataProvider 1
	    @DataProvider(name = "LogData")
	    public String[][] getData() throws IOException {
	        
	        String path = ".\\"; // test data file path
	        
	        ExcelUtility xlutil = new ExcelUtility(path); // creating object for ExcelUtility
	        
	        int totalrows = xlutil.getRowCount("Sheet1");
	        int totalcols = xlutil.getCellCount("Sheet1", 1);
	        
	        String logindata[][] = new String[totalrows][totalcols]; // 2D array to store data
	        
	        for (int i = 1; i <= totalrows; i++) { // read data starting from row 1
	            for (int j = 0; j < totalcols; j++) { // column index from 0
	                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	            }
	        }
	        
	        return logindata; // returning two-dimensional array
	    }
	}


