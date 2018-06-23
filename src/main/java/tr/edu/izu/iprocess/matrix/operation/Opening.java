package tr.edu.izu.iprocess.matrix.operation;

import java.io.IOException;

import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class Opening {
	
	private IntegerMatrix source;
	private Window window;
	
	public Opening(IntegerMatrix source, Window window) {
		this.source = source;
		this.window = window;
	}

	public IntegerMatrix execute() throws IOException {
		return new Dilation(new Erosion(source, window).execute(), window).execute();
	}
}
