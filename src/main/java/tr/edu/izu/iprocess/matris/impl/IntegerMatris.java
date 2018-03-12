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
		throw new NotImplementedMethodException();
	}

	public void dotMultiply(AbstractMatris<Integer> otherMatris) throws Exception {
		throw new NotImplementedMethodException();
	}

}
