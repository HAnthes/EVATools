package testGraph;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestVerbindung.class,
	TestPunktConstructor.class,
	TestPunktSetPos.class,
	TestPunktNachbarschaft.class
})

public class GraphTestSuite {

}
