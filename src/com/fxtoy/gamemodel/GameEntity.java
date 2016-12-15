package com.fxtoy.gamemodel;

import javafx.scene.canvas.GraphicsContext;

abstract class GameEntity {
	public Vec2 position;
	public Vec2 velocity;
	public Vec2 acceleration;
	double mass;
	
	public double getMass(){
		return mass;
	}
	
	public Vec2 getPosition(){
		return position;
	}
	
	public Vec2 getVelocity(){
		return velocity;
	}
	
	public Vec2 getAcceleration(){
		return acceleration;
	}
	
	abstract void update(double dt);
	
	abstract void drawOnCanvas(GraphicsContext gc);
	
}
