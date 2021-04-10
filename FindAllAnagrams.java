package amazo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
/*
 * Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".


Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]
 */

public class FindAllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAnagrams("abab", "ab"));

	}

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> results = new ArrayList<>();

		int[] pMap = new int[26];
		int[] sMap = new int[26];
		for (int i = 0; i < p.length(); i++) {
			pMap[p.charAt(i) - 'a']++;
			// sMap[s.charAt(i)-'a']++;

		}
		int length = p.length();
		for (int i = 0; i < s.length(); i++) {
			System.out.println(Arrays.toString(pMap) + "..." + Arrays.toString(sMap));
			sMap[s.charAt(i) - 'a']++; //put count of every char
			if (i >= length) {//only when end pointer crossed more than p.length chars u can do i-length to reduce window size else ul get indxoutofbounds except 

				sMap[s.charAt(i - length) - 'a']--;

			}
			if (i+1 >= length) { //compare when the window has reached p.length chars to reduce overhead, can ommit this condit and check for all, but just for worst case where window matches at end
			if (Arrays.equals(sMap, pMap)) {
				results.add(i - p.length()+1); // doing +1 because it will give -1 index like 1-2 where 1 is end ptr and 2 is length of p
			}
			}

		}

		return results;

	}

}
