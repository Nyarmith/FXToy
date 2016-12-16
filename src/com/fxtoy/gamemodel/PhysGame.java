package com.fxtoy.gamemodel;

import java.util.ArrayList;
import java.util.List;

import com.fxtoy.application.GameParameters;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PhysGame extends AnimationTimer{
	GraphicsContext gc;
	long last_time;
	long dt;
	List<GameEntity> myEntities = new ArrayList<GameEntity>();
	
	public PhysGame(GraphicsContext g) {
		//TODO -- remove from here
		gc=g; last_time=0;
		Circle a = new Circle();
		a.velocity = new Vec2(20,60);
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
		double dt_in_seconds = dt / 1e9f;
		for (GameEntity i : myEntities){
			i.update(dt_in_seconds);
			//i.drawOnCanvas(gc);    //note this only sends commands and doesn't render yet
		}
	}
	
	void drawAll(){
		gc.setFill(Color.FLORALWHITE);
		gc.fillRect(0,0,GameParameters.getInstance().screen_width,
				GameParameters.getInstance().screen_height);
		for (GameEntity i : myEntities){
			i.drawOnCanvas(gc);    //note this only sends commands and doesn't render yet
		}
		//gc.fill();
	}
	
	
}
