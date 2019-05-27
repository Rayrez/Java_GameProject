package entity.unbreakable;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ entity.unbreakable.BlueWallTest.class, entity.unbreakable.ExitTest.class, entity.unbreakable.ExplosionTest.class, entity.unbreakable.GreyWallTest.class})
public class AllTests {
}