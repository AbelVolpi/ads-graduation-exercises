package tarefa2;

public class DiffieHellmanAlgorithm {
	
	int primeNumber;
	int generatorNumber;

	public DiffieHellmanAlgorithm(
		int primeNumber,
		int generatorNumber
	) {
		this.primeNumber = primeNumber;
		this.generatorNumber = generatorNumber;
	}
	
	 void execute() {
		int alicePrivateNumber = 5;
		int bobPrivateNumber = 4;
		
		int alicePublicNumber = generatePublicNumber(primeNumber, generatorNumber, alicePrivateNumber);
		int bobPublicNumber = generatePublicNumber(primeNumber, generatorNumber, bobPrivateNumber);
	
		int aliceSecretKeyGenerated = calculateSecretKey(primeNumber, bobPublicNumber, alicePrivateNumber);
		int bobSecretKeyGenerated = calculateSecretKey(primeNumber, alicePublicNumber, bobPrivateNumber);
	
		System.out.println("Chave gerada pela alice: "+ aliceSecretKeyGenerated);
		System.out.println("Chave gerada pelo bob: "+ bobSecretKeyGenerated);
	}

	public int generatePublicNumber(int primeNumber, int generatorNumber, int privateNumber) {
		return (int)Math.pow(generatorNumber, privateNumber) % primeNumber;
	}
	
	public int calculateSecretKey(int primeNumber, int externalPublicNumber, int privateNumber) {
		return (int)Math.pow(externalPublicNumber, privateNumber) % primeNumber;
	}

}
