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

class ECB {
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

		String output = "";

		for(int i = 0; i < input.length(); i += blockSize) {
			String pText = input.substring(i, i+8);
			output += encrypter.encrypt(pText);
		}

		System.out.println(output);
	}
}