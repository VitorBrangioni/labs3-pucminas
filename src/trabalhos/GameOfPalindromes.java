package trabalhos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author vitorh.brangioni
 *
 */
public class GameOfPalindromes {
	
	public static boolean anagramPalindrome(String prefix, String word) {
		boolean isPalindrome = false;
		if (word.length() <= 1) {
			if (isPalindrome(prefix + word))
				return true;
		} else {
			for (int i = 0; i < word.length(); i++) {
				String before = word.substring(0, i);
				String after = word.substring(i + 1);
				String cur = word.substring(i, i + 1);
				
				if (!isPalindrome) {
					isPalindrome = anagramPalindrome(prefix + cur, before + after);
				}
			}
		}
		return isPalindrome;
	}
	
	private static int countLetterPalindromo(String word) {
		if (isPalindrome(word) || anagramPalindrome("", word)) {
			return 0;
		}
		String palindrome = "";
		int countLetter = 0;
		
		for (int i = 1; i < word.length(); i++) {
			palindrome = word.substring(i);
			if (isPalindrome(palindrome)) {
				return countLetter + i;
			}
		}
		return countLetter;
	}
	
    public static boolean isPalindrome(String word) {
        String temp = "";
        
        for (int i = word.length() - 1; i >= 0; i--) {
            temp += word.charAt(i);
        }
        return temp.equals(word);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
        String read = bfReader.readLine();
        while (read != null && !read.equals("")) {
            System.out.println(countLetterPalindromo(read));
            read = bfReader.readLine();
        }
        bfReader.close();
    }

}
