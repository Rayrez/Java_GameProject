package entity.unbreakable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

public class BlueWallTest {
	
	BlueWall blueWall;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		blueWall = new BlueWall();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBlueWall() {
		assertEquals(this.blueWall.getBaseSprite().getIcon(), 'B');
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.blueWall.getCapacity(), Capacities.UNBREAKABLE);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.blueWall.getBaseSprite().getIcon(), 'B');
	}

	@Test
	public void testGetX() {
		this.blueWall.setXY(2, 3);
		assertEquals(this.blueWall.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.blueWall.setXY(2, 3);
		assertEquals(this.blueWall.getY(), 3);
	}

	@Test
	public void testSetXY() {
		
		try {
			this.blueWall.setXY(5, 6);
			this.blueWall.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.blueWall = new BlueWall();
		try {
			this.blueWall.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.blueWall = new BlueWall();
		try {
			this.blueWall.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
