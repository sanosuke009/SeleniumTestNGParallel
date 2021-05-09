package APIUtilities;

import TestBases.BaseC;

public class APIMethods {
	public static boolean validateGet(BaseC b)
	{
		boolean res = true;
		APIManager ap = new APIManager(); String url = b.get("URL");String sc = b.get("StatusCode");
		String sct = b.get("StatusText");String sj = b.get("StatusJSON");
		if(res) ap.httpGET(url);
		if(res) res = ap.getStatusCode().equals(sc);
		if(res) b.report("The status code for GET of "+url+" is "+sc+" which is expected.");
		else b.report("The status code for GET of "+url+" is "+ap.getStatusCode()+" which is NOT expected."
				+" The expected status code is "+sc);
		if(res) res = ap.getStatusText().equals(sct);
		if(res) b.report("The status Text for GET of "+url+" is "+sct+" which is expected.");
		else b.report("The status Text for GET of "+url+" is "+ap.getStatusText()+" which is NOT expected."
				+" The expected status Text is "+sct);
		if(res) res = ap.getResponseJSON().equals(sj);
		if(res) b.report("The JSON response for GET of "+url+" is "+sj+" which is expected.");
		else b.report("The JSON response for GET of "+url+" is "+ap.getResponseJSON()+" which is NOT expected."
				+" The expected status Text is "+sj);
		return res;
	}
}
