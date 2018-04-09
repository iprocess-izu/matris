package tr.edu.izu.iprocess.matrix;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tr.edu.izu.iprocess.matrix.io.IOTestSuite;
import tr.edu.izu.iprocess.matrix.operation.OperationsTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ OperationsTestSuite.class, IOTestSuite.class })
public class AllTestSuite {

}
