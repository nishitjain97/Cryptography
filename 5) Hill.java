import java.util.Scanner;

class Hill {
	static String key = "SECRETKEY";
	static int[][] keyMatrix = new int[3][3];
	static int[][] inputMatrix = new int[3][3];

	public static int[][] createMatrix(String input) {
		int k = 0;
		int[][] outputMatrix = new int[3][3];

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				outputMatrix[i][j] = ((int)input.charAt(k) - 65);
				k++;
			}
		}

		return outputMatrix;
	}

	public static int[][] multiplyMatrix() {
		int[][] outputMatrix = new int[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				outputMatrix[i][j] = 0;
			}
		}

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					outputMatrix[i][j] += keyMatrix[i][k] * inputMatrix[k][j];
				}
			}
		}
		
		return outputMatrix;					
	}

	public static String encrypt(String input) {
		keyMatrix = createMatrix(key);
		inputMatrix = createMatrix(input);

		int[][] outputMatrix = multiplyMatrix();

		String output = "";

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				output += (char)(outputMatrix[i][j] % 26 + 65);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;

		System.out.print("Enter plaintext: ");
		input = scan.nextLine();

		while(input.length() < 9) {
			input += "x";
		}

		input = input.toUpperCase();

		String output = encrypt(input);

		System.out.println("Ciphertext: " + output);
	}
}