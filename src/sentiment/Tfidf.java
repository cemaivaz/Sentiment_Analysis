package sentiment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Tfidf {

	public Tfidf() {
		// TODO Auto-generated constructor stub
	}
	
	public static HashMap<String, Double> tfidf(File f) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = br.readLine()) != null) {
				
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
