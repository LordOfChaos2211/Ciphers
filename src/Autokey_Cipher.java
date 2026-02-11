import java.util.*;
public class Autokey_Cipher {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String key = input.nextLine();
        String message = input.nextLine();
        String enciphered;
        char[] processing = message.toCharArray();
        key = key.toLowerCase();
        key = key.replace(" ","");
        message = message.toLowerCase();
        message = message.replace(" ","");
        key = key.concat(message);
        char[] keyCharArray = key.toCharArray();
        char[] encoded = new char[processing.length];

        char[][] matrix = new char[26][26];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                char temp = (char) 0;
                temp = (char) ((temp + j + i)%26);
                temp += 'a';
                matrix[i][j] = temp;
            }
        }
        for(int i = 0 , j = 0; i < encoded.length; i++){
            if(processing[i] != ' '){
                encoded[i] = matrix[processing[i] - 'a'][keyCharArray[j] - 'a'];
                j++;
            }
            else{
                encoded[i] = ' ';
            }
        }
        enciphered = new String(encoded);
        System.out.println(enciphered);
    }
}
