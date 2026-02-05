import java.util.*;
public class Playfair_Cipher {

    static boolean validateKey(String key){
        boolean validated = false;
        int[] isRepeated = new int[26];
        boolean onlyLetters = key.chars().allMatch(Character::isLetter);
        if(onlyLetters) {
            key = key.toLowerCase();
            char[] keyCharArray = key.toCharArray();
            for (int i = 0; i < keyCharArray.length; i++) {
                int letter = keyCharArray[i] - 'a';
                isRepeated[letter]++;
            }
            for (int i = 0; i < isRepeated.length; i++) {
                if (isRepeated[i] >= 2) {
                    System.out.println("No repeated letters allowed");
                    validated = false;
                    break;
                }
                validated = true;
            }
        }
        else System.out.println("Please input only letters in your key, no spaces or any special characters");
        return validated;
    }

    static char[][] makeMatrix(String key) {
        char[] keyArr = key.toCharArray();
        boolean[] letterPresent = new boolean[26];
        letterPresent[9] = true;
        char[][] matrix = new char[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i * 5 + j < keyArr.length) {
                    matrix[i][j] = keyArr[i * 5 + j];
                    letterPresent[keyArr[i * 5 + j] - 'a'] = true;
                } else {
                    for (int k = 0; k < letterPresent.length; k++) {
                        if (!letterPresent[k]) {
                            matrix[i][j] = (char) (k + 'a');
                            letterPresent[k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String key;
        String message;
        System.out.println("Please input your key");
        key = input.nextLine();
        if (validateKey(key)) {
            System.out.println("key approved");
            char[][] matrix = makeMatrix(key);
        } else {
            System.out.println("Invalid key entered");
        }
    }
}
