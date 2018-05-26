package tr.edu.izu.iprocess.matrix.operation;

import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class Window extends IntegerMatrix {
	
	int centerX;
	int centerY;
	
	Distance[][] distanceArray;

	public Window(int aRow, int aCol, Integer[][] windowData) {
		super(aRow, aCol);
		setDatas(windowData);
		
		distanceArray = new Distance[this.getRowsCount()][this.getColumnsCount()];
		
		centerX = (aCol - 1) / 2;
		centerY = (aRow - 1) / 2;
		
		for(int k = 0; k < aRow; k++) {
			for(int l = 0; l < aCol; l++) {
				distanceArray[k][l] = new Distance(k - centerY, l-centerX);
			}
		}
	}
	
	
	public Distance getDistance(int aRow, int aCol) {
		return distanceArray[aRow][aCol];
	}
	
	public class Distance {

		private int colDistance;
		private int rowDistance;

		public Distance(int rowDistance, int colDistance) {
			this.rowDistance = rowDistance;
			this.colDistance = colDistance;
		}

		public int getColDistance() {
			return colDistance;
		}

		public void setColDistance(int colDistance) {
			this.colDistance = colDistance;
		}

		public int getRowDistance() {
			return rowDistance;
		}

		public void setRowDistance(int rowDistance) {
			this.rowDistance = rowDistance;
		}
		
	}
	
	

}
