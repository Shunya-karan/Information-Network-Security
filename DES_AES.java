import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES_AES {

    // Generate Key
    static SecretKey generateKey(String algorithm) throws Exception {
        // KeyGenerator kg = KeyGenerator.getInstance(algorithm);
        // return kg.generateKey();
        KeyGenerator kg = KeyGenerator.getInstance(algorithm);
        return kg.generateKey();
    }

    // Encrypt
    static String encrypt(String text, SecretKey key, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(text.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt
    static String decrypt(String encryptedText, SecretKey key, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);

        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encrypted = Base64.getDecoder().decode(encryptedText);

        byte[] decrypted = cipher.doFinal(encrypted);

        return new String(decrypted);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Choose algorithm
        System.out.println("1. DES");
        System.out.println("2. AES");
        System.out.print("Choose Algorithm: ");

        int choice = sc.nextInt();
        sc.nextLine();

        String algorithm;

        if (choice == 1) {
            algorithm = "DES";
        } else if (choice == 2) {
            algorithm = "AES";
        } else {
            System.out.println("Invalid Choice");
            sc.close();
            return;
        }

        // Input text
        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        // Generate key
        SecretKey key = generateKey(algorithm);

        // Encrypt
        String encrypted = encrypt(text, key, algorithm);

        // Decrypt
        String decrypted = decrypt(encrypted, key, algorithm);

        // Output
        System.out.println("\nAlgorithm: " + algorithm);
        System.out.println("Encryption: " + encrypted);
        System.out.println("Decryption: " + decrypted);

        sc.close();
    }
}