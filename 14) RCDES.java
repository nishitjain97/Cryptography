class RCDES {
	public static char[] col = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'};
	public static char[] row = {'0', '1', '2', '3'};

	public static int getInt(String binary) {
		int i = 1;

		int output = 0;

		for(int j = binary.length()-1; j >= 0; j--) {
			if(binary.charAt(j) == '1') {
				output += i;
			}
			i = i * 2;
		}

		return output;
	}

	public static void main(String[] args) {
		String S1 = "011011";

		System.out.println("Input string = " + S1);

		String inRow = "" + S1.charAt(0) + S1.charAt(5);

		String inCol = "";

		for(int i = 1; i <= 4; i++) {
			inCol += S1.charAt(i);
		}

		System.out.println("Row is: " + row[getInt(inRow)]);
		System.out.println("Column is: " + col[getInt(inCol)]);
	}
}