package Utilities;

import java.io.IOException;

public class BatchUtils {
	
	public static void runBatch(String batch){
        try {
            String[] command = { "cmd.exe", "/C", "Start", batch };
            @SuppressWarnings("unused")
			Process p = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
        	System.out.println("Error occurred during running batch file "+batch);
      }
    }

}
