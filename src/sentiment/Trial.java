package sentiment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Trial {

	public Trial() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new FileReader("outputBigram.txt"));
			String line;
			List<String> lines = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			
			br.close();
			for (int i = (int) lines.size() / 2; i < lines.size(); i++) {
				String[] spl = lines.get(i).split(",");
				
				for (int j = 0; j < lines.size(); j++) {
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
