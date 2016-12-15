package com.fxtoy.gamemodel;

//java doesn't have operator overloading. SAD.

public class Vec2 {
	public double x;
	public double y;
	
	Vec2() 
		{ x=0.0; y=0.0; }
	
	Vec2(double a, double b)
		{ x=a; y=b; }
	
	double size(){
		return Math.sqrt(x*x + y*y);
	}
	
	double dot(Vec2 o){
		return Math.sqrt(x*o.x + y*o.y);
	}
	
	Vec2 scale(double s){
		return (new Vec2(x*s, y*s));
	}
	
	Vec2 subtract(Vec2 o){
		return new Vec2(x-o.x, y-o.y);
	}
	
	Vec2 add(Vec2 o){
		return new Vec2(x+o.x, y+o.y);
	}
	
	Vec2 normalize(){
		double size = size();
		return new Vec2(x/size, y/size);
	}
}
