package sentiment;

import java.util.ArrayList;
import java.util.Arrays;

public class Gram_extr {

	public Gram_extr() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ArrayList<String>> bigram(String str) {
		
		String[] strArr = str.split(" ");
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		ArrayList<String> subArr = new ArrayList<String>();
		
		int cnt = 2;
		
		if (strArr.length <= 2) {
			arr.add((ArrayList<String>)Arrays.asList(strArr));
			return arr;
			
		}
		
//		String[] bigr = new String[3];
		for (int i = 0; i <= strArr.length - 1; i++) {
			if (i % cnt == 0) {
				if (i != 0)
					arr.add(subArr);
				subArr = new ArrayList<String>();
				
			}
			subArr.add(strArr[i]);
		}
		return arr;
	}

}
