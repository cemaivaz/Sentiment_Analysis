package sentiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gram_extr {

	public Gram_extr() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<String>> bigram(String str) {
		
		String[] strArr = str.split(" ");
		List<List<String>> arr = new ArrayList<List<String>>();
		
		int cnt = 2;
		
		if (strArr.length <= cnt) {
			arr.add((ArrayList<String>)Arrays.asList(strArr));
			return arr;
			
		}
		
//		String[] bigr = new String[3];
		for (int i = 0; i <= strArr.length - cnt; i++) {

			List<String> subArr = new ArrayList<String>();
			for (int j = i; j < i + 2; j++) {
				subArr.add(strArr[j]);
			}
			arr.add(subArr);
		}
		return arr;
	}

	public static ArrayList<ArrayList<String>> trigram(String str) {
		
		String[] strArr = str.split(" ");
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		
		int cnt = 3;
		
		if (strArr.length <= cnt) {
			arr.add((ArrayList<String>)Arrays.asList(strArr));
			return arr;
			
		}
		
//		String[] bigr = new String[3];
		for (int i = 0; i <= strArr.length - cnt; i++) {

			ArrayList<String> subArr = new ArrayList<String>();
			for (int j = i; j < i + cnt; j++) {
				subArr.add(strArr[j]);
			}
			arr.add(subArr);
		}
		return arr;
	}
	
	public static ArrayList<ArrayList<String>> fourgram(String str) {
		
		String[] strArr = str.split(" ");
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		
		int cnt = 4;
		
		if (strArr.length <= cnt) {
			arr.add((ArrayList<String>)Arrays.asList(strArr));
			return arr;
			
		}
		
//		String[] bigr = new String[3];
		for (int i = 0; i <= strArr.length - cnt; i++) {

			ArrayList<String> subArr = new ArrayList<String>();
			for (int j = i; j < i + cnt; j++) {
				subArr.add(strArr[j]);
			}
			arr.add(subArr);
		}
		return arr;
	}
}
