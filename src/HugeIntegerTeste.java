
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		
		h.parse("4654");
		
		for(int i = h.getDigitos().length - 1; i >= 0; i--) {
			
			System.out.printf("%d", h.getDigitos()[i]);
			
		}

	}

}
