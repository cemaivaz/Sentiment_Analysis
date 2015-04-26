package BING_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.core.util.Base64;

public class Search_Main {

	public Search_Main(String[] searchTextArr) {
		// TODO Auto-generated constructor stub

		String accountKey="D5EDGtXiosVlNQRJv/88ghdSmWNo/xzekESYStjUkGA";


		String[] sents = new String[]{"mükemmel", "kötü"};
		double[] scores = new double[2];
		for (int i = 0; i < sents.length; i++) {
			String searchText = sents[i];
			searchText = searchText.replaceAll(" ", "%20");
			

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

				scores[i] = Double.parseDouble(sb.substring(startindex,lastindex));
//				System.out.println("Number of results: " + sb.substring(startindex,lastindex));

			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
	
		}
		for (int i = 0; i < searchTextArr.length; i++) {
			

			double[] comp = new double[2];
			for (int j = 0; j < sents.length; j++) {
				String searchText = searchTextArr[i];
				
				searchText += " near:3 " + sents[j];
				searchText = searchText.replaceAll(" ", "%20");
				
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

					//scores[i] = Double.parseDouble(sb.substring(startindex,lastindex));
					comp[j] = Math.log(Double.parseDouble(sb.substring(startindex,lastindex)) / scores[j]);
//					System.out.println("Number of results: " + sb.substring(startindex,lastindex));

				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
				
				
			}
			double res = comp[0] - comp[1];
			
			System.out.println("The word: " + searchTextArr[i] + ", sentiment: " + ((res >= 0) ? "positive" : "negative"));
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Search_Main sm = new Search_Main(new String[]{"berbat", "muhteşem", "anlamsız", "rahatsız", "çekici",
				"itici", "pahalı", "çalışkan", "tembel", "çirkin", "hoş", "akıllı", "iyi"});
		
	}

}
