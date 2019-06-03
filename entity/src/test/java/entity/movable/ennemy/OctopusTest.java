package entity.movable.ennemy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;
import entity.movable.heros.Heros;

/**
 * The class OctopusTest.
 *
 * @author Pierre GARRIDO
 */
public class OctopusTest {

	/**
	 * Instantiates a new octopus.
	 */
	Octopus octopus;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new octopus before each test.
	 *
	 * @throws Exception
	 * 				Send an exception if the method don't work.
	 */
	@Before
	public void setUp() throws Exception {
		this.octopus = new Octopus();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the method killsb.
	 */
	@Test
	public void testKillSb() {
		Heros heros = new Heros();
		octopus.killSb(heros);
		assertEquals(heros.isAlive(), false);
	}

	/**
	 * Test the method getCapacity.
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(this.octopus.getCapacity(), Capacities.MOVABLE);
	}

	/**
	 * Test the method setX.
	 */
	@Test
	public void testSetX() {
		this.octopus.setX(8);
		assertEquals(this.octopus.getX(), 8);
		
		try {
			this.octopus.setX(-8);
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
		this.octopus.setY(6);
		assertEquals(this.octopus.getY(), 6);
		
		try {
			this.octopus.setY(-8);
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
		assertEquals(this.octopus.isSubmittedToGravity(), false);
	}

	/**
	 * Test the method isAlive.
	 */
	@Test
	public void testIsAlive() {
		assertEquals(this.octopus.isAlive(), true);
	}

	/**
	 * Test the method kill.
	 */
	@Test
	public void testKill() {
		this.octopus.kill();
		assertEquals(this.octopus.isAlive(), false);
	}

	/**
	 * Test the method getBaseSprite.
	 */
	@Test
	public void testGetBaseSprite() {
		assertEquals(this.octopus.getBaseSprite().getIcon(), 'K');
	}

	/**
	 * Test the method getX.
	 */
	@Test
	public void testGetX() {
		this.octopus.setXY(2, 2);
		assertEquals(this.octopus.getX(), 2);
	}

	/**
	 * Test the method getY.
	 */
	@Test
	public void testGetY() {
		this.octopus.setXY(2, 2);
		assertEquals(this.octopus.getY(), 2);
	}

	/**
	 * Test the method setXY.
	 */
	@Test
	public void testSetXY() {
		
		try {
			this.octopus.setXY(5, 6);
			this.octopus.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.octopus = new Octopus();
		try {
			this.octopus.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.octopus = new Octopus();
		try {
			this.octopus.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
