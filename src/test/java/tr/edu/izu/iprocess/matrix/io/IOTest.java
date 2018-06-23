package tr.edu.izu.iprocess.matrix.io;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.imageio.ImageIO;

import org.junit.Assert;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matris.io.impl.MatrixIO;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class IOTest extends TestCase {

	private IntegerMatrix matris = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		matris = new IntegerMatrix(3, 3);
	}

	public void testNothing() {
		assertEquals(matris.getColumnsCount(), 3);
	}
	
	public void testLoadIntegerMatrixFromImageFile() throws Exception {
		MatrixIO mio = new MatrixIO();
		BufferedImage sourceImage = ImageIO.read(new File("src/test/resources/1.bmp"));
		IntegerMatrix integerMatrixFromBufferedImage = mio.integerMatrixFromBufferedImage(sourceImage);
		Assert.assertEquals(integerMatrixFromBufferedImage.getColumnsCount(), 15);
	}
	
	public void testSaveIntegerMatrixAsBmpFile() throws Exception {
		MatrixIO mio = new MatrixIO();
		IntegerMatrix matrix = new IntegerMatrix(2, 3);
		Integer[][] datas = {{-1,-1,-1},{-16777216,-16777216,-16777216}};
		matrix.setDatas(datas);
		BufferedImage image = mio.integerMatrixToBufferedImage(matrix);
		
		ImageIO.write(image, "bmp", new File("target/2.bmp"));
		
		BufferedImage imageRead = ImageIO.read(new File("target/2.bmp"));
		Assert.assertEquals(imageRead.getRGB(1, 1), matrix.getValue(1, 1).intValue());
	}
	
	public void testSaveIntegerMatrixAsCsvFileAndLoad() throws Exception {
		MatrixIO mio = new MatrixIO();
		IntegerMatrix matrix = new IntegerMatrix(2, 3);
		Integer[][] datas = {{-1,-1,-1},{0,0,0}};
		matrix.setDatas(datas);
		StringBuilder strBuilder = mio.matrixToStringBuilder(matrix);
		
		File file = new File("target/1.csv");
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(file));
		    writer.append(strBuilder);
		} finally {
		    if (writer != null) {
		    	writer.close();
		    }
		}
		
		//LOAD TEST
		
		IntegerMatrix integerMatrixFromCsv = mio.integerMatrixFromCsv(file);
		Assert.assertArrayEquals(datas, integerMatrixFromCsv.getDatas());
	}


}
