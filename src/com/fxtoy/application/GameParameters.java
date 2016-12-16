package com.fxtoy.application;

//in-memory copy of the parameters
public class GameParameters {
	
	public double drag;
	public double mouse_force;
	public double mass;
	public int screen_width;
	public int screen_height;
	
	private GameParameters() {}
	
	private static class ParamHolder { 
		private static final GameParameters INSTANCE = new GameParameters();
	}
	
	public static GameParameters getInstance() {
		return ParamHolder.INSTANCE;
	}
}
