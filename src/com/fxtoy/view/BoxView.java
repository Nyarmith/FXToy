package com.fxtoy.view;

import com.fxtoy.gamemodel.Vector2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BoxView {

	private Vector2 position;
	private float   width;
	private float   height;
	private float   angle;
	
	public BoxView(Vector2 position, float width, float height, float angle) {
		this.position = position;
		this.width    = width;
		this.height   = height;
		this.angle    = angle;
	}
	
	public void update(Vector2 position, float angle) {
		this.position = position;
		this.angle    = angle;
	}
	
	public void render(GraphicsContext gc) {
		float x0 = position.x - width/2.0f;
		float x1 = x0 + width;
		float y0 = position.y - height/2.0f;
		float y1 = y0 + height;
		
		Vector2 topLeft = makeVertex(x0, y0);
		Vector2 bottomLeft = makeVertex(x0, y1);
		Vector2 topRight = makeVertex(x1, y0);
		Vector2 bottomRight = makeVertex(x1, y1);

		gc.beginPath();
		gc.moveTo(topLeft.x, topLeft.y);
		gc.lineTo(bottomLeft.x, bottomLeft.y);
		gc.lineTo(bottomRight.x, bottomRight.y);
		gc.lineTo(topRight.x, topRight.y);
		gc.closePath();

		gc.setFill(Color.DARKBLUE);
		gc.fill();
	}
	
	private Vector2 makeVertex(float x, float y) {
		// translate to origin
		Vector2 vertex = new Vector2(x, y);
		vertex.sub(position);
		
		// rotate about origin
		float c = (float)Math.cos(angle);
		float s = (float)Math.sin(angle);
		float xt = vertex.x;
		float yt = vertex.y;
		vertex.x = xt*c - yt*s;
		vertex.y = xt*s + yt*c;
		
		// translate back
		vertex.add(position);
		return vertex;
	}
}
