package entity.movable.collectible;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

/**
 * The class DiamondTest.
 *
 * @author Pierre GARRIDO
 */
public class DiamondTest {

	/**
	 * Instantiates a new diamond.
	 */
	Diamond diamond;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new diamond before each test.
	 *
	 * @throws Exception
	 * 				Send an exception if the method don't work.
	 */
	@Before
	public void setUp() throws Exception {
		this.diamond = new Diamond();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the method diamond.
	 */
	@Test
	public void testDiamond() {
		assertEquals(this.diamond.getBaseSprite().getIcon(), 'V');
	}

	/**
	 * Test the method getCapacity.
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(this.diamond.getCapacity(), Capacities.COLLECTIBLE);
	}

	/**
	 * Test the method getName.
	 */
	@Test
	public void testGetName() {
		assertEquals(this.diamond.getName(), "Diamond");
	}

	/**
	 * Test the method setX.
	 */
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

	/**
	 * Test the method setY.
	 */
	@Test
	public void testSetY() {
		this.diamond.setY(8);
		assertEquals(this.diamond.getY(), 8);
		
		try {
			this.diamond.setY(-89);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	/**
	 * Test the method isSubmittedToGravity.
	 */
	@Test
	public void testIsSubmittedToGravity() {
		assertEquals(this.diamond.isSubmittedToGravity(), true);
	}

	/**
	 * Test the method isAlive.
	 */
	@Test
	public void testIsAlive() {
		assertEquals(this.diamond.isAlive(), true);
	}

	/**
	 * Test the method kill.
	 */
	@Test
	public void testKill() {
		this.diamond.kill();
		assertEquals(this.diamond.isAlive(), false);
	}

	/**
	 * Test the method getBaseSprite.
	 */
	@Test
	public void testGetBaseSprite() {
		assertEquals(this.diamond.getBaseSprite().getIcon(), 'V');
	}

	/**
	 * Test the method getX.
	 */
	@Test
	public void testGetX() {
		this.diamond.setXY(2, 2);
		assertEquals(this.diamond.getX(), 2);
	}

	/**
	 * Test the method getY.
	 */
	@Test
	public void testGetY() {
		this.diamond.setXY(2, 2);
		assertEquals(this.diamond.getY(), 2);
	}

	/**
	 * Test the method setXY
	 */
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