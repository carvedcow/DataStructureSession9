package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {

		// Task 1
		int[] arr1 = new int[] { 1, 2, 3, 3, 4, 4, 5, 5, 5, 5, 6 };
		for (Object o : findUniqueNumbers(arr1))
			System.out.println(o.toString());

		// Task 2
		System.out.println(containsAllVowels("testaeiggoccu"));
		
		// Task 3
		String str = "cat dog cow cat";
		for (Map.Entry<String, Integer> entry : wordCount(str).entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("Key: " + key + "    Value: " + value);
		}
		
	}

	// Task 1
	// FindUniqueNumbers
	public static Object[] findUniqueNumbers(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		// Arrays.stream(arr).forEach(i -> set.add(i));
		Object[] array = set.toArray();
		return array;
	}

	// Task 2
	// Check if word contains all vowels
	public static boolean containsAllVowels(String s) {
		Set<Character> set = new HashSet<Character>();
		for (char c : s.toCharArray())
			set.add(c);

		ArrayList<Character> vowels = new ArrayList<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		return set.containsAll(vowels);
	}

	// Task 3
	// Count occurences of a word in string
	// use Hashmap
	// "cat dog cow cat"
	// cat: 2
	// dog: 1
	// cow: 1

	public static HashMap<String, Integer> wordCount(String s) {

		String[] words = s.split(" ");
		HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
		
		for (String word : words) {
			wordsCount.computeIfPresent(word, (K, V) -> V+1);

			wordsCount.computeIfAbsent(word, (K) -> 1);
		}
		
		return wordsCount;
	}

}
