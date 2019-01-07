public class HugeIntegerTeste {

	public static void main(String[] args) {
		
		HugeInteger h = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		h.parse("15");
		h2.parse("120");
		
		System.out.println(h.toString()+" + "+h2.toString());
		h.add(h2);
		System.out.println(h);
		
		System.out.println("\n"+h.toString()+" - "+h2.toString());
		h.subtract(h2);
		System.out.println(h);
		
		System.out.println("\n"+h.toString()+" * "+h2.toString());
		h.multiply(h2);
		System.out.println(h);
		
		System.out.println("\n"+h.toString()+" / "+h2.toString());
		h.divide(h2);
		System.out.println(h);
		
		System.out.println("\n"+h.toString()+" % "+h2.toString());
		h.remainder(h2);
		System.out.println(h);
		
		System.out.println("\n"+h.toString()+" � igual a "+h2.toString()+" ?");
		System.out.println(h.isEqualTo(h2));
		
		System.out.println("\n"+h.toString()+" � diferente de "+h2.toString()+" ?");
		System.out.println(h.isNotEqualTo(h2));
		
		System.out.println("\n"+h.toString()+" � maior que "+h2.toString()+" ?");
		System.out.println(h.isGreaterThan(h2));
		
		System.out.println("\n"+h.toString()+" � menor que "+h2.toString()+" ?");
		System.out.println(h.isLessThan(h2));
		
		System.out.println("\n"+h.toString()+" � maior ou igual que "+h2.toString()+" ?");
		System.out.println(h.isGreaterThanOrEqualTo(h2));
		
		System.out.println("\n"+h.toString()+" � menor ou igual que "+h2.toString()+" ?");
		System.out.println(h.isLessThanOrEqualTo(h2));

	}

}
