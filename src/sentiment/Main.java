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

//		System.out.println(Token.tokenizer("Merhaba, benim adim   Cem, seninkisi ne peki? Memnum oldum."));
//		System.out.println(Token.eliminatePunc("Hi there. What I would like to ask is "
//				+ "that whether you'd like to come with us or not?"));
//		ArrayList<ArrayList<String>> al = Gram_extr.fourgram(Token.eliminatePunc("Hi there. What I would like to ask is "
//				+ "that whether you'd like to come with us or not?"));
//		System.out.println(al.toString());
		StanfordLemmatizer sl = new StanfordLemmatizer();
//    	List<String> l_ = sl.lemmatize("Hello, my name is Cem, and what's yours? I come from "
//    			+ "Mexico, and developed a novel algorithm.");
//    	for (int i = 0; i < l_.size(); i++) {
//    		if (i == l_.size() - 1)
//    			System.out.print(l_.get(i));
//    		else
//    			System.out.print(l_.get(i) + " ");
//    	}
//    	
    	List<List<String>> l_ = new ArrayList<List<String>>();
    	List<String> stopwords = new Stopwords().stopwords();
    	try {
			
			BufferedReader br = new BufferedReader(new FileReader("training.txt"));
			String s;
			while ((s = br.readLine() ) != null) {
				s = s.toLowerCase(Locale.ENGLISH);
				l_.add((List<String>)sl.lemmatize(s));
			}
			br.close();
			
			new Output().output(l_);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
