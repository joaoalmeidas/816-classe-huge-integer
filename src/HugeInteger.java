
public class HugeInteger {
	
	private int[] digitos = new int[40];

	public int[] getDigitos() {
		return digitos;
	}

	public void setDigitos(int[] digitos) {
		this.digitos = digitos;
	}
	
	public void parse(String numero) {
		
		
		
		for(int i = (getDigitos().length) - numero.length(), j = 0 ; i < getDigitos().length; i++, j++) {
			
			digitos[i] = Character.getNumericValue(numero.charAt(j));
			
		}
		
	}
	
	public String toString() {
		
		String numero = "";
		boolean ehZeroEsquerda = true;
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			if(getDigitos()[i] != 0 && ehZeroEsquerda == true) {
				ehZeroEsquerda = false;
			}
			
			if(ehZeroEsquerda == false) {
				numero += getDigitos()[i];
			}
			
		}
		
		return numero;
	}
}
