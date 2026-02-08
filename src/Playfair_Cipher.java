import java.util.*;
public class Playfair_Cipher {

    public Playfair_Cipher(){
    }

    public boolean validateKey(String key){
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

    static char[] processInput(String message){
        message = message.toLowerCase();
        message = message.replace('j','i');
        message = message.replace(" ","");
        char [] messageCharArray = message.toCharArray();
        ArrayList<Character> paired = new ArrayList<Character>();
        for(int i = 0; i < messageCharArray.length; i++){
            if(i + 1>= messageCharArray.length){
                paired.add(messageCharArray[i]);
                paired.add('x');
            }
            else {
                if (messageCharArray[i] == messageCharArray[i + 1]) {
                    paired.add(messageCharArray[i]);
                    paired.add('x');
                }
                else {
                    paired.add(messageCharArray[i]);
                    paired.add(messageCharArray[i + 1]);
                    i++;
                }
            }
        }
        return paired.toString().replaceAll("\\W","").toCharArray(); // I can't believe this works
    }

    public String encipher(String key, String message){
        char[][] matrix = makeMatrix(key);
        char[] pairedInput = processInput(message);
        System.out.println();
        for(int i = 0; i < pairedInput.length; i = i+2){
            int[] coord1 = new int[2];
            int[] coord2 = new int[2];
            boolean letterFound = false;
            for(int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (pairedInput[i] == matrix[j][k]) {
                        coord1 = new int[]{j, k};
                        letterFound = true;
                        break;
                    }
                    if (letterFound) break;
                }
            }
            letterFound = false;
            for(int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (pairedInput[i + 1] == matrix[j][k]) {
                        coord2 = new int[]{j, k};
                        letterFound = true;
                        break;
                    }
                    if (letterFound) break;
                }
            }
            if(coord1[0] == coord2[0]){
                pairedInput[i] = matrix[coord1[0]][(coord1[1]+1)%5];
                pairedInput[i+1] = matrix[coord2[0]][(coord2[1]+1)%5];
            }
            else if(coord1[1] == coord2[1]){
                pairedInput[i] = matrix[(coord1[0]+1)%5][coord1[1]];
                pairedInput[i+1] = matrix[(coord2[0]+1)%5][coord2[1]];
            }
            else{
                pairedInput[i] = matrix[coord1[0]][coord2[1]];
                pairedInput[i+1] = matrix[coord2[0]][coord1[1]];
            }
        }
        String enciphered = new String(pairedInput);
        return enciphered;
    }
}
