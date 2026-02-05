

public class Atbash_Cipher {

    public Atbash_Cipher(){

    }

    public String encipher(String message){
        message = message.toLowerCase();
        String encoded;
        char[] messageproc = message.toCharArray();
        char[] processing = new char[messageproc.length];
        for(int i = 0; i < messageproc.length; i++){
            if(messageproc[i] != ' '){
                int temp =  messageproc[i] - 'a';
                temp = ('z' - 'a') - temp;
                temp += 'a';
                processing[i] = (char) temp;
            }
            else processing[i] = ' ';
        }
        encoded = new String(processing);
        return encoded;
    }
}
