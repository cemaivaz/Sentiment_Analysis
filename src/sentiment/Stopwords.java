package sentiment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Stopwords {

	public Stopwords() {
		// TODO Auto-generated constructor stub
	}

	public List<String> stopwords() {
		List<String> stop_ = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("stopwords.txt"));
			
			
			String s;
			while ((s = br.readLine()) != null)
				stop_.add(s.toLowerCase(Locale.ENGLISH).trim());
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return stop_;
		}
	}
}
