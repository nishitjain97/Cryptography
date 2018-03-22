import java.util.Scanner;

class Hill {
	static char key[] = {'S', 'E', 'C', 'R', 'E', 'T', 'K', 'E', 'Y'};
	static int[][] keyMatrix = new int[3][3];

	static {
		int k = 0;		

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				keyMatrix[i][j] = (int)key[k] - 65;
				k++;
			}
		}
	}

	public static int[][] createMatrix(String input) {
		int[][] inputMatrix = new int[3][3];

		int k = 0;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				inputMatrix[i][j] = (int)input.charAt(k) - 65;
			}
		}

		return inputMatrix;
	}

	public static String encrypt(String input) {
		int[][] inputMatrix = createMatrix(input);
		String output = "";

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
				System.out.println(outputMatrix[i][j]);
			}
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;

		System.out.print("Enter plaintext: ");
		input = scan.nextLine();

		if(input.length() < 9) {
			while(input.length() < 9) {
				input += "x";
			}
		}

		input = input.toUpperCase();

		String output = encrypt(input);

		System.out.println(output);
	}
}