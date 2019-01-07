public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("99");
		h2.parse("-324");
		
		
		
		h.multiply(h2);
		
		
		System.out.println(h);

	}

}
