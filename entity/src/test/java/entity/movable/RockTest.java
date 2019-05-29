package entity.movable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;
import entity.movable.Rock;

public class RockTest {
	
	Rock rock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.rock = new Rock();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRock() {
		assertEquals(this.rock.getBaseSprite().getIcon(), 'R');
	}

	@Test
	public void testSetX() {
		this.rock.setX(8);
		assertEquals(this.rock.getX(), 8);
		
		try {
			this.rock.setX(-8);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testSetY() {
		this.rock.setY(8);
		assertEquals(this.rock.getY(), 8);
		
		try {
			this.rock.setY(-8);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testIsSubmittedToGravity() {
		assertEquals(this.rock.isSubmittedToGravity(), true);
	}

	@Test
	public void testIsAlive() {
		assertEquals(this.rock.isAlive(), true);
	}

	@Test
	public void testKill() {
		this.rock.kill();
		assertEquals(this.rock.isAlive(), false);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.rock.getBaseSprite().getIcon(), 'R');
	}

	@Test
	public void testGetX() {
		this.rock.setXY(2, 2);
		assertEquals(this.rock.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.rock.setXY(2, 2);
		assertEquals(this.rock.getY(), 2);
	}

	@Test
	public void testSetXY() {
		
		try {
			this.rock.setXY(5, 6);
			this.rock.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.rock = new Rock();
		try {
			this.rock.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.rock = new Rock();
		try {
			this.rock.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.rock.getCapacity(), Capacities.MOVABLE);
	}
	
	@Test
	public void testBecomeMortal() {
		
	}
	
	@Test
	public void testIsMortal() {
		
	}

}
