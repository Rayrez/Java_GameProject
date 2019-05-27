package entity.movable.collectible;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

public class DiamondTest {
	
	Diamond diamond;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.diamond = new Diamond();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiamond() {
		assertEquals(this.diamond.getBaseSprite().getIcon(), 'V');
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.diamond.getCapacity(), Capacities.COLLECTIBLE);
	}

	@Test
	public void testGetName() {
		assertEquals(this.diamond.getName(), "Diamond");
	}

	@Test
	public void testSetX() {
		this.diamond.setX(8);
		assertEquals(this.diamond.getX(), 8);
		
		try {
			this.diamond.setX(-8);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testSetY() {
		this.diamond.setY(2);
		assertEquals(this.diamond.getX(), 8);
		
		try {
			this.diamond.setY(-89);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testIsSubmittedToGravity() {
		assertEquals(this.diamond.isSubmittedToGravity(), true);
	}

	@Test
	public void testIsAlive() {
		assertEquals(this.diamond.isAlive(), true);
	}

	@Test
	public void testKill() {
		this.diamond.kill();
		assertEquals(this.diamond.isAlive(), false);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.diamond.getBaseSprite().getIcon(), 'V');
	}

	@Test
	public void testGetX() {
		this.diamond.setXY(2, 2);
		assertEquals(this.diamond.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.diamond.setXY(2, 2);
		assertEquals(this.diamond.getY(), 2);
	}

	@Test
	public void testSetXY() {
		
		try {
			this.diamond.setXY(5, 6);
			this.diamond.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.diamond = new Diamond();
		try {
			this.diamond.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.diamond = new Diamond();
		try {
			this.diamond.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}