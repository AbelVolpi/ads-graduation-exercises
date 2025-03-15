import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {
    private final int key;
    private final char[] alphabet;
    private final Map<Character, Integer> alphabetMap;

    public CaesarCipher(int key) {
        this.key = key;
        this.alphabet = new char[]{
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        this.alphabetMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetMap.put(alphabet[i], i);
        }
    }

    public String encrypt(String text) {
        // Criptografar
        char[] textChars = text.toCharArray();
        char[] encryptedText = new char[textChars.length];
        for (int i = 0; i < textChars.length; i++) {
            int charPosition = alphabetMap.get(textChars[i]);
            int updatedCharPosition = (charPosition + key) % alphabet.length;
            encryptedText[i] = alphabet[updatedCharPosition];
        }
        return new String(encryptedText);
    }

    public String decrypt(String text) {
        // Descriptografar
        char[] textChars = text.toCharArray();
        char[] decryptedText = new char[textChars.length];
        for (int i = 0; i < textChars.length; i++) {
            int charPosition = alphabetMap.get(textChars[i]);
            int updatedCharPosition = ((charPosition - key + 26) % alphabet.length);
            decryptedText[i] = alphabet[updatedCharPosition];
        }
        return new String(decryptedText);
    }
}
