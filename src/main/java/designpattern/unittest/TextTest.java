package designpattern.unittest;

import org.junit.Assert;
import org.junit.Test;

public class TextTest {
	@Test
	public void testToNumber() {
		Text text = new Text("123");
		Assert.assertEquals(new Integer(123), text.toNumber());
	}

	@Test
	public void testToNumber_nullOrEmpty() {
		Text text1 = new Text(null);
		Assert.assertNull(text1.toNumber());

		Text text2 = new Text(null);
		Assert.assertNull(text2.toNumber());
	}
}
