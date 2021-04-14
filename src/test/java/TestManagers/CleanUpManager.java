package TestManagers;

import Utilities.BatchUtils;
import Utilities.FileUtil;

public class CleanUpManager {
	
	private ConfigManager con;
	
	public CleanUpManager(ConfigManager con)
	{
		this.con = con;
	}
	
	public void cleanupdrivers()
	{
		BatchUtils.runBatch(FileUtil.getAbsPath(con.configGet("cleanupbatchname")));
	}

}
