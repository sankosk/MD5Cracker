package logic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MD5WebService1 extends Cracker{
	// md5encryption.com
	
	public static void main(String args[]){
		Cracker c = new MD5WebService1("http://md5decryption.com/index.php", "21232f297a57a5a743894a0e4a801fc3", false);
		System.err.println(c.getCrackedHash());
	}
	
	public MD5WebService1(String url, String md5Hash, boolean isGET) {
		super(url, md5Hash, isGET);
	}

	@Override
	public String getParameters() {
		return "hash=" + getMd5Hash() + "&submit=Decrypt It!";
	}

	@Override
	public String getCrackedHash() {
		try {
			String content = sendHash(getParameters());
			System.out.println(content);
            Pattern search = Pattern.compile("Decrypted Text: <\\/b>(.*?)<\\/font>");
            Matcher regex = search.matcher(content);
            if(regex.find()){
            	return regex.group(1);
            }            
            
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "Not found";
		
	}

}
