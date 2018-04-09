package tr.edu.izu.iprocess.matrix.operation;

import tr.edu.izu.iprocess.matrix.AbstractMatrix;


public interface IBasicMatrixOperation<T extends Number> {

	public void sumWithScalar(T scalar) throws Exception;
	
	public void multiplyWithScalar(T scalar) throws Exception;
	
	public void substractWithScalar(T scalar) throws Exception;
	
	public void divideWithScalar(T scalar) throws Exception;
	
	public void transpose() throws Exception;
	
	public AbstractMatrix<T> multiply(AbstractMatrix<T> otherMatris) throws Exception;
	
	public AbstractMatrix<T> dotMultiply(AbstractMatrix<T> otherMatris) throws Exception;
	
}
