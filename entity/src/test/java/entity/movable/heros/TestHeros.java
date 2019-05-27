package entity.movable.heros;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;
import entity.Direction;

public class TestHeros {
	
	Heros heros;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.heros = new Heros();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHeros() {
		assertEquals(this.heros.getBaseSprite().getIcon(), 'H');
	}

	@Test
	public void testGetDir() {
		assertEquals(this.heros.getDir(), Direction.FACE);
	}

	@Test
	public void testSetDir() {
		this.heros.setDir(Direction.LEFT);
		assertEquals(this.heros.getDir(), Direction.LEFT);
		
		try
		{
			this.heros.setDir(null);
			fail("Sending a wrong parameters should generate an exception");
		}
		catch(Exception e)
		{
			assertEquals(e.getMessage(), "Invalid direction");
		}
	}

	@Test
	public void testGetUsedSprite() {
		assertEquals(this.heros.getUsedSprite(), this.heros.getBaseSprite());
	}

	@Test
	public void testSetUsedSprite() {
		this.heros.setDir(Direction.LEFT);
		this.heros.setDir(Direction.FACE);
		assertEquals(this.heros.getUsedSprite(), this.heros.getBaseSprite());
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.heros.getCapacity(), Capacities.MOVABLE);
	}

	@Test
	public void testSetX() {
		this.heros.setX(8);
		assertEquals(this.heros.getX(), 8);
		
		try {
			this.heros.setX(-8);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testSetY() {
		this.heros.setY(5);
		assertEquals(this.heros.getY(), 5);
		
		try {
			this.heros.setY(-998);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

	@Test
	public void testIsSubmittedToGravity() {
		assertEquals(this.heros.isSubmittedToGravity(), false);
	}

	@Test
	public void testIsAlive() {
		assertEquals(this.heros.isAlive(), true);
	}

	@Test
	public void testKill() {
		this.heros.kill();
		assertEquals(this.heros.isAlive(), false);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.heros.getBaseSprite().getIcon(), 'H');
	}

	@Test
	public void testGetX() {
		this.heros.setXY(2, 2);
		assertEquals(this.heros.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.heros.setXY(2, 2);
		assertEquals(this.heros.getY(), 2);
	}

	@Test
	public void testSetXY() {
		
		try {
			this.heros.setXY(5, 6);
			this.heros.setXY(7, 1);
			fail("A multiple use of setXY should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "This entity is already set !");
		}
		
		this.heros = new Heros();
		try {
			this.heros.setXY(-2, 6);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
		
		this.heros = new Heros();
		try {
			this.heros.setXY(12, -58);
			fail("Setting a negative value should generate an exception");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "X and Y should be greather than 0");
		}
	}

}
