package tr.edu.izu.iprocess.matrix.impl;

import tr.edu.izu.iprocess.matrix.AbstractMatrix;
import tr.edu.izu.iprocess.matrix.exception.NotInitializedMatrixException;

public class IntegerMatrix extends AbstractMatrix<Integer> {

	public IntegerMatrix(int aRow, int aCol) {
		this(aRow, aCol, 0);
	}

	public IntegerMatrix(int aRow, int aCol, Integer defaultValue) {
		super(aRow, aCol, defaultValue);
	}

	@Override
	protected Integer[][] initMatris(Integer defaultValue) {
		Integer[][] matrisDatas = new Integer[this.getRowsCount()][this.getColumnsCount()];
		for (int row = 0; row < this.getRowsCount(); row++)
			for (int col = 0; col < this.getColumnsCount(); col++)
				matrisDatas[row][col] = defaultValue;

		return matrisDatas;

	}

	public void sumWithScalar(Integer scalar) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		for (int row = 0; row < this.getRowsCount(); row++)
			for (int col = 0; col < this.getColumnsCount(); col++)
				getDatas()[row][col] = getDatas()[row][col] + scalar;

	}

	public void multiplyWithScalar(Integer scalar) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		for (int row = 0; row < this.getRowsCount(); row++)
			for (int col = 0; col < this.getColumnsCount(); col++)
				getDatas()[row][col] = getDatas()[row][col] * scalar;
	}

	public void substractWithScalar(Integer scalar) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		for (int row = 0; row < this.getRowsCount(); row++)
			for (int col = 0; col < this.getColumnsCount(); col++)
				getDatas()[row][col] = getDatas()[row][col] - scalar;
	}

	public void divideWithScalar(Integer scalar) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		for (int row = 0; row < this.getRowsCount(); row++)
			for (int col = 0; col < this.getColumnsCount(); col++)
				getDatas()[row][col] = getDatas()[row][col] / scalar;
	}

	public void transpose() throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		Integer[][] matrisDatas = new Integer[this.getRowsCount()][this.getColumnsCount()];
		for (int row = 0; row < this.getRowsCount(); row++)
			for (int col = 0; col < this.getColumnsCount(); col++)
				matrisDatas[row][col] = getDatas()[col][row];
		setDatas(matrisDatas);

	}

	public AbstractMatrix<Integer> multiply(AbstractMatrix<Integer> otherMatris) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		int aRows = getRowsCount();
		int aColumns = getColumnsCount();
		int bRows = otherMatris.getRowsCount();
		int bColumns = otherMatris.getColumnsCount();

		if (aColumns != bRows) {
			throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
		}

		IntegerMatrix newMatrix = new IntegerMatrix(aRows, bColumns, 0);

		for (int i = 0; i < aRows; i++) { // aRow
			for (int j = 0; j < bColumns; j++) { // bColumn
				for (int k = 0; k < aColumns; k++) { // aColumn
					newMatrix.getDatas()[i][j] += getDatas()[i][k] * otherMatris.getDatas()[k][j];
				}
			}
		}

		return newMatrix;

	}

	public AbstractMatrix<Integer> dotMultiply(AbstractMatrix<Integer> otherMatris) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		int aRows = getRowsCount();
		int aColumns = getColumnsCount();
		int bRows = otherMatris.getRowsCount();
		int bColumns = otherMatris.getColumnsCount();

		if (!(aColumns == bColumns && aRows == bRows)) {
			throw new IllegalArgumentException("Rows and columns did not match");
		}

		IntegerMatrix newMatrix = new IntegerMatrix(1, aRows, 0);

		for (int i = 0; i < aRows; i++) { // aRow
			int tempLineSum = 0;
			for (int j = 0; j < aColumns; j++) { // aColumn
				tempLineSum += getDatas()[i][j] * otherMatris.getDatas()[i][j];
			}
			newMatrix.getDatas()[0][i] = tempLineSum;
		}

		return newMatrix;
	}

}
