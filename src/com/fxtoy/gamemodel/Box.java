package com.fxtoy.gamemodel;

public class Box extends RigidBody {

	private float width;
	private float height;
	
	public Box(Vector2 position, float width, float height, float mass) {
		super(position, mass);
		init(width, height, mass);
	}
	
	public Box(float x, float y, float width, float height, float mass) {
		super(x, y, mass);
		init(width, height, mass);
	}
	
	private void init(float width, float height, float mass) {
		this.width = width;
		this.height = height;
		setAngularMass(mass * (width*width + height*height) / 12);
	}
	
	@Override
	public float getTorque() {
		Vector2 arm = new Vector2(width / 2, height / 2);
		return arm.cross(getForce());
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	@Override
	public void integrate(float dt) {
		Vector2 force = getForce();
		float torque = getTorque();
		
		Vector2 linearAcceleration = force.scaled((float)1 / mass);
		linearVelocity.add(linearAcceleration.scaled(dt));
		position.add(linearVelocity.scaled(dt));
		
		float angularAcceleration = torque / angularMass;
		angularVelocity += angularAcceleration * dt;
		angle += angularVelocity * dt;
		angle = angle % 2*(float)Math.PI;
	}
}
