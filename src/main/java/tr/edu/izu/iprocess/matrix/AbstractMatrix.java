package tr.edu.izu.iprocess.matrix;

import tr.edu.izu.iprocess.matrix.operation.IBasicMatrixOperation;

public abstract class AbstractMatrix<T extends Number> implements IBasicMatrixOperation<T> {

	private T[][] datas = null;
	private int rowsCount = 0;
	private int columnsCount = 0;

	public AbstractMatrix(int aRow, int aCol) {
		this(aRow, aCol, null);
	}

	public AbstractMatrix(int aRow, int aCol, T defaultValue) {
		setRowsCount(aRow);
		setColumnsCount(aCol);
		this.setDatas(initMatris(defaultValue));
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

	protected void checkIndices(int row, int col) {
		String exceptionMessage = null;

		if (row < 0 || col < 0) {
			exceptionMessage = "Row and/or Column must be non negative";
			throw new RuntimeException(exceptionMessage, new IndexOutOfBoundsException(exceptionMessage));

		}

		if (row >= this.rowsCount || col >= this.columnsCount) {
			exceptionMessage = "[" + row + "," + col + "] is greater than [" + this.rowsCount + "," + this.columnsCount
					+ "]";
			throw new RuntimeException(exceptionMessage, new IndexOutOfBoundsException(exceptionMessage));
		}
	}

	public void setValue(int row, int col, T value) {
		checkIndices(row, col);
		getDatas()[row][col] = value;
	}

	public T getValue(int row, int col) {
		checkIndices(row, col);
		return getDatas()[row][col];
	}

	public T[][] getDatas() {
		return datas;
	}

	public void setDatas(T[][] datas) {
		//TODO columncount ve rowcount güncellenmeli ya da data uygun değil diye hata verilmeli
		this.datas = datas;
	}

}
