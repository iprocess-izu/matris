package tr.edu.izu.iprocess.matris.operation;

import tr.edu.izu.iprocess.matris.AbstractMatris;


public interface IBasicMatrixOperation<T extends Number> {

	public void sumWithScalar(T scalar) throws Exception;
	
	public void multiplyWithScalar(T scalar) throws Exception;
	
	public void substractWithScalar(T scalar) throws Exception;
	
	public void divideWithScalar(T scalar) throws Exception;
	
	public void transpose() throws Exception;
	
	public AbstractMatris<T> multiply(AbstractMatris<T> otherMatris) throws Exception;
	
	public AbstractMatris<T> dotMultiply(AbstractMatris<T> otherMatris) throws Exception;
	
}
