package algorithm;

import java.util.Arrays;

public class AbstractUtils {

	public static int itrCount = 0;

	public static void printArray(final int[] a, String... args) {
		Arrays.stream(args).forEach(System.out::print);
		Arrays.stream(a).forEach(item -> System.out.print(item + ", "));
		System.out.println();
	}

	public static void printArray(final char[] a, String... args) {
		Arrays.stream(args).forEach(System.out::print);
		Arrays.asList(a).forEach(System.out::print);
		System.out.println();
	}
}
