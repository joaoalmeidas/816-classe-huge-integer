
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("4000");
		h2.parse("4000");
		
		System.out.println(h.toString());
		System.out.println(h2.toString());
		
		System.out.println(h.isLessThan(h2));

	}

}
