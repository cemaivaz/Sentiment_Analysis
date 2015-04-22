package sentiment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class StanfordLemmatizer {

    protected StanfordCoreNLP pipeline;

    public StanfordLemmatizer() {
        // Create StanfordCoreNLP object properties, with POS tagging
        // (required for lemmatization), and lemmatization
        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");

        // StanfordCoreNLP loads a lot of models, so you probably
        // only want to do this once per execution
        this.pipeline = new StanfordCoreNLP(props);
    }

    public List<String> lemmatize(String documentText)
    {
        List<String> lemmas = new LinkedList<String>();

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(documentText);

        // run all Annotators on this text
        this.pipeline.annotate(document);

        // Iterate over all of the sentences found
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        for(CoreMap sentence: sentences) {
            // Iterate over all tokens in a sentence
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
                // Retrieve and add the lemma for each word into the list of lemmas
                lemmas.add(token.get(LemmaAnnotation.class));
            }
        }

        return lemmas;
    }
    
    public static void main(String[] args) {
    	
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
    	ArrayList<ArrayList<String>> l_ = new ArrayList<ArrayList<String>>();
    	List<String> stopwords = new ArrayList<String>();
    	try {
			
			BufferedReader br = new BufferedReader(new FileReader("training.txt"));
			String s;
			while ((s = br.readLine() ) != null) {
				s = s.toLowerCase(Locale.ENGLISH);
				l_.add((ArrayList<String>)sl.lemmatize(s));
			}
			br.close();
			
			br = new BufferedReader(new FileReader("stopwords.txt"));
			
			while ((s = br.readLine()) != null)
				stopwords.add(s.toLowerCase(Locale.ENGLISH).trim());
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	HashMap<String, Double> hm = Tfidf.tfidf(l_);
    	
    	List<List<String>> out = new ArrayList<List<String>>();
    	for (int i = 0; i < l_.size(); i++) {
    		List<String> subL = l_.get(i);

    		List<String> subOut = new ArrayList<>();
    		for (int j = 0; j < subL.size(); j++) {
    			if (j == subL.size() - 1)
    				System.out.println(subL.get(j));
    			else
    				System.out.print(subL.get(j) + " ");

    			
    			if (subL.get(j).matches("[a-zA-Z]+")) {
    				if j == 0
    					subOut.add(subL.get(j));
    			}
    				
    		}

    		
    	}
    	
    	
    }
    
}