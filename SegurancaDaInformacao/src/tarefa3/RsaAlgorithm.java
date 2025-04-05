package tarefa3;

public class RsaAlgorithm {

    private int n, phi, e, d;

    public RsaAlgorithm(int p, int q) {
        this.n = p * q;
        this.phi = (p - 1) * (q - 1);

        this.e = findE(phi);  // Escolhe um valor de e que seja coprimo com phi (para compor a chave pública)
        this.d = findModInverse(e, phi); // Escolhe o inverso modular (para compor a chave privada)
    }

    // Função para encontrar um 'e' coprimo com φ
    private int findE(int phi) {
        for (int i = 2; i < phi; i++) {
            if (gcd(i, phi) == 1) {
                return i;
            }
        }
        return 3; // fallback
    }

    // Máximo divisor comum (para garantir que e e phi sejam coprimos)
    private int gcd(int a, int b) {
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    // Inverso modular: encontra d tal que (e * d) % phi == 1
    private int findModInverse(int e, int phi) {
        for (int d = 1; d < phi; d++) {
            if ((e * d) % phi == 1) {
                return d;
            }
        }
        throw new ArithmeticException("Não existe inverso modular");
    }

    // Calcula (base^expoente) % mod de forma eficiente
    private int modularPower(int base, int power, int mod) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result = (result * base) % mod;
        }
        return result;
    }


    public String getPublicKey() {
        return "Chave pública: (e = " + e + ", n = " + n + ")";
    }

    // Criptografa um número
    public int encrypt(int message) {
        return modularPower(message, e, n);
    }

    // Criptografa um número
    public int decrypt(int encryptedMessage) {
        return modularPower(encryptedMessage, d, n);
    }
}
