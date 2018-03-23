class XOR {
	public static String XORString(String S1, String S2) {
		if(S1.length() < S2.length()) {
			int diff = S2.length() - S1.length();
			for(int i = 0; i < diff; i++) {
				S1 = "0" + S1;
			}
		}
		else if(S1.length() > S2.length()) {
			int diff = S1.length() - S2.length();
			for(int i = 0; i < diff; i++) {
				S2 = "0" + S2;
			}
		}

		String output = "";

		for(int i = 0; i < S1.length(); i++) {
			if(S1.charAt(i) == S2.charAt(i)) {
				output += "0";
			}
			else {
				output += "1";
			}
		}

		return output;
	}

	public static void main(String[] args) {
		String S1 = "001001011";
		String S2 = "010101";

		System.out.println(S1 + " (+) " + S2 + " = " + XORString(S1, S2));
	}
}