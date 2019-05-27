package entity.penetrable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

public class BackgroundTest {
	
	Background background;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.background = new Background();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBackground() {
		assertEquals(background.getBaseSprite().getIcon(), 'X');
	}

	@Test
	public void testGetCapacity() {
		assertEquals(background.getCapacity(), Capacities.PENETRABLE);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(background.getBaseSprite().getIcon(), 'X');
	}

	@Test
	public void testGetX() {
		this.background.setXY(2, 3);
		assertEquals(this.background.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.background.setXY(2, 3);
		assertEquals(this.background.getY(), 3);
	}

	@Test
	public void testSetXY() {
		
		try {
			this.background.setXY(5, 6);
			this.background.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.background = new Background();
		try {
			this.background.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.background = new Background();
		try {
			this.background.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
