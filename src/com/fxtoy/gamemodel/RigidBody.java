package com.fxtoy.gamemodel;

public abstract class RigidBody {

	protected Vector2 position;
	protected float  mass;
	protected float angularMass;

	protected Vector2 linearVelocity = new Vector2(0, 0);
	protected float angle = 0.0f;
	protected float angularVelocity = 0;
	
	public RigidBody(Vector2 position, float mass) {
		this.position = position;
		this.mass = mass;
	}
	
	public RigidBody(float x, float y, float mass) {
		this.position = new Vector2(x, y);
		this.mass = mass;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public float getAngle() {
		return angle;
	}
	
	// TODO: is there any better way to do this?
	//       ideally, the setting of mass and angular mass should be bound
	//       together since angular mass is a function of mass (and shape)
	protected void setAngularMass(float angularMass) {
		this.angularMass = angularMass;
	}
	
	public Vector2 getForce() {
		return new Vector2(0, this.mass * Constants.GRAVITY);
	}
	public abstract float  getTorque();
	
	public abstract void integrate(float dt);
}