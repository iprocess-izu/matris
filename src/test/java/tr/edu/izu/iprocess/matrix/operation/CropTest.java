package tr.edu.izu.iprocess.matrix.operation;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Assert;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matris.io.impl.MatrixIO;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;
import tr.edu.izu.iprocess.matrix.operation.MatrixCrop;

public class CropTest extends TestCase {
	
	public void testLoadIntegerMatrixFromImageFileCropAndSave() throws Exception {
		MatrixIO mio = new MatrixIO();
		BufferedImage sourceImage = ImageIO.read(new File("src/test/resources/1.bmp"));
		IntegerMatrix integerMatrixFromBufferedImage = mio.integerMatrixFromBufferedImage(sourceImage);
		Assert.assertEquals(integerMatrixFromBufferedImage.getColumnsCount(), 15);
		
		MatrixCrop a = new MatrixCrop();
		IntegerMatrix extractMatrix = a.extractMatrix(2, 2, 4, 4, integerMatrixFromBufferedImage);
		BufferedImage img = mio.integerMatrixToBufferedImage(extractMatrix);
		ImageIO.write(img, "bmp", new File("target/x.bmp"));

	}
	
}
