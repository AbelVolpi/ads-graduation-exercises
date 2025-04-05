package tarefa3;

public class Main {
    public static void main(String[] args) {
        RsaAlgorithm rsa = new RsaAlgorithm(11, 17);

        int original = 42;
        int encrypted = rsa.encrypt(original);
        int decrypted = rsa.decrypt(encrypted);

        System.out.println("Chave pública: " + rsa.getPublicKey());
        System.out.println("Original: " + original);
        System.out.println("Criptografado: " + encrypted);
        System.out.println("Descriptografado: " + decrypted);
    }
}
