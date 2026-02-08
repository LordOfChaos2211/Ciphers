
import java.util.*;

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;
    System.out.println("------Enciphering Process------");
    System.out.println("1. Atbash Cipher \n" +
            "2. Caesar Cipher \n" +
            "3. Vigenere Cipher \n" +
            "4. Playfair Cipher" );
    System.out.println("Choose the cipher you want");
    boolean validIn = false;
    String message;
    while (!validIn) {
        try {
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("You have selected the Atbash cipher");
                    System.out.println("Please enter your message");
                    message = input.nextLine();
                    Atbash_Cipher AtEncipherer = new Atbash_Cipher();
                    System.out.println("Your enciphered message is as follows:\n" + AtEncipherer.encipher(message));
                    validIn = true;
                    break;
                case 2:
                    System.out.println("You have selected the Caesar cipher");
                    System.out.println("Please enter your message");
                    message = input.nextLine();
                    System.out.println("Please enter the shift number for the cipher");
                    int shift = Integer.parseInt(input.nextLine());
                    Caesar_Cipher CaEncipherer = new Caesar_Cipher();
                    System.out.println("Your enciphered message is as follows:\n" + CaEncipherer.encipher(message,shift));
                    validIn = true;
                    break;
                case 3:
                    System.out.println("You have selected the Vigenere cipher");
                    System.out.println("Please enter your message");
                    message = input.nextLine();
                    System.out.println("Please enter the key for your cipher");
                    String key = input.nextLine();
                    Vigenere_Cipher ViEncipherer = new Vigenere_Cipher();
                    System.out.println("Your enciphered message is as follows:\n" + ViEncipherer.encipher(message,key));
                    validIn = true;
                    break;
                case 4:
                    System.out.println("You have selected the Playfair cipher");
                    Playfair_Cipher PlEncipherer = new Playfair_Cipher();
                    System.out.println("Please enter your key");
                    key = input.nextLine();
                    while(!PlEncipherer.validateKey(key)){
                        System.out.println("Invalid key entered. Please enter a valid key. \nA valid key consists of non-duplicate letters");
                        key = input.nextLine();
                    }
                    System.out.println("Please enter your message");
                    message = input.nextLine();
                    System.out.println("Your enciphered message is as follows:\n" + PlEncipherer.encipher(key,message));
                    validIn = true;
                    break;
                default:
                    System.out.println("Invalid input detected please choose from the above options");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input detected please choose from the above options");
            input.next();
        }
    }
}
