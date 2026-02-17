import java.util.*;

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;
    System.out.println("------Enciphering Process------");
    System.out.println("1. Atbash Cipher \n" +
            "2. Caesar Cipher \n" +
            "3. Vigenere Cipher \n" +
            "4. Playfair Cipher \n" +
            "5. Autokey Cipher ");
    System.out.println("Choose the cipher you want");
    boolean validIn = false;
    String message;
    while (!validIn) {
        try {
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("You have selected the Atbash cipher");
                    System.out.println("The Atbash cipher is a simple cipher where each letter is is changed to the opposite" +
                            " letter.\nex: a -> z, b -> y, etc.");
                    System.out.println("Please enter your message");
                    message = input.nextLine();
                    Atbash_Cipher AtEncipherer = new Atbash_Cipher();
                    System.out.println("Your enciphered message is as follows:\n" + AtEncipherer.encipher(message));
                    validIn = true;
                    break;
                case 2:
                    System.out.println("You have selected the Caesar cipher");
                    System.out.println("The Caesar cipher is a simple cipher where each letter is shifted to the right" +
                            " based on the number of shift.\nex: If the shift is two  a -> c, b -> d, etc.");
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
                    System.out.println("The Vigenere cipher is a cipher that applied a diffrent amount of shift based on " +
                            "the key.\nThe letters of the key is used as a coordinate set with the corresponding letter from " +
                            "the message.\nThe resulting coordinate set is used in a matrix which applies a letter shift " +
                            "based on the y axis.\nThe key is extended to the size of the message to ensure each letter of the" +
                            " message has a corresponding key letter");
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
                    System.out.println("The Playfair cipher is a cipher that uses a 5x5 matrix to encode the message" +
                            " based on the key.\nThe key can not contain any spaces or repeating letters or be longer than 25 characters. \nthe key is then" +
                            " inserted into the matrix and then the normal alphabet follows to fill in the rest of the spaces.\n" +
                            " Usually the letter J is removed from the matrix to fit the 5x5 matrix.\nAny Js in the message is changed to " +
                            "an I");
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
                case 5:
                    System.out.println("You have selected the Autokey cipher");
                    System.out.println("The Autokey cipher is a cipher based on the Vigenere cipher were the key contains" +
                            " the message at the end.\nIt is considered more secure than the Vigenere cipher due to the" +
                            " key being repeated to fit the message");
                    Autokey_Cipher AuEncipherer = new Autokey_Cipher();
                    System.out.println("Please enter your key");
                    key = input.nextLine();
                    System.out.println("Please enter your message");
                    message = input.nextLine();
                    System.out.println("Your enciphered message is as follows:\n" + AuEncipherer.encipher(message, AuEncipherer.processString(key), AuEncipherer.processString(message)));
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
