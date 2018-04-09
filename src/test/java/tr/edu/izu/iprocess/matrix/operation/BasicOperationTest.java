package tr.edu.izu.iprocess.matrix.operation;

import junit.framework.TestCase;
import tr.edu.izu.iprocess.matrix.AbstractMatrix;
import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class BasicOperationTest extends TestCase {

	private IntegerMatrix matrix = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		matrix = new IntegerMatrix(3, 3);
	}

	private void assertAllValue(IntegerMatrix m, Integer value) {
		for (int i = 0; i < m.getRowsCount(); i++)
			for (int j = 0; j < m.getColumnsCount(); j++)
				assertTrue(value == m.getValue(i, j));
	}

	public void testMatrixShouldBeFilledWithNonZero() {
		IntegerMatrix localMatrix = new IntegerMatrix(2, 2, 2);
		assertAllValue(localMatrix, 2);
	}

	public void testMatrixShouldBeFilledWithZero() {
		assertAllValue(matrix, 0);

	}

	public void testMatrixRowCountShouldBeThree() {
		assertEquals(3, matrix.getRowsCount());
	}

	private void testNegativeIndices(int row, int col) {
		try {
			matrix.getValue(row, col);
		} catch (RuntimeException rex) {
			assertEquals(IndexOutOfBoundsException.class.getName(), rex.getCause().getClass().getName());
		}
	}

	public void testNegativeRowIndiceShouldThrowRunTimeException() {
		testNegativeIndices(-1, 0);
	}

	public void testNegativeColIndiceShouldThrowRunTimeException() {
		testNegativeIndices(0, -1);
	}

	public void testNegativeIndicesShouldThrowRunTimeException() {
		testNegativeIndices(-1, -1);
	}

	public void testSumWithScalar() {
		try {
			matrix.sumWithScalar(4);
			assertAllValue(matrix, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testDevideWithScalar() {
		try {
			matrix.sumWithScalar(4);
			matrix.divideWithScalar(2);
			assertAllValue(matrix, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testMultiplyWithScalar() {
		try {
			matrix.sumWithScalar(4);
			matrix.multiplyWithScalar(2);
			assertAllValue(matrix, 8);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testSubstractWithScalar() {
		try {
			matrix.sumWithScalar(4);
			matrix.substractWithScalar(2);
			assertAllValue(matrix, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testTranspose() {
		try {
			matrix.sumWithScalar(3);
			matrix.setValue(0, 2, 1);
			matrix.transpose();
			assertTrue(1 == matrix.getValue(2, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testMultiply() {
		try {
			matrix.sumWithScalar(3);
			IntegerMatrix integermatrix = new IntegerMatrix(3, 1);
			integermatrix.sumWithScalar(2);
			AbstractMatrix<Integer> multiply = matrix.multiply(integermatrix);
			assertTrue(18 == multiply.getValue(2, 0));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testDotMultiply() {
		try {
			
			IntegerMatrix integermatrix1 = new IntegerMatrix(1, 9);
			integermatrix1.sumWithScalar(3);
			IntegerMatrix integermatrix2 = new IntegerMatrix(1, 9);
			integermatrix2.sumWithScalar(2);
			AbstractMatrix<Integer> multiply = integermatrix1.dotMultiply(integermatrix2);
			
			assertTrue(54 == multiply.getValue(0, 0));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
