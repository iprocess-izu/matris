package tr.edu.izu.iprocess.matrix.operation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import tr.edu.izu.iprocess.matrix.AbstractMatrix;

public class MatrixCrop {

	public <T extends AbstractMatrix<A>, A extends Number> T extractMatrix(int topRow, int topColumn, int bottomRow, int bottomColumn, T sourceMatrix)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		// Gelen type a göre dönüş tipini ayarlayacak.
		// sourceMatrix içinden top column ve toprow dan bottom column ve bottomRow a
		// kadar alıp bununla bir matrix (aşağıdaki) oluşturup geri döndürecek bir sınıf
		// yazılacak

		// TODO check indices
		// TODO check parameter logic (bottom row can not be smaller than top row etc..)

		Class<? extends AbstractMatrix> cls = sourceMatrix.getClass();
		Constructor<? extends AbstractMatrix> declaredConstructor = cls.getDeclaredConstructor(int.class, int.class);
		T dstMatrix = (T) declaredConstructor.newInstance(bottomRow - topRow, bottomColumn - topColumn);

		for (int i = topRow; i < bottomRow; i++) {
			for (int j = topColumn; j < bottomColumn; j++) {
				A val = sourceMatrix.getValue(i, j);
				dstMatrix.setValue(i - topRow, j - topColumn, val);
			}
		}

		return dstMatrix;
	}

}
