package tr.edu.izu.iprocess.matrix.operation;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matris.io.impl.MatrixIO;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class ErosionTest extends TestCase {

	public void test_erosion_3x3_window() throws Exception{
		MatrixIO io = new MatrixIO();
		IntegerMatrix integerMatrixFromCsv = io.integerMatrixFromCsv(new File("src/test/resources/sample.csv"));
		Integer [][] windowData = {{1,1,1},{1,1,1},{1,1,1}};

		Erosion erosion = new Erosion(integerMatrixFromCsv, new Window(3, 3, windowData));
		
		IntegerMatrix result = erosion.execute();
		
		IntegerMatrix resultExpected = io.integerMatrixFromCsv(new File("src/test/resources/sample_eroded.csv"));

		Assert.assertArrayEquals(resultExpected.getDatas(), result.getDatas());
	}
}
