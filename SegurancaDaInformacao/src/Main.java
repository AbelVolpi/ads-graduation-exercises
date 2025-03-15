import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int key = 2;
        CaesarCipher cipher = new CaesarCipher(key);

        // Pegar texto do usuário
        System.out.println("Input your text");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        // Encriptar e decriptar
        String encryptedText = cipher.encrypt(text);
        String decryptedText = cipher.decrypt(encryptedText);

        System.out.println("Sua mensagem criptografada é:");
        System.out.println(encryptedText);
        System.out.println("Sua mensagem descriptografada é:");
        System.out.println(decryptedText);
    }
}