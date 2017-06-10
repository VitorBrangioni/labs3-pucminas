package trabalhos;

import java.io.*;
import java.util.Arrays;

public class Coin {
	public static int coinCollector(int[] coins) {
        int n = 1;
        int currentValue = coins[0];
        for (int i = 1; i < coins.length; i++) {
            if (i < coins.length - 1 && currentValue + coins[i] < coins[i+1]) {
                currentValue += coins[i];
                n++;
            }
            else if (currentValue < coins[i] && i == coins.length - 1)
                n++;
        }
        return n;
    }

    public static void readCoin() throws IOException {
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        String ler = null;
        ler = d.readLine();
        int casos = Integer.parseInt(ler);
        while (casos > 0) {
            ler = d.readLine();
            int nMoedas = Integer.parseInt(ler);
            ler = d.readLine();
            int[] moedas = new int[nMoedas];
            for (int i = 0; i < nMoedas; i++) {
                moedas[i] = Integer.parseInt(ler.split(" ")[i]);
            }
            Arrays.sort(moedas);
            casos--;
            System.out.println("Número máximo de moedas: " + coinCollector(moedas));
        }
        d.close();
    }

    public static void main(String[] args) throws IOException {
        readCoin();
    }
}