package com.company.example;

import org.junit.Assert;
import org.junit.Test;

public class FeatureTest {

	@Test
	public void isGoodAnswer() {
		Assert.assertEquals(42, Feature.getAnswer());
	}

}
