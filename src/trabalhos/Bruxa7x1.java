package trabalhos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author vitorh.brangioni
 *
 */
public class Bruxa7x1 {

	public static Integer calcule(Integer x, Integer y, String operador) {
		
		Integer result = null;
		
		x = Integer.parseInt(x.toString().replaceAll("7", "0"));
		y = Integer.parseInt(y.toString().replaceAll("7", "0"));
		
		switch (operador) {
		case "+":
			result = (x + y);
			break;

		case "-":
			result = (x - y);
			break;
			
		case "x":
			result = (x * y);
			break;
			
		case "/":
			result = (x / y);
			break;
		}
		return Integer.parseInt(result.toString().replaceAll("7", "0"));
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();
        
        while (read != null && !read.equals("")) {
            String[] entrada = read.split(" ");
            Integer x = Integer.parseInt(entrada[0]);
            String operator = String.valueOf(entrada[1].charAt(0));
            Integer y = Integer.parseInt(entrada[2]);
            System.out.println(calcule(x, y, operator));
            read = br.readLine();
        }
        br.close();
    }
		
}
