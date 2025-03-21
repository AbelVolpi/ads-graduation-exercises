package tarefa1;

import java.util.HashMap;
import java.util.Map;

public class VigenereCipher {
    private final String key;
    private final char[] alphabet;
    private final Map<Character, Integer> alphabetMap;

    public VigenereCipher(String key) {
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
        char[] textChars = text.toCharArray();
        char[] encryptedText = new char[textChars.length];
        int keyLength = key.length();
        int keyIndex = 0;

        for (int i = 0; i < textChars.length; i++) {
            int textCharPosition = alphabetMap.get(textChars[i]);
            int keyCharPosition = alphabetMap.get(key.charAt(keyIndex % keyLength));
            int encryptedCharPosition = (textCharPosition + keyCharPosition) % alphabet.length;
            encryptedText[i] = alphabet[encryptedCharPosition];
            keyIndex++;
        }
        return new String(encryptedText);
    }

    public String decrypt(String text) {
        char[] textChars = text.toCharArray();
        char[] encryptedText = new char[textChars.length];
        int keyLength = key.length();
        int keyIndex = 0;

        for (int i = 0; i < textChars.length; i++) {
            int textCharPosition = alphabetMap.get(textChars[i]);
            int keyCharPosition = alphabetMap.get(key.charAt(keyIndex % keyLength));
            int encryptedCharPosition = (textCharPosition - keyCharPosition + 26) % alphabet.length;
            encryptedText[i] = alphabet[encryptedCharPosition];
            keyIndex++;
        }
        return new String(encryptedText);
    }
}
