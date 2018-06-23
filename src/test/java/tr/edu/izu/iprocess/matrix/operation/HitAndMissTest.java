package tr.edu.izu.iprocess.matrix.operation;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.imageio.ImageIO;

import org.junit.Assert;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matris.io.impl.MatrixIO;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class HitAndMissTest extends TestCase {

	public void test_hitandmiss_3x3_window() throws Exception{
		MatrixIO io = new MatrixIO();
		IntegerMatrix integerMatrixFromCsv = io.integerMatrixFromCsv(new File("src/test/resources/sample5.csv"));
		Integer [][] windowData = {{-1,0,0},{0,1,1},{0,1,1}};

		HitAndMiss hitAndMiss = new HitAndMiss(integerMatrixFromCsv, new Window(3, 3, windowData));
		
		IntegerMatrix result = hitAndMiss.execute();
		
		
		StringBuilder integerMatrixToBufferedImage = io.matrixToStringBuilder(result);
		File file = new File("Q:/tmp/test2.csv");
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(file));
		    writer.append(integerMatrixToBufferedImage);
		} finally {
		    if (writer != null) {
		    	writer.close();
		    }
		}

		
		IntegerMatrix resultExpected = io.integerMatrixFromCsv(new File("src/test/resources/sample5_hitandmiss.csv"));

		Assert.assertArrayEquals(resultExpected.getDatas(), result.getDatas());
	}
}
