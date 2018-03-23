import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

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

public class DES {
	public static void main(String[] args) throws Exception {
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		DESEncrypt encrypter = new DESEncrypt(key);
		String encrypted = encrypter.encrypt("Hello there");

		System.out.println(encrypted);
	}
}