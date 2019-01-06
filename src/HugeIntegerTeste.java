
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("100");
		h2.parse("-200");
		
		
		
		h.add(h2);
		
		
		System.out.println(h);

	}

}
