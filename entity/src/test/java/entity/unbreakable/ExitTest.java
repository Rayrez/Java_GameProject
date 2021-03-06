package entity.unbreakable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;
import entity.penetrable.Exit;

/**
 * The class ExitTest.
 *
 * @author Pierre GARRIDO
 */
public class ExitTest {

	/**
	 * Instantiates a new exit.
	 */
	Exit exit;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new exit before each test.
	 *
	 * @throws Exception
	 * 				Send an exception if the method don't work.
	 */
	@Before
	public void setUp() throws Exception {
		this.exit = new Exit();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test the method exit.
	 */
	@Test
	public void testExit() {
		assertEquals(this.exit.getBaseSprite().getIcon(), 'E');
	}

	/**
	 * Test the method getCapacity.
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(this.exit.getCapacity(), Capacities.UNBREAKABLE);
	}

	/**
	 * Test the method getBaseSprite.
	 */
	@Test
	public void testGetBaseSprite() {
		assertEquals(this.exit.getBaseSprite().getIcon(), 'E');
	}

	/**
	 * Test the method getX.
	 */
	@Test
	public void testGetX() {
		this.exit.setXY(2, 3);
		assertEquals(this.exit.getX(), 2);
	}

	/**
	 * Test the method getY.
	 */
	@Test
	public void testGetY() {
		this.exit.setXY(2, 3);
		assertEquals(this.exit.getY(), 3);
	}

	/**
	 * Test the method setXY.
	 */
	@Test
	public void testSetXY() {
		
		try {
			this.exit.setXY(5, 6);
			this.exit.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.exit = new Exit();
		try {
			this.exit.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.exit = new Exit();
		try {
			this.exit.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}