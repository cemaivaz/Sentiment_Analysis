package sentiment;

import java.util.ArrayList;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Token.tokenizer("Merhaba, benim adim   Cem, seninkisi ne peki? Memnum oldum."));
		System.out.println(Token.eliminatePunc("Hi there. What I would like to ask is "
				+ "that whether you'd like to come with us or not?"));
		ArrayList<ArrayList<String>> al = Gram_extr.fourgram(Token.eliminatePunc("Hi there. What I would like to ask is "
				+ "that whether you'd like to come with us or not?"));
		System.out.println(al.toString());
	}

}
