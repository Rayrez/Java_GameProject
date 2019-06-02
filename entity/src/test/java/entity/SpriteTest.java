package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The class test for the class sprite
 *
 * @author Pierre GARRIDO
 */

public class SpriteTest {

	/**
	 * Instantiates a new sprite for the test
	 */
	Sprite sprite;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * A method to test.
	 * This method make the correspondence between a symbol in the map, and a sprite.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.sprite = new Sprite('B', "../images/sprites/background.png");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The method be to test to make the correspondence between a symbol in the map, and a sprite.
	 * The test send a message (an exception) if he fail.
	 */
	@Test
	public void testSprite() {
		try
		{
			new Sprite('B', "../images/sprites/background.png");
			
		}
		catch (Exception e)
		{
			fail("The object should be instanciated with the right parameters");
		}
		
		try
		{
			new Sprite('O', "nawak.jpg");
			fail("Giving a wrong file name should generate an exception");
			
		}
		catch (Exception e)
		{
			assertEquals("Fail to open and read the given file", e.getMessage());
		}
	}

	/**
	 * The test to get a sprite.
	 * If the test fail, the method send the message "No image".
	 */
	@Test
	public void testGetImage() {
         if(this.sprite.getImage() == null)
        	 fail("No image");
	}

	@Test
	public void testGetIcon() {
		assertEquals(this.sprite.getIcon(), 'B');
	}

}
