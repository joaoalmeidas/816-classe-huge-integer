public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("-10");
		h2.parse("-150");
		
		
		
		h.subtract(h2);
		
		
		System.out.println(h);

	}

}
