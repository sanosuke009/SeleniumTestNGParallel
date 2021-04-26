package Utilities;

import java.io.File;
import java.io.IOException;

public class VBScriptUtils {
	
	public static void runVBScript(String vbsfile){
        try {
        	System.out.println(new File("a.vbs").getAbsolutePath());
            @SuppressWarnings("unused")
			Process p = Runtime.getRuntime().exec("wscript.exe " + new File("samplevbs.vbs").getAbsolutePath());
        } catch (IOException ex) {
        	System.out.println("Error occurred during running batch file "+vbsfile);
      }
    }

}
