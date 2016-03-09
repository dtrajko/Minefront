package com.dtrajko.java.minefront.input;

public class Controller {

	public double x, y, z, rotation, xa, za, rotationa;
	public static boolean turnLeft = false;
	public static boolean turnRight = false;

	public void tick(boolean forward, boolean back, boolean left, boolean right) {
		double rotationSpeed = Math.PI / 100;
		double walkSpeed = 1;
		double xMove = 0;
		double zMove = 0;

		if (forward) {
			zMove++;
		}

		if (back) {
			zMove--;
		}

		if (left) {
			xMove--;
		}

		if (right) {
			xMove++;
		}

		if (turnLeft) {
			rotationa -= rotationSpeed;
		}

		if (turnRight) {
			rotationa += rotationSpeed;
		}
	
		xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
		za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;

		x += xa;
		z += za;
		xa *= 0.1;
		za *= 0.1;
		rotation += rotationa;
		rotationa *= 0.2;
	}
}
