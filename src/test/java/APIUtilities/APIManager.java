package APIUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class APIManager {
	

	private CloseableHttpClient client;
	private CloseableHttpResponse response;
	private HttpPost httpPost;
	private List<NameValuePair> params = new ArrayList<NameValuePair>();
	private int statusCode;
	private String statusText;
	private String responsejson;
	
	public APIManager()
	{
		this.client = HttpClients.createDefault();  
	}

	public void httpGET(String SAMPLE_URL)
	{
		try {
			this.response = client.execute(new HttpGet(SAMPLE_URL));
			this.statusCode = response.getStatusLine().getStatusCode();
			this.statusText = response.getStatusLine().getReasonPhrase();
			this.responsejson = EntityUtils.toString(this.response.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void httpPOST(String SAMPLE_URL)
	{
		try {
			this.httpPost = new HttpPost(SAMPLE_URL);
		    this.params.add(new BasicNameValuePair("username", "John"));
		    this.params.add(new BasicNameValuePair("password", "pass"));
		    httpPost.setEntity(new UrlEncodedFormEntity(this.params));

		    CloseableHttpResponse response = client.execute(httpPost);
			
			
			response = client.execute(new HttpPost(SAMPLE_URL));
			statusCode = response.getStatusLine().getStatusCode();
			statusText = response.getStatusLine().getReasonPhrase();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStatusCode()
	{
		return String.valueOf(this.statusCode);
	}
	
	public String getStatusText()
	{
		return this.statusText;
	}
	
	public String getResponseJSON()
	{
		return this.responsejson;
	}

}
