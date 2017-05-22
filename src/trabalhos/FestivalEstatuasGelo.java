package trabalhos;

import java.security.InvalidParameterException;

/**
 * 
 * @author vitorbrangioni
 *
 */
public class FestivalEstatuasGelo {

	private int[] blocos;
	private int[][] matriz;
	private int coluna;
	private int linha;

	public FestivalEstatuasGelo(int[] blocos, int comprimento) {
		if (blocos == null || blocos.length == 0) {
			throw new InvalidParameterException();
		}
		this.blocos = blocos;
		this.matriz = new int[blocos.length][comprimento + 1];
		this.coluna = comprimento + 1;
		this.linha = blocos.length;
	}
	
	public int getMinBlocos() {
		for (int i = 0; i < blocos.length; i++) {
			matriz[i][0] = 0;
		}
		for (int j = 0; j < coluna; j++) {
			matriz[0][j] = j;
		}
		for (int i = 1; i < blocos.length; i++) {
			for (int j = 0; j < coluna; j++) {
				if (j < blocos[i]) {
					matriz[i][j] = matriz[i - 1][j];
				} else if (matriz[i - 1][j] < matriz[i][j - blocos[i]] + 1) {
					matriz[i][j] = matriz[i - 1][j];

				} else {
					matriz[i][j] = matriz[i][j - blocos[i]] + 1;
				}
			}
		}
		return matriz[linha - 1][coluna - 1];
	}
}
