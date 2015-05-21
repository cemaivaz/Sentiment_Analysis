package sentiment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputMultigrams {

	public OutputMultigrams() {

	}
	public void output(List<List<String>> l_) {
		// TODO Auto-generated constructor stub
		HashMap<String, Double> hm = Tfidf.idf(l_);

		List<List<String>> out = new ArrayList<List<String>>();
		List<String> stopwords = new Stopwords().stopwords();
		Set<String> words = new HashSet<String>();

		for (int i = 0; i < l_.size(); i++) {
			List<String> subL = l_.get(i);

			List<String> subOut = new ArrayList<>();
			for (int j = 0; j < subL.size(); j++) {
				String word = subL.get(j);
				

				if (j == 0) {
					subOut.add(word);

				} 
//				else if (stopwords.contains(word)) {
//					subOut.add(word);
//				} 
				else if (word.matches("[a-zA-Z]{2,}")) {
					subOut.add(word);// + ":" + hm.get(word));
					words.add(word);
				}

			}
			out.add(subOut);


		}
		words = new HashSet<String>();
		for (int i = 0; i < out.size(); i++) {
			List<String> subList = new ArrayList<String>(out.get(i));
			StringBuilder sb = new StringBuilder("");
			for (int j = 1; j < subList.size(); j++) {
				sb.append(subList.get(j) + " ");
			}
			sb.deleteCharAt(sb.length() - 1);
			String sent = new String(sb);
			List<List<String>> grams = Gram_extr.bigram(sent);
//			List<String> concatGram = new ArrayList<String>();
			Map<String, Double> gramFreq = new HashMap<String, Double>();
			for (int j = 0; j < grams.size(); j++) {
				StringBuilder sbGram = new StringBuilder("");
				for (int k = 0; k < grams.get(j).size(); k++) {
					sbGram.append(grams.get(j).get(k));
				}
				String strGram = new String(sbGram);
//				concatGram.add(new String(strGram));
				double freq = gramFreq.containsKey(strGram) ? 
						gramFreq.get(strGram): 0.;
				freq++;
				gramFreq.put(strGram, freq);
				words.add(new String(sbGram));
			}
//			subOut.add(word);// + ":" + hm.get(word));
			List<String> gramsPost = new ArrayList<String>(gramFreq.keySet());
			List<String> subOutUpd = new ArrayList<String>();
			subOutUpd.add(subList.get(0));
			for (int j = 0; j < gramsPost.size(); j++) {
				subOutUpd.add(gramsPost.get(j) + ":" + gramFreq.get(gramsPost.get(j)));
			}
			out.set(i, subOutUpd);
		}
		try {
			FileWriter fw = new FileWriter("outputBigram.txt");
			List<String> words_ = new ArrayList<String>(words);
			for (int i = 0; i < out.size(); i++) {
				List<String> sub = out.get(i);
				StringBuilder sb = new StringBuilder();
				sb.append(sub.get(0)).append(",");
//				outer:
				for (int k = 0; k < words_.size(); k++) {
//					boolean fnd = false;
					String tf = "0";
					for (int j = 1; j < sub.size(); j++) {
						String tmpWord = sub.get(j);
						String tfidf_ = "-1.";
						String word = "";
						if (tmpWord.split(":").length == 2) {
							word = tmpWord.split(":")[0];
							tfidf_ = tmpWord.split(":")[1];
						}
						
						if (words_.get(k).equals(word)) {
//							fnd = true;
							tf = tfidf_;
						}
					}
					sb.append(tf).append(",");
				}
				sb.deleteCharAt(sb.length() - 1);
				fw.write(new String(sb) + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		


	}

}
