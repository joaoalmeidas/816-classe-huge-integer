
public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("-500");
		h2.parse("100");
		
		//h.subtract(h2);
		
		System.out.println(h.toString());

	}

}
