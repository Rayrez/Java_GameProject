package entity.unbreakable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

public class GreyWallTest {
	
	GreyWall greyWall;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGreyWall() {
		assertEquals(this.greyWall.getBaseSprite().getIcon(), 'G');
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.greyWall.getCapacity(), Capacities.UNBREAKABLE);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.greyWall.getBaseSprite().getIcon(), 'G');
	}

	@Test
	public void testGetX() {
		this.greyWall.setXY(2, 3);
		assertEquals(this.greyWall.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.greyWall.setXY(2, 3);
		assertEquals(this.greyWall.getY(), 3);
	}

	@Test
	public void testSetXY() {
		
		try {
			this.greyWall.setXY(5, 6);
			this.greyWall.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.greyWall = new GreyWall();
		try {
			this.greyWall.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.greyWall = new GreyWall();
		try {
			this.greyWall.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
