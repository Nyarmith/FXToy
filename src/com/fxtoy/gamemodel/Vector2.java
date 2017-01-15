package com.fxtoy.gamemodel;

//java doesn't have operator overloading. SAD.

public class Vector2 {
	public float x;
	public float y;
	
	public Vector2() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2(Vector2 other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public float size() {
		return (float)Math.sqrt(x*x + y*y);
	}
	
	public float dot(Vector2 other) {
		return x*other.x + y*other.y;
	}
	
	public float cross(Vector2 other) {
		return this.x*other.y - this.y*other.x;
	}
	
	public Vector2 scale(float scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}
	
	public Vector2 scaled(float scalar) {
		return new Vector2(x*scalar, y*scalar);
	}
	
	public Vector2 sub(Vector2 other) {
		x -= other.x;
		y -= other.y;
		return this;
	}
	
	public Vector2 add(Vector2 other) {
		x += other.x;
		y += other.y;
		return this;
	}
	
	public Vector2 normalize() {
		float size = size();
		x /= size;
		y /= size;
		return this;
	}
}
