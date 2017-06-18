package trabalhos;

/**
 * 
 * @author vitorh.brangioni
 *
 */
public class Bruxa7x1 {

	
	public Double calcule(Integer x, Integer y, String operador) {
		
		Double result = null;
		
		int indexOfX = x.toString().indexOf('7');
		int indexOfY = y.toString().indexOf('7');
		
		if (indexOfX > -1) {
			String newValue = "";
			char num;
			for (int i = 0; i < x.toString().length(); i++) {
				num = x.toString().charAt(i);
				if (num == '7') {
					num = '0';
				}
				newValue += num;
			}
			x = Integer.parseInt(newValue);
		}
		if (indexOfY > -1) {
			String newValue = "";
			char num;
			for (int i = 0; i < y.toString().length(); i++) {
				num = y.toString().charAt(i);
				if (num == '7') {
					num = '0';
				}
				newValue += num;
			}
			y = Integer.parseInt(newValue);
		}
		
		switch (operador) {
		case "+":
			result = (double) (x + y);
			break;

		case "-":
			result = (double) (x - y);
			break;
			
		case "x":
			result = (double) (x * y);
			break;
			
		case "/":
			result = (double) (x / y);
			break;
		}
		
		String stringResult = String.valueOf(result);
		String newValue = "";
			
		for (int i = 0; i < stringResult.length(); i++) {
			char letra = stringResult.charAt(i);
			if (letra == '7') {
				letra = '0';
			}
			newValue += letra;
		}
		return Double.parseDouble(newValue);
	}
		
}
