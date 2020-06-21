package test;

import snake.*;
import static org.junit.Assert.*;

import java.awt.Color;

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
	
	/*
	 * Purpose : Check whether Properties's theme can be changed from Dark to Rainbow theme
	 *  after calling Rainbow().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testCheckTheme_1() {
		assertEquals(properties.getTheme(),Theme.Dark);
		properties.Rainbow();
		assertEquals(properties.getTheme(),Theme.Rainbow);
	}
	
	/*
	 * Purpose : Check whether Properties's theme can be changed from Rainbow to Dark theme
	 *  after calling Dark().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testCheckTheme_2() {
		properties.Rainbow();
		assertEquals(properties.getTheme(),Theme.Rainbow);
		properties.Dark();
		assertEquals(properties.getTheme(),Theme.Dark);
	}
	
	/*
	 * Purpose : Check whether Properties's theme can be changed from Dark to Sky theme
	 *  after calling Sky().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testCheckTheme_3() {
		properties.Dark();
		assertEquals(properties.getTheme(),Theme.Dark);
		properties.Sky();
		assertEquals(properties.getTheme(),Theme.Sky);
	}
	
	/*
	 * Purpose : Check whether Properties's theme can be changed from Sky to Mud theme
	 *  after calling Mud().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testCheckTheme_4() {
		properties.Sky();
		assertEquals(properties.getTheme(),Theme.Sky);
		properties.Mud();
		assertEquals(properties.getTheme(),Theme.Mud);
	}
	
	/*
	 * Purpose : Check whether Properties's theme can be changed from Mud to Sand theme
	 *  after calling Sand().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testCheckTheme_5() {
		properties.Mud();
		assertEquals(properties.getTheme(),Theme.Mud);
		properties.Sand();
		assertEquals(properties.getTheme(),Theme.Sand);
	}
	
	/*
	 * Purpose : Check whether Properties's theme can be changed from Sand to Rainbow theme
	 *  after calling Rainbow().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testCheckTheme_6() {
		properties.Sand();
		assertEquals(properties.getTheme(),Theme.Sand);
		properties.Rainbow();
		assertEquals(properties.getTheme(),Theme.Rainbow);
	}
	
	/*
	 * Purpose : Check whether when background color is (36~41, 165~96, 107~202), it can be changed to (42,97,203) by (1,-1,1) 
	 * 	after calling changeBackGroundColor().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testChangeBackGroundColor_1() {
		while(true) {
			if(properties.getBackgroundColor().equals(new Color(40,161,111))) {
				properties.changeBackGroundColor();
				assertEquals(properties.getBackgroundColor(),new Color(41,160,112));
				break;
			}
			properties.changeBackGroundColor();
		}
	}
	
	/*
	 * Purpose : Check whether when background color is (42~149, 97~63, 203~237), it can be changed to (150,62,238) by (1,-1,1) 
	 * 	after calling changeBackGroundColor().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testChangeBackGroundColor_2() {
		while(true) {
			if(properties.getBackgroundColor().equals(new Color(72,67,233))) {
				properties.changeBackGroundColor();
				assertEquals(properties.getBackgroundColor(),new Color(73,66,234));
				break;
			}
			properties.changeBackGroundColor();
		}
	}
	
	/*
	 * Purpose : Check whether when background color is (150~229, 62~62, 238~62), it can be changed to (230,61,61) by (1,-1,-1) 
	 * 	after calling changeBackGroundColor().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testChangeBackGroundColor_3() {
		while(true) {
			if(properties.getBackgroundColor().equals(new Color(152,61,236))) {
				properties.changeBackGroundColor();
				assertEquals(properties.getBackgroundColor(),new Color(153,61,235));
				break;
			}
			properties.changeBackGroundColor();
		}
	}
	
	/*
	 * Purpose : Check whether when background color is (230~224, 61~149, 61~76), it can be changed to (223,150,77) by (-1,1,1) 
	 * 	after calling changeBackGroundColor().
	 * Expected : Check will pass true.
	 */
	@Test
	public void testChangeBackGroundColor_4() {
		while(true) {
			if(properties.getBackgroundColor().equals(new Color(223,68,68))) {
				properties.changeBackGroundColor();
				assertEquals(properties.getBackgroundColor(),new Color(223,69,69));
				break;
			}
			properties.changeBackGroundColor();
		}
	}
}
