
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("4000");
		h2.parse("40000");
		
		
		System.out.println(h.isEqualTo(h2));

	}

}
