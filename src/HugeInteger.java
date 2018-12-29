
public class HugeInteger {
	
	private int[] digitos = new int[40];

	public int[] getDigitos() {
		return digitos;
	}

	public void setDigitos(int[] digitos) {
		this.digitos = digitos;
	}
	
	public void parse(String numero) {
		
		for(int i = 0; i < numero.length(); i++) {
			
			digitos[i] = Character.getNumericValue(numero.charAt(i));
			
		}
		
	}
}
