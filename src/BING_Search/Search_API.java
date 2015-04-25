package BING_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.sun.jersey.core.util.Base64;

public class Search_API {

	public Search_API() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String searchText = "iyi";
		searchText = searchText.replaceAll(" ", "%20");
		String accountKey="D5EDGtXiosVlNQRJv/88ghdSmWNo/xzekESYStjUkGA";



		byte[] accountKeyBytes = Base64.encode((accountKey + ":" + accountKey).getBytes());
		String accountKeyEnc = new String(accountKeyBytes);
		URL url;
		try {
			url = new URL(
					"https://api.datamarket.azure.com/Bing/Search/v1/Composite?Sources=%27Web%27&Query=%27" + searchText + "%27&$format=JSON");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String output;
			System.out.println("Output from Server .... \n");
			//write json to string sb
			while ((output = br.readLine()) != null) {

				sb.append(output);

			}

			conn.disconnect();
			//find webtotal among output      
			int find= sb.indexOf("\"WebTotal\":\"");
			int startindex = find + 12;


			int lastindex = sb.indexOf("\",\"WebOffset\"");

			System.out.println("Number of results: " + sb.substring(startindex,lastindex));

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
