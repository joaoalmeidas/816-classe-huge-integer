
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
		
		if(ehZeroEsquerda == true) {
			numero = "0";
		}
		
		return numero;
	}
	
	public void add(HugeInteger hg) {
		
		for(int i = hg.getDigitos().length - 1; i >= 0; i--) {
			
			int soma = getDigitos()[i] + hg.getDigitos()[i];
			
			if(soma > 10) {
				
				getDigitos()[i] = soma%10;
				getDigitos()[i-1]++ ;
				
			}else {
				
				getDigitos()[i] = soma;
				
			}
			
		}
		
	}
	
	public void subtract(HugeInteger hg) {
		
		for(int i = hg.getDigitos().length - 1; i >= 0; i--) {
			
			if(getDigitos()[i] - hg.getDigitos()[i] < 0) {
				
				getDigitos()[i] = (10 + getDigitos()[i]) - hg.getDigitos()[i];
				getDigitos()[i-1]--;
				
			}else {
				
				getDigitos()[i] = getDigitos()[i] - hg.getDigitos()[i];
				
			}
			
		}
		
	}
}
