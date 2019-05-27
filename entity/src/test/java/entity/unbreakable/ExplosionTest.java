package entity.unbreakable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Capacities;

public class ExplosionTest {
	
	Explosion explosion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.explosion = new Explosion();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExplosion() {
		assertEquals(this.explosion.getBaseSprite().getIcon(), 'Y');
	}

	@Test
	public void testGetCapacity() {
		assertEquals(this.explosion.getCapacity(), Capacities.UNBREAKABLE);
	}

	@Test
	public void testGetBaseSprite() {
		assertEquals(this.explosion.getBaseSprite().getIcon(), 'Y');
	}

	@Test
	public void testGetX() {
		this.explosion.setXY(2, 3);
		assertEquals(this.explosion.getX(), 2);
	}

	@Test
	public void testGetY() {
		this.explosion.setXY(2, 3);
		assertEquals(this.explosion.getY(), 3);
	}

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
