package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class StringAlogrithmsTest {

	@Test
	public void getFirstNonUniqueCharTest() {
		String text = "HeHllow World!!";
		int i = StringAlgorithms.getFirstUniqueChar(text);
		Assert.assertSame('e', text.charAt(i));

	}

	@Test
	public void getFirstNonUniqueCharUsingMapTest() {
		String text = "HeHllow World!!";
		char c = StringAlgorithms.getFirstNonUniqueChar(text);
		Assert.assertSame('e', c);

	}
}
