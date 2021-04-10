package amazo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubstringSizeK {

	/*
	 * Substrings of size K with K distinct chars Given a string s and an int k,
	 * return all unique substrings of s of size k with k distinct characters.
	 * Example 1:
	 * 
	 * Input: s = "abcabc", k = 3 Output: ["abc", "bca", "cab"]
	 * 
	 * Example 2:
	 * 
	 * Input: s = "abacab", k = 3 Output: ["bac", "cab"]
	 * 
	 * Example 3:
	 * 
	 * Input: s = "awaglknagawunagwkwagl", k = 4 Output: ["wagl", "aglk", "glkn",
	 * "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
	 * Explanation: Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag",
	 * "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" "wagl" is
	 * repeated twice, but is included in the output once.
	 * 
	 * Constraints:
	 * 
	 * The input string consists of only lowercase English letters [a-z]
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("checking i++");
		String s = "prathima";
		for(int i =0,j=0 ;i<s.length();i++ ) {
			System.out.println(s.charAt(i) + "  j is - "+ s.charAt(j++));
			
		}
		kSubstring("awaglknagawunagwkwagl", 4);

	}

	private static List<String> kSubstring(String string, int k) {
		// TODO Auto-generated method stub

		int[] map = new int[26];

		System.out.println("current values  - " + Arrays.toString(map));

		Set<String> results = new LinkedHashSet<>();
		

		/*while (end < string.length() && start<=end) {

			while((map[string.charAt(end) - 'a'] == 1 )) {
				{
				//map[string.charAt(start) - 'a'] = 0;
				start++;
				;
				}
				
			}
			map[string.charAt(end) - 'a'] = 1;
			

			if (end - start + 1 == k) {
				results.add(string.substring(start, end + 1));
				map[string.charAt(start) - 'a'] = 0;
				start++;
			}
			end++;

		}*/
		Set<Character> window = new HashSet<>();
		for(int i=0,j=0;j<string.length();j++) {
			while(window.contains(string.charAt(j))) {
			
				window.remove(string.charAt(i));
				i++;
			}
			window.add(string.charAt(j));
			if(window.size()==k) {
				results.add(string.substring(i, j + 1));
				System.out.println(window);
				//System.out.println("removing char at " + i++);
				window.remove(string.charAt(i));
				i++;
			}
			
		}
		
		
		System.out.println(results);
		return new ArrayList<String>(results);
	}

}
