package entity.unbreakable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

/**
 * The class Explosion.
 *
 * @author Pierre GARRIDO
 */
public class ExplosionTest {

	/**
	 * Instantiates a new explosion.
	 */
	Explosion explosion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new explosion before each test.
	 *
	 * @throws Exception
	 * 				Send an exception if the method don't work.
	 */
	@Before
	public void setUp() throws Exception {
		this.explosion = new Explosion();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the method explosion.
	 */
	@Test
	public void testExplosion() {
		assertEquals(this.explosion.getBaseSprite().getIcon(), 'Y');
	}

	/**
	 * Test the method getCapacity.
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(this.explosion.getCapacity(), Capacities.UNBREAKABLE);
	}

	/**
	 * Test the method getBaseSprite.
	 */
	@Test
	public void testGetBaseSprite() {
		assertEquals(this.explosion.getBaseSprite().getIcon(), 'Y');
	}

	/**
	 * Test the method getX.
	 */
	@Test
	public void testGetX() {
		this.explosion.setXY(2, 3);
		assertEquals(this.explosion.getX(), 2);
	}

	/**
	 * Test the method getY.
	 */
	@Test
	public void testGetY() {
		this.explosion.setXY(2, 3);
		assertEquals(this.explosion.getY(), 3);
	}

	/**
	 * Test the method setXY.
	 */
	@Test
	public void testSetXY() {
		
		try {
			this.explosion.setXY(5, 6);
			this.explosion.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.explosion = new Explosion();
		try {
			this.explosion.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.explosion = new Explosion();
		try {
			this.explosion.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
