class modCaesar {
	public static String encryptData(String input, int key) {
		String output = "";

		for(int i = 0; i < input.length(); i++) {
			int c = (int)(input.charAt(i));
			c += key;
			if(c > 122) {
				c = 96 + c % 122;
			}
			output += (char)c;			
		}
		return output;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Invalid input");
			return;
		}
		String input = args[0];
		int key = Integer.parseInt(args[1]);

		input = input.replaceAll(" ","");

		System.out.println(encryptData(input,key));
	}
}