package com.bdeb1.unfaithful.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bdeb1.unfaithful.Assets;

public class Scene {

	public  OrthographicCamera camera;
	private Rectangle          bounds;
	private Direction          directionCamera;
	private Vector3            cameraOrigin;


	private Animation<TextureRegion> animation;
	private TextureRegion            textureRegion;
	private float deltaTime = 0;


	public Scene (Dimension visible, Animation<TextureRegion> animation)
	{
		this.animation = animation;
		textureRegion = animation.getKeyFrame (deltaTime);

		
		camera = new OrthographicCamera (Constants.World.VIEW_DIMENSION.width,
		                                 Constants.World.VIEW_DIMENSION
			                                   .height);
		cameraOrigin = new Vector3 (visible.width / 2, visible.height / 2, 0);
		camera.translate (Constants.World.SCENE_ANCHOR.x,
		                  Constants.World.SCENE_ANCHOR.y);
		bounds = new Rectangle (0, 0, Constants.World.SCENE_DIMENSION.width,
		                        Constants.World.SCENE_DIMENSION.height);


		directionCamera = Direction.Center;
	}



	public void update (float dtime) {
		deltaTime += dtime;
		// deplacement of the camera
		float dx = Math.min (1 + Math.abs (
			  Constants.World.SCENE_ANCHOR.x - camera.position.x) *
		                         Constants.World.CAMERA_PAN_EASE,
		                     camera.position.x);
		// move with keys
		if (Gdx.input.isKeyPressed (Input.Keys.RIGHT)) {
			camera.translate (dx, 0);
		} else if (Gdx.input.isKeyPressed (Input.Keys.LEFT)) {
			camera.translate (- dx, 0);
			// move back automagically
		} else if (directionCamera == Direction.Right) {
			camera.translate (- dx, 0);
		} else if (directionCamera == Direction.Left) {
			camera.translate (dx, 0);
		}

		// bound checking
		if (camera.position.x < cameraOrigin.x) {
			camera.position.x = cameraOrigin.x;
		} else if (camera.position.x >
		           cameraOrigin.x + bounds.width - camera.viewportWidth)
		{
			camera.position.x = cameraOrigin.x + bounds.width -
			                    camera.viewportWidth;
		}

		// update camera direction (state)
		if (camera.position.x < Constants.World.SCENE_ANCHOR.x - 0.5f) {
			directionCamera = Direction.Left;
		} else if (camera.position.x > Constants.World.SCENE_ANCHOR.x + 0.5f) {
			directionCamera = Direction.Right;
		} else {
			directionCamera = Direction.Center;
		}
		camera.update ();
	}

	public void draw (Batch batch) {
		textureRegion = animation.getKeyFrame (deltaTime, true);
		batch.draw (textureRegion, bounds.x, bounds.y, bounds.width,
		            bounds.height );
	}

	public void dispose () {
	}
}