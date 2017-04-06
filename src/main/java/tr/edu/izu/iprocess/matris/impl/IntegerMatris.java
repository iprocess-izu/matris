package tr.edu.izu.iprocess.matris.impl;

import tr.edu.izu.iprocess.matris.AbstractMatris;
import tr.edu.izu.iprocess.matris.exception.NotImplementedMethodException;

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
		throw new NotImplementedMethodException();
	}

	public void multiplyWithScalar(Integer scalar) throws Exception {
		throw new NotImplementedMethodException();
	}

	public void substractWithScalar(Integer scalar) throws Exception {
		throw new NotImplementedMethodException();
	}

	public void divideWithScalar(Integer scalar) throws Exception {
		throw new NotImplementedMethodException();
	}

	public void transpose() throws Exception {
		throw new NotImplementedMethodException();
	}

	public AbstractMatris<Integer> multiply(AbstractMatris<Integer> otherMatris) throws Exception {
		throw new NotImplementedMethodException();
	}

	public void dotMultiply(AbstractMatris<Integer> otherMatris) throws Exception {
		throw new NotImplementedMethodException();
	}

}
