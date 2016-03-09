package com.dtrajko.java.minefront.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Texture {
	public static Render floor = loadBitmap("/textures/floor.png");
	public static Render ceiling = loadBitmap("/textures/ceiling.png");

	private static Render loadBitmap(String fileName) {
		try {
			BufferedImage image = ImageIO.read(Texture.class.getResource(fileName));
			// BufferedImage image = ImageIO.read(new File("/textures/floor.png"));
			int width = image.getWidth();
			int height = image.getHeight();
			Render result = new Render(width, height);
			image.getRGB(0, 0, width, height, result.pixels, 0, width);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.out.println("Failed to load the texture " + Texture.class.getResource(fileName));
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
