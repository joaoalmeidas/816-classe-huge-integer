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
		
		int[] multiplicacao = new int[getDigitos().length];
		int[] resultado = new int[getDigitos().length];
		boolean positivo;
		
		if(isNegative() == false && hg.isNegative() == false || isNegative() == true && hg.isNegative() == true) {
			positivo = true;
		}else {
			positivo = false;
		}
		
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			getDigitos()[i] = Math.abs(getDigitos()[i]);
			hg.getDigitos()[i] = Math.abs(hg.getDigitos()[i]);
			
		}
		
		for(int i = hg.getDigitos().length - 1; i >= 0; i--) {
			
			for(int j = getDigitos().length - 1; j >= 0; j--) {
				
				multiplicacao[j] = getDigitos()[j] * hg.getDigitos()[i];
				//System.out.println(getDigitos()[j]+ " * " +hg.getDigitos()[i]);
				
			}
			
			
			for(int j = getDigitos().length - 1; j >= 0; j--) {
				
				if(multiplicacao[j] >= 10) {
					
					multiplicacao[j-1] += multiplicacao[j] / 10;
					multiplicacao[j] = multiplicacao[j] % 10;
					
				}
				
			}
			
			for(int j = i, k = getDigitos().length - 1; j >= 0; j--, k--) {
				
				resultado[j] += multiplicacao[k];
						
			}
			
			
		}
		
		for(int i = resultado.length - 1; i >= 0; i--) {
			
			if(resultado[i] >= 10) {
				
				resultado[i - 1] += resultado[i]/10;
				resultado[i] %= 10;
				
			}
			
		}
		
		if(positivo == false) {
			
			for(int i = 0; i < resultado.length; i++) {
				
				if(resultado[i] != 0) {
					
					resultado[i] *= -1;
					i = resultado.length;
					
				}
				
			}
			
		}
		
		setDigitos(resultado);
		
	}
	
	public void divide(HugeInteger hg) {
		
		int divisor = 0, dividendo = 0;
		int[] resultado = new int[getDigitos().length];
		boolean positivo;
		
		if(isNegative() == false && hg.isNegative() == false || isNegative() == true && hg.isNegative() == true) {
			positivo = true;
		}else {
			positivo = false;
		}
		
		for(int i = 0; i < getDigitos().length; i++) {
			
			getDigitos()[i] = Math.abs(getDigitos()[i]);
			hg.getDigitos()[i] = Math.abs(hg.getDigitos()[i]);
			
		}
		
		
		for(int i = hg.getDigitos().length - 1, j = 1; i >= 0; i--, j *= 10) {
			
			divisor += hg.getDigitos()[i] * j;
			
		}
		
		for(int i = getDigitos().length - 1, j = 1; i >= 0; i--, j *= 10) {
			
			dividendo += getDigitos()[i] * j;
			
		}
		
		dividendo /= divisor;
		
		for(int i = resultado.length - 1; i >= 0 && divisor != 0; i--) {
			
			resultado[i] = dividendo%10;
			dividendo /=10;
		}
		
		if(positivo == false) {
			
			for(int i = 0; i < resultado.length; i++) {
				
				if(resultado[i] != 0) {
					
					resultado[i] *= -1;
					i = resultado.length;
					
				}
				
			}
			
		}
		
		setDigitos(resultado);
		
	}
	
	public void remainder(HugeInteger hg) {
		
		int[] original = getDigitos(); 
		
		divide(hg);
		multiply(hg);
		
		hg.setDigitos(getDigitos());
		setDigitos(original);
		
		subtract(hg);
		
	}
	
}
