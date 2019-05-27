package entity.breakable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

public class DirtTest {
	
	Dirt dirt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.dirt = new Dirt();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDirt() {
		assertEquals(this.dirt.getBaseSprite().getIcon(), 'D');
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.dirt.getCapacity(), Capacities.BREAKABLE);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.dirt.getBaseSprite().getIcon(), 'D');
	}

	@Test
	public void testGetX() {
		this.dirt.setXY(2, 2);
		assertEquals(this.dirt.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.dirt.setXY(2, 2);
		assertEquals(this.dirt.getY(), 2);
	}

	@Test
	public void testSetXY() {
		try {
			this.dirt.setXY(5, 6);
			this.dirt.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.dirt = new Dirt();
		try {
			this.dirt.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.dirt = new Dirt();
		try {
			this.dirt.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
