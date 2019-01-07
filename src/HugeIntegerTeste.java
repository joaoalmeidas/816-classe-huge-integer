public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("-100");
		h2.parse("3");
		
		
		
		h.divide(h2);
		
		
		System.out.println(h);

	}

}
