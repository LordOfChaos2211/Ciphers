public class Vigenere_Cipher {

    public Vigenere_Cipher(){

    }

    static char[] keyextender(String key, int messagelength){
        char[] extendedkey = new char[messagelength];
        char[] shortkey = key.toCharArray();
        for(int i = 0; i < extendedkey.length; i++){
            extendedkey[i] = shortkey[i % shortkey.length];
        }
        return extendedkey;
    }

    public String encipher(String message, String key){
        char[][] matrix = new char[26][26];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                char temp = (char) 0;
                temp = (char) ((temp + j + i)%26);
                temp += 'a';
                matrix[i][j] = temp;
            }
        }

        String enciphered;
        String trimmedLengthGetter = message.replace(" ","");
        char[] keyarr = keyextender(key,trimmedLengthGetter.length());
        char[] encoding = new char[message.length()];
        char[] messagearr = message.toCharArray();
        for(int i = 0, j = 0; i < encoding.length; i++){
            if(messagearr[i] != ' '){
                encoding[i] = matrix[messagearr[i] - 'a'][keyarr[j] - 'a'];
                j++;
            }
            else encoding[i] = ' ';
        }
        enciphered = new String(encoding);
        return enciphered;
    }
}
