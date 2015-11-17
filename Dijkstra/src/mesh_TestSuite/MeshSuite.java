package mesh_TestSuite;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	VerbindungTestSimple.class,
	Punkt_TestConstruktor.class,
	Punkt_TestSetPosition.class,
	Punkt_TestNachbarschaft.class
})

public class MeshSuite {

}
