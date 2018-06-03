import java.util.Scanner;

class Vernam {
	static char key[] = {'N','C','B','T','Z','Q','A','R','X'};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter plaintext: ");
		String input = scan.nextLine();

		input = input.replaceAll(" ","");
		input = input.toUpperCase();
		input = input.substring(0,9);

		String output = "";

		for(int i = 0; i < input.length(); i++) {
			int j = (int)key[i] - 65;
			int k = (int)input.charAt(i) - 65;
			int l = (j + k) % 26;
			l = l + 65;
			output += (char)l;
		}

		System.out.println("Plaintext: " + input);
		System.out.println("Encrypted: " + output);
	}
}