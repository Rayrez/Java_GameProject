package entity.movable.ennemy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;
import entity.movable.heros.Heros;

public class OctopusTest {
	
	Octopus octopus;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.octopus = new Octopus();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKillSb() {
		Heros heros = new Heros();
		octopus.killSb(heros);
		assertEquals(heros.isAlive(), false);
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.octopus.getCapacity(), Capacities.MOVABLE);
	}

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

	@Test
	public void testIsSubmittedToGravity() {
		assertEquals(this.octopus.isSubmittedToGravity(), false);
	}

	@Test
	public void testIsAlive() {
		assertEquals(this.octopus.isAlive(), true);
	}

	@Test
	public void testKill() {
		this.octopus.kill();
		assertEquals(this.octopus.isAlive(), false);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.octopus.getBaseSprite().getIcon(), 'K');
	}

	@Test
	public void testGetX() {
		this.octopus.setXY(2, 2);
		assertEquals(this.octopus.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.octopus.setXY(2, 2);
		assertEquals(this.octopus.getY(), 2);
	}

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
