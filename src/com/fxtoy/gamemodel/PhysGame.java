package com.fxtoy.gamemodel;

import com.fxtoy.application.Parameters;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;

public class PhysGame extends AnimationTimer{
	GraphicsContext gc;
	long last_time;
	long dt;
	ObservableList<GameEntity> myEntities = FXCollections.observableArrayList();
	
	public PhysGame(GraphicsContext g) {
		//TODO -- remove from here
		gc=g; last_time=0;
		Circle a = new Circle();
		a.velocity = new Vec2(2,6);
		a.position = new Vec2(200,200);
		a.radius=100;
		myEntities.add(a);
	}
	
	@Override
	public void handle(long timestamp){
		if (last_time > 0){
			dt = timestamp - last_time;
			updateWorld(dt);
			//drawAll();
		}
		last_time = timestamp;
	}
	
	void updateWorld(long dt){
		//world stuff whatever
		gc.clearRect(0,0,Parameters.getInstance().screen_width,
				Parameters.getInstance().screen_height);

		double dt_in_seconds = dt / 10000000.0;
		for (GameEntity i : myEntities){
			i.update(dt_in_seconds);
			i.drawOnCanvas(gc);    //note this only sends commands and doesn't render yet
		}
	}
	
	void drawAll(){
		gc.fill();
		gc.stroke();
	}
	
	
}
