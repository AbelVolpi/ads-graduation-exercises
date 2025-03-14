import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] alphabet = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetMap.put(alphabet[i], i);
        }

        // Pegar texto do usuário
        System.out.println("Input your text");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] textChars = text.toCharArray();

        // key
        int key = 2;

        // Criptografar
        char[] encryptedText = new char[textChars.length];
        for (int i = 0; i < textChars.length; i++) {
            int charPosition = alphabetMap.get(textChars[i]);
            int updatedCharPosition = (charPosition + key) % alphabet.length;
            encryptedText[i] = alphabet[updatedCharPosition];
        }
        System.out.println("Sua mensagem criptografada é:");
        System.out.println(encryptedText);

        // Descriptografar
        char[] decryptedText = new char[textChars.length];
        for (int i = 0; i < encryptedText.length; i++) {
            int charPosition = alphabetMap.get(encryptedText[i]);
            int updatedCharPosition = ((charPosition - key + 26) % alphabet.length);
            decryptedText[i] = alphabet[updatedCharPosition];
        }
        System.out.println("Sua mensagem descriptografada é:");
        System.out.println(decryptedText);
    }
}