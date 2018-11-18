package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
/**
 * 
 * @author Harsh Maheshwari
 *
 */
public class StringAlgorithms {

	// Given a big string of characters, how to efficiently find the first
	// unique character in it?
	public static char getFirstNonUniqueChar(String text) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i))) {
				map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
			} else {
				map.put(text.charAt(i), 1);
			}

		}
		Optional<Entry<Character, Integer>> entry = map.entrySet().stream().filter(item -> item.getValue() == 1)
				.findFirst();
		if (entry.isPresent()) {
			return entry.get().getKey();
		}
		return ' ';
	}

	private static char[] getCharCountArray(String str) {
		char[] count = new char[256];
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
		return count;

	}

	// Given a big string of characters, how to efficiently find the first
	// unique character in it?
	public static int getFirstUniqueChar(String text) {
		char[] count = getCharCountArray(text);
		int index = -1;
		for (int i = 0; i < text.length(); i++) {
			if (count[text.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String args[]) {
		String text = "AA";
		int i = getFirstUniqueChar(text);
		if (i >= 0) {
			System.out.printf("\n firstUniquesChar = %s , at index = %s", text.charAt(i), i);
		} else {
			System.out.printf("\n Unique char not found");
		}
	}

}
