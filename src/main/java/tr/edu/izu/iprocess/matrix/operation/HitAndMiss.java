package tr.edu.izu.iprocess.matrix.operation;

import java.io.IOException;

import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;
import tr.edu.izu.iprocess.matrix.operation.Window.Distance;

public class HitAndMiss {
	
	private IntegerMatrix source;
	private Window window;
	
	public HitAndMiss(IntegerMatrix source, Window window) {
		this.source = source;
		this.window = window;
	}

	public IntegerMatrix execute() throws IOException {
		int rows = source.getRowsCount();
		int cols = source.getColumnsCount();
		
		IntegerMatrix hitAndMissed = new IntegerMatrix(rows, cols); 
		
		for (int j = 1; j < rows-1; j++) {
			for (int i = 1; i < cols-1; i++) {
				boolean set = true;
				
				for(int k = 0; k < window.getRowsCount(); k++) {
					for(int l = 0; l < window.getColumnsCount(); l++) {
						
						if(window.getValue(k, l) != -1) {
							Distance distance = window.getDistance(k, l);

							int idist = i + distance.getColDistance();
							
							int jdist = j + distance.getRowDistance();
							
							
							if(idist >= source.getColumnsCount() 
									|| jdist >= source.getRowsCount()
									|| jdist < 0 || idist < 0
									) {
								set = false;
							} else {
								boolean hasSameValue = source.getValue(j + distance.getRowDistance(), 
										i + distance.getColDistance()) == window.getValue(k, l);
								
								
								set = set && hasSameValue;
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
					hitAndMissed.setValue(j, i, source.getValue(j, i));
				} else {
					hitAndMissed.setValue(j, i, 0);
				}
								
			}
		}
		
		return hitAndMissed;

	}
	
}
