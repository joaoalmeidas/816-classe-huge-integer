
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("-1");
		h2.parse("-10");
		
		h.isNegative();
		h2.isNegative();
		
		h.add(h2);
		
		
		System.out.println(h);

	}

}
