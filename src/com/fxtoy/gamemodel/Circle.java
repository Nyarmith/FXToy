package com.fxtoy.gamemodel;

import com.fxtoy.application.Parameters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends GameEntity {
	public double radius;
	
	void update(double dt){
		//could get stuck in walls with this logic but whatever
		if (position.x-radius < 0 || position.x+radius > Parameters.getInstance().screen_width){
			velocity.x = -velocity.x;
		}
		if (position.y-radius < 0 || position.y+radius > Parameters.getInstance().screen_height){
			velocity.y = -velocity.y;
		}
		
		position = position.add(velocity.scale(dt));
	}
	
	void drawOnCanvas(GraphicsContext gc){
		gc.setFill(Color.GREEN);
		gc.fillOval(position.x-radius, position.y-radius,
					radius, radius);
	}
}
