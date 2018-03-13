package tr.edu.izu.iprocess.matris.impl;

import tr.edu.izu.iprocess.matris.AbstractMatris;
import tr.edu.izu.iprocess.matris.exception.NotImplementedMethodException;
import tr.edu.izu.iprocess.matris.exception.NotInitializedMatrixException;

public class IntegerMatris extends AbstractMatris<Integer> {

	public IntegerMatris(int aRow, int aCol) {
		this(aRow, aCol, 0);
	}

	public IntegerMatris(int aRow, int aCol, Integer defaultValue) {
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

	public AbstractMatris<Integer> multiply(AbstractMatris<Integer> otherMatris) throws Exception {
		if (getDatas() == null)
			throw new NotInitializedMatrixException();
		int aRows = getRowsCount();
		int aColumns = getColumnsCount();
		int bRows = otherMatris.getRowsCount();
		int bColumns = otherMatris.getColumnsCount();

		if (aColumns != bRows) {
			throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
		}

		IntegerMatris newMatrix = new IntegerMatris(aRows, bColumns, 0);

		for (int i = 0; i < aRows; i++) { // aRow
			for (int j = 0; j < bColumns; j++) { // bColumn
				for (int k = 0; k < aColumns; k++) { // aColumn
					newMatrix.getDatas()[i][j] += getDatas()[i][k] * otherMatris.getDatas()[k][j];
				}
			}
		}

		return newMatrix;

	}

	public void dotMultiply(AbstractMatris<Integer> otherMatris) throws Exception {
		throw new NotImplementedMethodException();
	}

}
