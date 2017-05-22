package trabalhos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author vitorbrangioni
 *
 */
public class SacoPapaiNoel {
	
	public static void problemaNatal(int[] pesos, int[] qtdPresente, int pesoMax) {
		int[][] matriz = new int[qtdPresente.length + 1][pesoMax + 2];

		for (int i = 1; i <= qtdPresente.length; i++) {
			matriz[i][0] = pesos[i - 1];
			matriz[i][1] = 0;
		}

		matriz[0][0] = 0;
		for (int i = 1; i < pesoMax +2; i++) {
			matriz[0][i] = i - 1;
		}

		for (int j = 1; j < pesoMax +2; j++) {
			if (matriz[1][0] < j - 1)
				matriz[1][j] = qtdPresente[0];
			else
				matriz[1][j] = 0;
		}

		for (int i = 2; i <= qtdPresente.length; i++) {
			for (int j = 2; j < pesoMax + 2; j++) {
				int pesoItem = matriz[i][0];
				int valorItem = qtdPresente[i - 1];
				int capacidadeAtual = matriz[0][j];

				if (capacidadeAtual >= pesoItem) {
					int valorTotal = valorItem + matriz[i - 1][j - pesoItem];
					matriz[i][j] = Math.max(valorTotal, matriz[i - 1][j]);
				} else {
					matriz[i][j] = matriz[i - 1][j];
				}
			}
		}
		int qtdPacotes = 0;
		int l = qtdPresente.length;
		int totalBrinq = matriz[qtdPresente.length][pesoMax + 1];
		int totalPeso = 0;
		boolean encontrou = false;
		int aux = totalBrinq;

		for (int c = pesoMax + 1; c > 0; c--) {
			int valorAtual = matriz[l][c];
			int valorAnterior = matriz[l][c - 1];

			if (totalBrinq != valorAnterior && !encontrou) {
				totalPeso = matriz[0][c];
				encontrou = true;
			}

			if (valorAnterior != valorAtual && encontrou) {
				int temp = c;

				while (aux - qtdPresente[l - 1] != matriz[l - 1][c]) {
					c--;
					if (c < 0) {
						l--;
						c = temp;
					}
				}

				qtdPacotes++;
				aux -= qtdPresente[l - 1];
				l--;
			}
			if (aux == 0)
				break;
		}
		int restantePacotes = qtdPresente.length - qtdPacotes;
		printResultado(totalBrinq, totalPeso, restantePacotes);
	}


	public void read() throws IOException {
		BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
		String ler = null;
		ler = d.readLine();

		int repeticoes = Integer.parseInt(ler);

		while (repeticoes > 0) {
			ler = d.readLine();
			int qtdPacotes = Integer.parseInt(ler);

			int[] qtdPresente = new int[Integer.parseInt(ler)];
			int[] pesos = new int[Integer.parseInt(ler)];

			for (int i = 0; i < qtdPacotes; i++) {
				ler = d.readLine();

				qtdPresente[i] = Integer.parseInt(ler.split(" ")[0]);
				pesos[i] = Integer.parseInt(ler.split(" ")[1]);
			}
			problemaNatal(pesos, qtdPresente, 50);

			repeticoes--;
		}
		d.close();
	}

	private static void printResultado(int totalBrinq, int totalPeso, int restantePacotes) {
		System.out.println(totalBrinq + " brinquedos");
		System.out.println("Peso: " + totalPeso + " kg");
		System.out.println("Sobra(m) " + restantePacotes + " pacote(s)");
		
	}

	public static void main(String[] args) throws IOException {
		SacoPapaiNoel sacoNoel = new SacoPapaiNoel();
		sacoNoel.read();
	}
}
