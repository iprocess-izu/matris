package tr.edu.izu.iprocess.matrix.operation;

import java.io.IOException;

import tr.edu.izu.iprocess.matrix.impl.IntegerMatrix;

public class Closing {
	
	private IntegerMatrix source;
	private Window window;
	
	public Closing(IntegerMatrix source, Window window) {
		this.source = source;
		this.window = window;
	}

	public IntegerMatrix execute() throws IOException {
		return new Erosion(new Dilation(source, window).execute(), window).execute();
	}
}
