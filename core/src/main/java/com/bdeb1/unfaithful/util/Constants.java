package com.bdeb1.unfaithful.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public final class Constants {

	public static final class Path {

		public static final String BACKGROUND = "assets/image/background.png";
		public static final String BACKGROUND_ATLAS =
			  "assets/atlas/Background_lvl_1.atlas";
	}

	public static final class World {

		public static final Dimension SCENE_DIMENSION = new Dimension (640,
		                                                               180);
		public static final Dimension VIEW_DIMENSION  = new Dimension (
			  Gdx.graphics.getWidth (), Gdx.graphics.getHeight ());
		public static final Vector3   SCENE_ORIGIN    = new Vector3 (
			  VIEW_DIMENSION.width / 2, VIEW_DIMENSION.height / 2, 0);
		public static final Vector3   SCENE_ANCHOR    = new Vector3 (
			  SCENE_ORIGIN.x + SCENE_DIMENSION.width / 4, SCENE_ORIGIN.y, 0);
		public static final float     CAMERA_PAN_EASE = 0.05f;
	}
}
