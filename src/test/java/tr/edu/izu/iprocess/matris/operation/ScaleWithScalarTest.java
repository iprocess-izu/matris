package tr.edu.izu.iprocess.matris.operation;

import tr.edu.izu.iprocess.matris.impl.IntegerMatris;
import junit.framework.TestCase;

public class ScaleWithScalarTest extends TestCase {

	private IntegerMatris matris = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		matris = new IntegerMatris(3, 3);
	}

	public void testNothing() {
		assertEquals(matris.getColumnsCount(), 3);
	}

}
