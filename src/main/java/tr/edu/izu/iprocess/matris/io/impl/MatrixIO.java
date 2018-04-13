package tr.edu.izu.iprocess.matris.io.impl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tr.edu.izu.iprocess.matrix.AbstractMatrix;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class MatrixIO {
	
	public IntegerMatrix integerMatrixFromBufferedImage(BufferedImage sourceImage) {
		int width = sourceImage.getWidth();
		int height = sourceImage.getHeight();
		IntegerMatrix integerMatris = new IntegerMatrix(height, width);
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Integer value = sourceImage.getRGB(j, i);
				integerMatris.setValue(i, j, value);
			}
		}
		return integerMatris;
	}
	
	public BufferedImage integerMatrixToBufferedImage(IntegerMatrix matrix) {
		BufferedImage image = new BufferedImage(matrix.getColumnsCount(), matrix.getRowsCount(), BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < matrix.getRowsCount(); i++) {
			for (int j = 0; j < matrix.getColumnsCount(); j++) {
				Integer value = matrix.getValue(i, j);
				image.setRGB(j, i, value);
			}
		}
		
		return image;
	}

	
	public StringBuilder matrixToStringBuilder(AbstractMatrix<?> matrix) {
		StringBuilder sb = new StringBuilder();
		String comma = ",";
		String newline = "\r\n";
		
		for (int i = 0; i < matrix.getRowsCount(); i++) {
			for (int j = 0; j < matrix.getColumnsCount(); j++) {
				Number value = matrix.getValue(i, j);
				sb.append(value);
				if(j+1 != matrix.getColumnsCount()) {
					sb.append(comma);
				}
			}
			if(i+1 != matrix.getRowsCount()) {
				sb.append(newline);
			}
		}
		
		return sb;
	}
	
	public IntegerMatrix integerMatrixFromCsv(File sourceFile) throws Exception {
        String line = "";
        String comma = ",";
        int colCount = -1;
        int rowCount = 0;
        
        List<List<String>> items = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while ((line = br.readLine()) != null) {
				String[] values = line.split(comma);
				
				if(colCount == -1) {
					colCount = values.length;
					
				} else if(colCount != values.length){
					throw new Exception("All column counts must be same.");
				}
				
				items.add(new ArrayList<String>(Arrays.asList(values)));

				rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

		int width = colCount;
		int height = rowCount;
		IntegerMatrix integerMatris = new IntegerMatrix(height, width);
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Integer value = Integer.valueOf(items.get(i).get(j));
				integerMatris.setValue(i, j, value);
			}
		}
		return integerMatris;
	}

}
