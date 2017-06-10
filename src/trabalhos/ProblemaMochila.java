package trabalhos;
import java.util.Arrays;
import java.util.Map;

/**
 * 
 * @author vitor.brangioni
 *
 */
public class ProblemaMochila {

	private int[][] matriz;
	private Map<Integer, Integer> sizeAndValue;
	private int maxSize;

	public ProblemaMochila(int maxSize, Map<Integer, Integer> sizeAndValue) {
		this.sizeAndValue = sizeAndValue;
		this.maxSize = maxSize;
		this.generateTable();
	}
	
	private void generateTable() {
		this.matriz = new int[this.sizeAndValue.size() +1][this.maxSize +1];
		
		// first line
		for (int i = 0; i <= this.maxSize; i++) {
			this.matriz[0][i] = 0;
		}
		
		// first column
		for (int i = 0; i <= this.sizeAndValue.size(); i++) {
			this.matriz[i][0] = 0;
		}
		
		// percorrendo as linhas
		for (int i = 1; i <= this.sizeAndValue.size(); i++) {
			Object[] keys = this.sizeAndValue.keySet().toArray();
			Object[] values = this.sizeAndValue.values().toArray();
			
			int size = (int) keys[i -1];
			int value = (int) values[i -1];
			
			// percorrendo as colunas
			for (int j = 1; j <= this.maxSize; j++) {
				if (j >= size) {
					int column = j - size;
					int result = value + this.matriz[i -1][column];
					
					this.matriz[i][j] = result;
				} else {
					this.matriz[i][j] = this.matriz[i -1][j];
				}
			}
		} 
	}
	
	public int maxNumObjectsCollected() {
		return this.matriz[this.sizeAndValue.size()][this.maxSize];
	}
	
	public void printMatriz() {
		System.out.println(Arrays.deepToString(this.matriz));
	}
}
