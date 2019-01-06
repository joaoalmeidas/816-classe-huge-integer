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
		
		if(isNegative() == true && hg.isNegative() == true) {
			
			for(int i = hg.getDigitos().length - 1; i >= 0; i--) {	
				
				int soma = Math.abs(getDigitos()[i]) + Math.abs(hg.getDigitos()[i]);
				
				if(soma >= 10) {
					
					getDigitos()[i] = soma%10;
					getDigitos()[i - 1] = Math.abs(getDigitos()[i - 1]) + soma/10;
					
				}else{
					
					getDigitos()[i] = soma; 
					
				}
				
			}
			
			for(int i = 0; i < getDigitos().length; i++) {
				
				if(getDigitos()[i] != 0) {
					
					getDigitos()[i] *= -1;
					
					i = getDigitos().length;
					
				}
				
			}
			
		}else if(isNegative() == false && hg.isNegative() == false) {
			
			for(int i = 0 ; i < getDigitos().length; i++) {
				
				int soma = getDigitos()[i] + hg.getDigitos()[i];
				
				if(soma >= 10) {
					
					getDigitos()[i] = soma%10;
					getDigitos()[i - 1] += soma/10;
					
				}else {
					
					getDigitos()[i] = soma;
					
				}
				
			}
			
		}else{
			
			boolean negative;
			
			if(isEqualTo(hg)) {
				
				for(int i = 0; i < getDigitos().length; i++) {
					
					getDigitos()[i] = 0;
					
				}
				
			}else{
				
				if(isNegative() == true) {
					
					negative = true;
					
				}else{
					
					negative = false;
					
				}
				
				for(int i = 0 ; i < getDigitos().length; i++) {
					
					getDigitos()[i] = Math.abs(getDigitos()[i]);
					hg.getDigitos()[i] = Math.abs(hg.getDigitos()[i]);
					
				}
				
				if(isGreaterThan(hg) == true && negative == true) {
					
					subtract(hg);
					
					for(int i = 0; i < getDigitos().length; i++) {
						
						if(getDigitos()[i] != 0) {
							
							getDigitos()[i] *= -1;
							i = getDigitos().length;
							
						}
						
					}
					
				}else if(isGreaterThan(hg) == true && negative == false) {
					
					subtract(hg);
					
				}else if(isGreaterThan(hg) == false && negative == true) {
					
					int[] provisorio = getDigitos();
					setDigitos(hg.getDigitos());
					hg.setDigitos(provisorio);
					
					subtract(hg);
					
				}else if(isGreaterThan(hg) == false && negative == false) {
					
					int[] provisorio = getDigitos();
					setDigitos(hg.getDigitos());
					hg.setDigitos(provisorio);
					
					subtract(hg);
					
					for(int i = 0; i < getDigitos().length; i++) {
						
						if(getDigitos()[i] != 0) {
							
							getDigitos()[i] *= -1;
							i = getDigitos().length;
							
						}
						
					}
					
				}
				
				
			}
			
		}
		
		
		
		
	}
	
	public void subtract(HugeInteger hg) {
		
		if(isNegative() == false && hg.isNegative() == false) {
			
			boolean negativo = false; 
			
			if(isGreaterThan(hg) == false) {
				
				negativo = true;
				
				int[] provisorio = getDigitos();
				setDigitos(hg.getDigitos());
				hg.setDigitos(provisorio);
				
				
			}
			
			for(int i = getDigitos().length - 1; i >= 0; i--) {
				
				
				if(getDigitos()[i] < hg.getDigitos()[i]) {
					
					getDigitos()[i - 1]--;
					getDigitos()[i] += 10;
					
					getDigitos()[i] -= hg.getDigitos()[i];
					
				}else {
					
					getDigitos()[i] -= hg.getDigitos()[i];
					
				}
				
			}
			
			if(negativo == true) {
				
				for(int i = 0; i < getDigitos().length; i++) {
					
					if(getDigitos()[i] != 0) {
						
						getDigitos()[i] *= -1;
						i = getDigitos().length;
						
					}
					
					
				}
				
			}
			
			
			
		}else if(hg.isNegative() == true) {
			
			for(int i = 0; i < getDigitos().length; i++) {
				hg.getDigitos()[i] = Math.abs(hg.getDigitos()[i]);
			}
			
			add(hg);
			
		}else {
			
			
			//primeiro - negativo, hg - positivo
			
			for(int i = 0; i < getDigitos().length; i++) {
				
				getDigitos()[i] = Math.abs(getDigitos()[i]);
				hg.getDigitos()[i] = Math.abs(hg.getDigitos()[i]);
				
			}
			
			add(hg);
			
			for(int i = 0; i < getDigitos().length; i++) {
				
				if(getDigitos()[i] != 0) {
					
					getDigitos()[i] *= -1;
					i = getDigitos().length;
					
				}
				
			}
			
			
			
			/*
			for(int i = getDigitos().length - 1; i >= 0; i--) {
				
				
				if(getDigitos()[i] < hg.getDigitos()[i]) {
					
					getDigitos()[i - 1]--;
					getDigitos()[i] += 10;
					
					getDigitos()[i] -= hg.getDigitos()[i];
					
				}else {
					
					getDigitos()[i] -= hg.getDigitos()[i];
					
				}
				
			}
			*/
			
		}
		
		
		
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
	
	public boolean isNegative() {
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			if(getDigitos()[i] < 0) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public void multiply(HugeInteger hg) {
		
		for(int i = hg.getDigitos().length; i >= 0; i--) {
			


			
		}
		
	}
	
}
