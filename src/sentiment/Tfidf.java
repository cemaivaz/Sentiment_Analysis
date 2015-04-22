package sentiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tfidf {

	public Tfidf() {
		// TODO Auto-generated constructor stub
	}
	
	public static HashMap<String, Double> idf(List<List<String>> al) {
		
		HashMap<String, Double> hm = new HashMap<String, Double>();
		
		HashMap<String, Double> freq = new HashMap<String, Double>();
		HashMap<String, Double> docNo = new HashMap<String, Double>();
		
		int i;
		for (i = 0; i < al.size(); i++) {
			List<String> alSub = al.get(i);
			Set<String> docNoSub = new HashSet<String>();
			
			int j;
			for (j = 0; j < alSub.size(); j++) {
				double frek = freq.containsKey(alSub.get(j)) ? freq.get(alSub.get(j)): 0;
				frek += 1;
				freq.put(alSub.get(j), frek);
				
				docNoSub.add(alSub.get(j));
			}
			List<String> l = new ArrayList<String>(docNoSub);
			for (j = 0; j < l.size(); j++) {
				double frekDoc = docNo.containsKey(l.get(j)) ? docNo.get(l.get(j)): 0;
				frekDoc += 1;
				docNo.put(l.get(j), frekDoc);
			}
		}
		List<String> l = new ArrayList<String>(freq.keySet());
		for (i = 0; i < freq.size(); i++) {
			double d_ = docNo.get(l.get(i));
			System.out.println(d_);
			hm.put(l.get(i), Math.log(al.size() / docNo.get(l.get(i))));
		}
		return hm;
		
	}

}
