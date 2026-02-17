public class Autokey_Cipher {

    public Autokey_Cipher(){

    }
    public String processString(String input){
        input = input.toLowerCase();
        input = input.replace(" ", "");
        return input;
    }

    public String encipher(String message, String key, String processedMessage){
        char[] processing = message.toCharArray();
        key = key.concat(processedMessage);
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
        return new String(encoded);
    }
}
