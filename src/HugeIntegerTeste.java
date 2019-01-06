
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("10000000000000000009");
		h2.parse("1000000000000000009");
		
		h.isNegative();
		h2.isNegative();
		
		h.add(h2);
		
		
		System.out.println(h);

	}

}
