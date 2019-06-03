package entity.unbreakable;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The class Alltests.
 * Run all tests of the classes in the package Entity.unbreakable.
 *
 * @author Pierre GARRIDO
 */
@RunWith(Suite.class)
@SuiteClasses({ entity.unbreakable.BlueWallTest.class, entity.unbreakable.ExitTest.class, entity.unbreakable.ExplosionTest.class, entity.unbreakable.GreyWallTest.class})
public class AllTests {
}