package sentiment;

public class Token {

	public Token() {
		// TODO Auto-generated constructor stub
		
	}

	public String tokenizer(String str) {
		return str.replaceAll("([^a-zA-Z0-9]+)", " $1 ").replaceAll("[ ]{2,}", " ");
//		return str.replaceAll("([,;.?!])", " $1 ").replaceAll("[ ]{2,}", " ");
		
	}
	public String eliminatePunc(String str) {
		return tokenizer(str).replaceAll("([^a-zA-Z0-9]+)", "").replaceAll("[ ]{2,}", " ");
	}
}
