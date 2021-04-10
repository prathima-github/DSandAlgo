package amazo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 * 
 * Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.


Input:
k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]

Output:
["betacellular", "anacell"]

Explanation:
"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 */
public class TopK {

	public static void main(String[] args) {
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = { "Anacell, provides the! best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		int k2 = 2;
		String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		System.out.println(solve(k1, keywords1, reviews1));
		System.out.println(solve(k2, keywords2, reviews2));
	}

	private static List<String> solve(int k1, String[] keywords, String[] reviews) {
		// TODO Auto-generated method stub
		Set<String> keySet = new HashSet<String>();
		for (String word : keywords) {
			keySet.add(word);
		}
		Map<String, Integer> wordsMap = new HashMap<>();
		for (String sentence : reviews) {
			System.out.println("Sentence is - "+ sentence);
			sentence = sentence.replaceAll("[^a-zA-z0-9]", " ").toLowerCase();
			String[] words = sentence.split("\\s+");
			//System.out.println(Arrays.toString(words));
			Set<String> sentenceSet = new HashSet<>();
			for (String word : words) {
				if (keySet.contains(word) && !sentenceSet.contains(word)) {
					wordsMap.put(word, wordsMap.getOrDefault(word,0)+1);
					sentenceSet.add(word);
					//System.out.println("Adding word "+ word);
				}
			}
		}
		
		List<String> result = new ArrayList<String>();
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((w1,w2)->
		w1.getValue()==w2.getValue() ? w1.getKey().compareTo(w2.getKey()) :w2.getValue()-w1.getValue());
		pq.addAll(wordsMap.entrySet());
		while(!pq.isEmpty() && k1-->0)
		{
			
				result.add(pq.poll().getKey());
				
		}
		
		
		
		

		return result;
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> wordsMap = new HashMap<>();
		for (String word : words) {
			wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);

		}
		PriorityQueue<String> pq = new PriorityQueue<>(
				(w1, w2) -> wordsMap.get(w1).equals(wordsMap.get(w2)) ? w2.compareTo(w1)
						: wordsMap.get(w1) - wordsMap.get(w2));
		for (String word : wordsMap.keySet()) {
			pq.offer(word);
			if (pq.size() > k)
				pq.poll();

		}

		System.out.println(wordsMap);
		List<String> topK = new ArrayList<>();
		while (!pq.isEmpty())
			topK.add(pq.poll());
		Collections.reverse(topK);
		return topK;
	}
}