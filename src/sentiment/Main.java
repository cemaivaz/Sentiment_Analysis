package sentiment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StanfordLemmatizer sl = new StanfordLemmatizer();
    	List<List<String>> l_ = new ArrayList<List<String>>();
    	List<String> stopwords = new Stopwords().stopwords();
    	try {
			
    		System.out.println(sl.lemmatize("0 Hello, how are you?"));
			BufferedReader br = new BufferedReader(new FileReader("training.txt"));
			String s;
			while ((s = br.readLine() ) != null) {
				s = s.toLowerCase(Locale.ENGLISH);
				l_.add((List<String>)sl.lemmatize(s));
			}
			br.close();
			
//			new Output().output(l_);
//			new OutputMultigrams().output(l_);
//			new OutputStopword().output(l_);
//			new OutputMultigramsStopwordEl().output(l_);;
//			new OutputFreq().output(l_);
			new OutputMultigramsStopwordElUniBi().output(l_);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
