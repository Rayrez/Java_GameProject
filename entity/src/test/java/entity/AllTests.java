package entity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The class Alltests.
 * Run all tests of the class SpriteTest.
 *
 * @author Pierre GARRIDO
 */
@RunWith(Suite.class)
@SuiteClasses({ entity.SpriteTest.class, entity.breakable.AllTests.class, entity.breakable.AllTests.class, entity.movable.AllTests.class, entity.movable.collectible.AllTests.class, entity.movable.ennemy.AllTests.class, entity.movable.heros.TestHeros.class, entity.penetrable.AllTests.class, entity.unbreakable.AllTests.class})
public class AllTests {
}