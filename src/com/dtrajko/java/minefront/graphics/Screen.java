package com.dtrajko.java.minefront.graphics;

import java.util.Random;

import com.dtrajko.java.minefront.Game;

public class Screen extends Render {

	private Render test;
	private Render3D render;

	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		render = new Render3D(width, height);
		test = new Render(256, 256);
		for (int i = 0; i < 256 * 256; i++) {
			test.pixels[i] = random.nextInt() * (random.nextInt(5) / 4);
		}
	}

	public void render(Game game) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = 0;
		}

		/*
		for (int i = 0; i < 10; i++) {
			int xAnim = (int) (Math.sin((game.time + i * 10) % 1000) * 100);
			int yAnim = (int) (Math.cos((game.time + i * 10) % 1000) * 100);
			draw(test, (width - 256) / 2 + xAnim, (height - 256) / 2 - yAnim);			
		}
		*/

		render.floor(game);
		render.renderDistanceLimiter();
		draw(render, 0, 0);
	}
}
