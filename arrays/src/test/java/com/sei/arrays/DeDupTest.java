package com.sei.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Mockito based Unit test for DeDup.java.
 */
@RunWith(MockitoJUnitRunner.class)
public class DeDupTest
{
	
	@InjectMocks
	private DeDup classUnderTest;
	
	int[] randomIntegers = {1, 2, 34, 1, 8};
	
	int[] unique = {1, 1000, 34, 8};	
	Integer[] uniqueInteger =  {1, 1000, 34, 8};
	
	@Before
	public void setUp() throws Exception {
		randomIntegers[1] = 1000;
		
	}

	@After
	public void complete(){
		System.out.println("Test Completed !");
	}

	@Test
    public void deDupNaiveTest()
    {
		System.out.println("-----Testing deDupNaive-----");
		Assert.assertArrayEquals(unique, classUnderTest.deDupNaive(randomIntegers));
    }
	
	@Test
    public void deDupHashtableTest()
    {
		System.out.println("-----Testing deDupHashtable-----");
		Assert.assertArrayEquals(unique, classUnderTest.deDupHashtable(randomIntegers));
    }
	
	
	@Test
    public void deDupNaiveSet()
    {
		System.out.println("-----Testing deDupSet-----");
		Assert.assertArrayEquals(uniqueInteger, classUnderTest.deDupSet(randomIntegers));
    }
	
}
