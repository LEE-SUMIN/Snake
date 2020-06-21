package test;

import snake.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PropertiesTest {
	private Properties properties;
	
	@Before
	public void setUp() {
		properties = Properties.Instance();
	}
	
	/*
	 * Purpose : Check two different Properties object have same hash code.
	 * Expected : Check will pass true. 
	 */
	@Test
	public void testSameObject() {
		Properties diffProperties = Properties.Instance();
		assertEquals(properties.hashCode(),diffProperties.hashCode());
	}
	
	
	
}
