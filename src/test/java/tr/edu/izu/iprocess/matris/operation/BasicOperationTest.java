package tr.edu.izu.iprocess.matris.operation;

import tr.edu.izu.iprocess.matris.impl.IntegerMatris;
import junit.framework.TestCase;

public class BasicOperationTest extends TestCase {

	private IntegerMatris matris = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		matris = new IntegerMatris(3, 3);
	}

	private void assertAllValue(IntegerMatris m, Integer value) {
		for (int i = 0; i < m.getRowsCount(); i++)
			for (int j = 0; j < m.getColumnsCount(); j++)
				assertTrue(value == m.getValue(i, j));
	}

	public void testMatrisShouldBeFilledWithNonZero() {
		IntegerMatris localMatris = new IntegerMatris(2, 2, 2);
		assertAllValue(localMatris, 2);
	}

	public void testMatrisShouldBeFilledWithZero() {
		assertAllValue(matris, 0);

	}

	public void testMatrisRowCountShouldBeThree() {
		assertEquals(3, matris.getRowsCount());
	}

	private void testNegativeIndices(int row, int col) {
		try {
			matris.getValue(row, col);
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
			matris.sumWithScalar(4);
			assertAllValue(matris, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testDevideWithScalar() {
		try {
			matris.sumWithScalar(4);
			matris.divideWithScalar(2);
			assertAllValue(matris, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testMultiplyWithScalar() {
		try {
			matris.sumWithScalar(4);
			matris.multiplyWithScalar(2);
			assertAllValue(matris, 8);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testSubstractWithScalar() {
		try {
			matris.sumWithScalar(4);
			matris.substractWithScalar(2);
			assertAllValue(matris, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testTranspose() {
		try {
			matris.sumWithScalar(3);
			matris.setValue(0, 2, 1);
			matris.transpose();
			assertTrue(1 == matris.getValue(2, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
