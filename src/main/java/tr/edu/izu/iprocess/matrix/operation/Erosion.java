package tr.edu.izu.iprocess.matrix.operation;

import java.io.IOException;

import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;
import tr.edu.izu.iprocess.matrix.operation.Window.Distance;

public class Erosion {
	
	private IntegerMatrix source;
	private Window window;
	
	public Erosion(IntegerMatrix source, Window window) {
		this.source = source;
		this.window = window;
	}

	public IntegerMatrix execute() throws IOException {
		int rows = source.getRowsCount();
		int cols = source.getColumnsCount();
		
		IntegerMatrix eroded = new IntegerMatrix(rows, cols); 
		
		//kolaylik olsun diye kenar pikselleri katmiyorum
		for (int j = 1; j < rows-1; j++) {
			for (int i = 1; i < cols-1; i++) {
				//square window
				boolean set = true;
				
				for(int k = 0; k < window.getRowsCount(); k++) {
					for(int l = 0; l < window.getColumnsCount(); l++) {
						
						if(window.getValue(k, l) != 0) {
							Distance distance = window.getDistance(k, l);
							
							if(i + distance.getColDistance() >= source.getColumnsCount() 
									|| j + distance.getRowDistance() >= source.getRowsCount()) {
								set = false;
							} else {
								boolean hasValue = source.getValue(j + distance.getRowDistance(), 
										i + distance.getColDistance()) != 0;
								
								
								set = set && hasValue;
							}
							
						}
						
						if(!set) {
							break;
						}
					}
					
					if(!set) {
						break;
					}
				}
				
				if(set) {
					eroded.setValue(j, i, source.getValue(j, i));
				} else {
					eroded.setValue(j, i, 0);
				}
								
			}
		}
		
		return eroded;

	}
	
}
