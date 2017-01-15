package com.fxtoy.application;

import com.fxtoy.gamemodel.Box;
import com.fxtoy.view.BoxView;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class GameLoop extends AnimationTimer {

	long previousTimestamp = 0;
	GraphicsContext gc;
	Box box;
	BoxView view;
	
	public GameLoop(GraphicsContext gc) {
		this.gc = gc;
		this.box = new Box(120, 60, 25, 75, 100000000);
		this.view = new BoxView(box.getPosition(), box.getWidth(), box.getHeight(), box.getAngle());
	}
	
	@Override
	public void handle(long now) {
		// dt in seconds
		if (previousTimestamp == 0) {
			previousTimestamp = now;
			return;
		}
		float dt = (float)(now - previousTimestamp) / 1e9f;
		
		gc.setFill(Color.FLORALWHITE);
		double width = GameParameters.getInstance().screen_width;
		double height = GameParameters.getInstance().screen_height;
		gc.fillRect(0, 0, width, height);

		box.integrate(dt);
		view.update(box.getPosition(), box.getAngle());
		view.render(gc);

		previousTimestamp = now;
	}
}
