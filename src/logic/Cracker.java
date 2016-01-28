package logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public abstract class Cracker {
	private final static String USER_AGENT = "Mozilla/5.0";
	private String url;
	private String md5Hash;
	private boolean isGET; //True=GET, False=POST
	
	public Cracker(String url, String md5Hash, boolean isGET){
		setUrl(url);
		setMd5Hash(md5Hash);
		setGET(isGET);
	}
	
	public String getMd5Hash() {
		return md5Hash;
	}

	private void setMd5Hash(String md5Hash) {
		this.md5Hash = md5Hash;
	}
	
	public String getUrl() {
		return url;
	}
	
	private void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isGET() {
		return isGET;
	}
	
	private void setGET(boolean isGET) {
		this.isGET = isGET;
	}
	
	public String sendHash(String params) throws MalformedURLException, ProtocolException, IOException{
		if(isGET)
			return sendHashByGet(params);
		else
			return sendHashByPost(params);
	}
	
	private String sendHashByGet(String params){
		return "";
	}
	
	private String sendHashByPost(String params) throws MalformedURLException, IOException, ProtocolException{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		//headers
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		//sending post req
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(params);
		wr.flush();
		wr.close();
		//int responseCode = con.getResponseCode();
		
		//saving content data
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}
	
	public abstract String getParameters();
	public abstract String getCrackedHash();
	
	
}
