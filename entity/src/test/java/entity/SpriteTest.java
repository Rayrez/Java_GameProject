package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {
	
	Sprite sprite;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sprite = new Sprite('B', "../images/sprites/background.png");
	}

	@After
	public void tearDown() throws Exception {
	}

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
