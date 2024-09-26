import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(stringIntersect(str1, str2, 3));
		//System.out.println(maxRun(str));
		//System.out.println(blowup(str));
	}

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max_length = 1;
		int curr_length = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == str.charAt(i - 1)){
				curr_length++;
			}else{
				max_length = Math.max(max_length, curr_length);
				curr_length = 1;
			}
		}
		return Math.max(max_length, curr_length);
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c < '0' || c > '9') sb.append(c);
			else {
				if(i + 1 < str.length()){
					int t = c - '0';
					for(int j = 0; j < t; j++){
						sb.append(str.charAt(i + 1));
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i <= a.length() - len; i++){
			hs.add(a.substring(i, i + len));
		}
		for(int i = 0; i <= b.length() - len; i++){
			if(hs.contains(b.substring(i, i + len))) {
				return true;
			}
		}
		return false;
	}
}
