package tr.edu.izu.iprocess.matris;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tr.edu.izu.iprocess.matris.io.IOTestSuite;
import tr.edu.izu.iprocess.matris.operation.OperationsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ OperationsTestSuite.class, IOTestSuite.class })
public class AllTestSuite {

}
