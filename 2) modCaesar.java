import java.util.Scanner;

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
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter plaintext: ");
		String input = scan.nextLine();

		System.out.print("Enter key: ");
		int key = Integer.parseInt(scan.nextLine());

		System.out.println("Plaintext: " + input);
		System.out.println("Ciphertext: " + encryptData(input, key));
	}
}