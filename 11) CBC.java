import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

class DESEncrypt {
	Cipher ecipher;
	
	DESEncrypt(SecretKey key) throws Exception {
		ecipher = Cipher.getInstance("DES");
		ecipher.init(Cipher.ENCRYPT_MODE, key);
	}

	public String encrypt(String str) throws Exception {
		byte[] utf8 = str.getBytes("UTF8");

		byte[] enc = ecipher.doFinal(utf8);

		return new sun.misc.BASE64Encoder().encode(enc);
	}
}

class CBC {
	public static String XOR(String pText, String cText) {
		String output = "";

		for(int i = 0; i < pText.length(); i++) {
			output += (char)(((int)pText.charAt(i) + (int)cText.charAt(i)) % 26);
		}

		return output;
	}

	public static void main(String[] args) throws Exception {
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		DESEncrypt encrypter = new DESEncrypt(key);
		Scanner scan = new Scanner(System.in);
		int blockSize = 8;

		System.out.print("Enter plaintext: ");
		String input = scan.nextLine();
		int length = input.length();

		while(length % blockSize != 0) {
			input += "x";
			length = input.length();
		}

		String IV = "lkjhsdfl";

		String output = "";

		for(int i = 0; i < input.length(); i += blockSize) {
			String pText = XOR(input.substring(i, i+8), IV);
			IV = encrypter.encrypt(pText);
			output += IV;
		}

		System.out.println(output);
	}
}