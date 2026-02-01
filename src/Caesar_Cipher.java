import java.util.*;

public class Caesar_Cipher {
    public Caesar_Cipher(){

    }

    static char shifter(char in, int shift){
        int temp = in;
        if(in >= 'a' && in <= 'z'){
            temp = (temp - 'a' + shift) % 26;
            temp += 'a';
        }
        else{
            temp = (temp - 'A' + shift) % 26;
            temp += 'A';
        }
        return (char) temp;
    }
    public String encipher(String message, int shift){
        String Enciphered;
        shift = shift % 26;
        char[] holder = message.toCharArray();
        for(int i = 0; i < holder.length; i++){
            if(holder[i] != ' '){
                char temp = holder[i];
                holder[i] = shifter(temp,shift);
            }
        }
        Enciphered = new String(holder);
        return Enciphered;
    }
}
