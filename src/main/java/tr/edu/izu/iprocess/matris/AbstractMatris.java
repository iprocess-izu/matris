package tr.edu.izu.iprocess.matris;

import tr.edu.izu.iprocess.matris.operation.IBasicMatrixOperation;

public abstract class AbstractMatris<T extends Number> implements IBasicMatrixOperation<T> {

	private T[][] datas = null;
	private int rowsCount = 0;
	private int columnsCount = 0;

	public AbstractMatris(int aRow, int aCol) {
		this(aRow, aCol, null);
	}

	public AbstractMatris(int aRow, int aCol, T defaultValue) {
		setRowsCount(aRow);
		setColumnsCount(aCol);
		this.datas = initMatris(defaultValue);
	}

	protected abstract T[][] initMatris(T defaultValue);

	protected void setRowsCount(int aRowsCount) {
		this.rowsCount = aRowsCount;
	}

	protected void setColumnsCount(int aColumsCount) {
		this.columnsCount = aColumsCount;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public int getColumnsCount() {
		return columnsCount;
	}

	protected void checkIndices(int row, int col) throws IndexOutOfBoundsException {
		String exceptionMessage = null;
		if (row > this.rowsCount || col > this.columnsCount) {
			exceptionMessage = "[" + row + "," + col + "] is greater than [" + this.rowsCount + "," + this.columnsCount + "]";
			throw new IndexOutOfBoundsException(exceptionMessage);
		}
		
	}

	public void setValue(int row, int col, T value) throws IndexOutOfBoundsException {
		checkIndices(row, col);
		datas[row][col] = value;
	}

	public T getValue(int row, int col) throws IndexOutOfBoundsException {
		checkIndices(row, col);
		return datas[row][col];
	}


}
