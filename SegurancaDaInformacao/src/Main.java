import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        caesarCipher();
        vigenereCipher();
    }

    private static void caesarCipher() {
        int key = 2;
        CaesarCipher cipher = new CaesarCipher(key);

        // Pegar texto do usuário
        System.out.println("Escreva sua mensagem");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        // Encriptar e decriptar
        String encryptedText = cipher.encrypt(text);
        String decryptedText = cipher.decrypt(encryptedText);

        // Mostrar resultado
        System.out.println("Sua mensagem criptografada com Cifra de Cesar é:");
        System.out.println(encryptedText);
        System.out.println("Sua mensagem descriptografada com Cifra de Cesar é:");
        System.out.println(decryptedText);
    }

    private static void vigenereCipher() {
        String key = "key";
        VigenereCipher cipher = new VigenereCipher(key);

        // Pegar texto do usuário
        System.out.println("Escreva sua mensagem");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        // Encriptar e decriptar
        String encryptedText = cipher.encrypt(text);
        String decryptedText = cipher.decrypt(encryptedText);

        // Mostrar resultado
        System.out.println("Sua mensagem criptografada com Cifra de Vigenere é:");
        System.out.println(encryptedText);
        System.out.println("Sua mensagem descriptografada com Cifra de Vigenere é:");
        System.out.println(decryptedText);
    }
}