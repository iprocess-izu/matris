package tr.edu.izu.iprocess.matrix.operation;

import java.io.File;

import org.junit.Assert;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matris.io.impl.MatrixIO;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class ClosingTest extends TestCase {

	public void test_dilation_3x3_window() throws Exception{
		MatrixIO io = new MatrixIO();
		IntegerMatrix integerMatrixFromCsv = io.integerMatrixFromCsv(new File("src/test/resources/sample4.csv"));
		Integer [][] windowData = {{1,1,1},{1,1,1},{1,1,1}};

		Closing closing = new Closing(integerMatrixFromCsv, new Window(3, 3, windowData));
		
		IntegerMatrix result = closing.execute();
		
		IntegerMatrix resultExpected = io.integerMatrixFromCsv(new File("src/test/resources/sample4_closed.csv"));

		Assert.assertArrayEquals(resultExpected.getDatas(), result.getDatas());
	}
}
