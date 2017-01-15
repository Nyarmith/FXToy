package com.fxtoy.gamemodel;

import javafx.scene.canvas.GraphicsContext;

abstract class GameEntity {
	public Vector2 position;
	public Vector2 velocity;
	public Vector2 acceleration;
	float mass;
	
	public float getMass(){
		return mass;
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Vector2 getVelocity(){
		return velocity;
	}
	
	public Vector2 getAcceleration(){
		return acceleration;
	}
	
	abstract void update(float dt);
	
	abstract void drawOnCanvas(GraphicsContext gc);
	
}
