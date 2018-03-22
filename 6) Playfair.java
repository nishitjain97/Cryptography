import java.util.Scanner;

class Playfair {
	static String key = "HOW ARE YOU";
	static char[][] polySquare = new char[5][5];

	public static boolean inSquare(char c) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(polySquare[i][j] == c) {
					return true;
				}
			}
		}
		return false;
	}

	static {
		int j = 0, k = 0;
	
		for(int i = 0; i < key.length(); i++) {
			if(key.charAt(i) != ' ') {
				if(k > 4) {
					k -= 5;
					j++;
				}

				if(!inSquare(key.charAt(i))) {
					polySquare[j][k] = key.charAt(i);
					k++;
				}
			}
		}

		for(int i = 0; i < 5; i++) {
			for(j = 0; j < 5; j++) {
				if((int)polySquare[i][j] == 0) {
					for(k = 65; k < 98; k++) {
						if(!inSquare((char)k) && (char)k != 'J') {
							polySquare[i][j] = (char)k;
							break;
						}
					}
				}
			}
		}
	}

	public static int[] getIndex(char c1, char c2) {
		int[] result = new int[4];

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(polySquare[i][j] == c1) {
					result[0] = i;
					result[1] = j;
				}
				else if(polySquare[i][j] == c2) {
					result[2] = i;
					result[3] = j;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter plaintext: ");
		String input = scan.nextLine();
		input = input.toUpperCase();

		String output = "";

		int length = input.length();
		int i = 0;

		for(; i < length; i += 2) {
			if(i+1 < length) {
				if(input.charAt(i) == input.charAt(i+1)) {
					input = input.substring(0, i+1) + "X" + input.substring(i+1, length);
					length = input.length();
					i = 0;
					continue;
				}
			}
		}

		if(input.length() % 2 != 0) {
			input += "X";
		}

		for(i = 0; i < input.length(); i += 2) {
			int[] indices = getIndex(input.charAt(i), input.charAt(i+1));
			int X1 = indices[0];
			int Y1 = indices[1];
			int X2 = indices[2];
			int Y2 = indices[3];

			if(X1 == X2) {
				Y1++;
				Y2++;

				if(Y1 > 4) {
					Y1 = Y1 - 5;
				}
				if(Y2 > 4) {
					Y2 = Y2 - 5;
				}
			}
			else if(Y1 == Y2) {
				X1++;
				X2++;

				if(X1 > 4) {
					X1 = X1 - 5;
				}
				if(X2 > 4) {
					X2 = X2 - 5;
				}
			}
			else {
				int temp = Y2;
				Y2 = Y1;
				Y1 = temp;
			}

			output += "" + polySquare[X1][Y1] + polySquare[X2][Y2];
		}
		
		System.out.println(output);
	}
}