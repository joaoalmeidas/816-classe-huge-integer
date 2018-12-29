import java.util.Arrays;

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
			
			if(numero.charAt(j) == '-') {
				
				digitos[i] = 0;
				digitos[i+1] = -1;
				
			}else if(digitos[i] == -1) {
				
				digitos[i] = Character.getNumericValue(numero.charAt(j)) * -1;
				
			}else {
				
				digitos[i] = Character.getNumericValue(numero.charAt(j));
				
			}
			
			
			
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
			
			if(soma > 9) {
				
				getDigitos()[i] = soma%10;
				getDigitos()[i-1]++ ;
				
			}else {
				
				getDigitos()[i] = soma;
				
			}
			
		}
		
	}
	
	public void subtract(HugeInteger hg) {
		
		boolean maiorigual = false;
		int [] maior, menor;
		
		for(int i = 0; i < hg.getDigitos().length; i++) {
			
			if(getDigitos()[i] != 0) {
				
				if(getDigitos()[i] > hg.getDigitos()[i] && maiorigual == false) {
					
					maiorigual = true;
					
				}
				
			}
			
		}
		
		if(maiorigual == true) {
			
			maior = getDigitos();
			menor = hg.getDigitos();
			
		}else {
			
			maior = hg.getDigitos();
			menor = getDigitos();
			
		}
		
		for(int i = hg.getDigitos().length - 1; i >= 0; i--) {
			
			if(maior[i] - menor[i] < 0) {
				
				maior[i] = (10 + maior[i]) - menor[i];
				maior[i-1]--;
				
			}else {
				
				maior[i] = maior[i] - menor[i];
				
			}
			
		}
		
		if(maiorigual == false) {
			
			int i = -1;
			
			do {
				
				i++;
				
				if(maior[i] != 0) {
					
					maior[i] *= -1;
					
				}
				
				
			}while(maior[i] == 0 && i < maior.length);
			
		}
		
		setDigitos(maior);
		
	}
	
	public boolean isEqualTo(HugeInteger hg) {
		
		boolean igual = true;
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			if(igual == true && getDigitos()[i] != hg.getDigitos()[i]) {
				igual = false;
			}
			
		}
		
		return igual;
		
	}
	
	public boolean isNotEqualTo(HugeInteger hg) {
		
		return !isEqualTo(hg);
		
	}
	
	public boolean isGreaterThan(HugeInteger hg) {
		
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			if(getDigitos()[i] != hg.getDigitos()[i]) {
				
				if(getDigitos()[i] > hg.getDigitos()[i]) {
					
					
					return true;
					
				}else {
					
					return false;
					
				}
				
			}
			
		}
		
		return false;
	
	}
	
	public boolean isLessThan(HugeInteger hg) {
		
		return !isGreaterThan(hg) && !isEqualTo(hg);
		
	}
	
	public boolean isGreaterThanOrEqualTo(HugeInteger hg) {
		
		return isGreaterThan(hg) || isEqualTo(hg);
		
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger hg) {
		
		return isLessThan(hg) || isEqualTo(hg);
		
	}
	
	public boolean isZero() {
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			if(getDigitos()[i] != 0) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	
}
