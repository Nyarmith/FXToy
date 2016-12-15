package com.fxtoy.application;

//in-memory copy of the parameters
public class Parameters {
	
	public double drag;
	public double mouse_force;
	public double mass;
	public int screen_width;
	public int screen_height;
	
	private Parameters() {}
	
	private static class ParamHolder { 
		private static final Parameters INSTANCE = new Parameters();
	}
	
	public static Parameters getInstance() {
		return ParamHolder.INSTANCE;
	}
}
