import java.util.Random;
import java.util.Scanner;

class monoAlphabet {
	static char[] keyArray = new char[26];
	
	public static void shuffleKey() {
		Random random = new Random();
		int length = keyArray.length;

		for(int i = 0; i < length; i++) {
			int index = random.nextInt(length);

			char temp = keyArray[i];
			keyArray[i] = keyArray[index];
			keyArray[index] = temp;
		}
	}
	
	public static void generateKey() {
		for(int i = 0; i < keyArray.length; i++) {
			keyArray[i] = (char)(122 - i);
		}
		shuffleKey();
		System.out.print("Let: ");
		for(int i = 0; i < keyArray.length; i++) {
			System.out.print((char)(97+i) + " ");
		}
		System.out.println();
		System.out.print("Key: ");
		for(int i = 0; i < keyArray.length; i++) {
			System.out.print(keyArray[i] + " ");
		}
		System.out.println();
	}

	public static String encryptData(String input) {
		String output = "";

		for(int i = 0; i < input.length(); i++) {
			int c = (int)input.charAt(i);
			c -= 97;
			output += keyArray[c];
		}
		return output;
	}

	public static void main(String[] args) {
		generateKey();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter plaintext: ");
		String input = scan.nextLine();
		
		System.out.println("Plaintext: " + input);
		String output = encryptData(input);
		System.out.println("Ciphertext: " + output);
	}
}