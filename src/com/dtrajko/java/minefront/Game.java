package com.dtrajko.java.minefront;

import java.awt.event.KeyEvent;

import com.dtrajko.java.minefront.input.Controller;

public class Game {

	public double time;
	public Controller controls;

	public Game() {
		controls = new Controller();
	}

	public void tick(boolean[] key) {
		time += 0.001;
		boolean forward = key[KeyEvent.VK_W];
		boolean back = key[KeyEvent.VK_S];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		// boolean turnLeft = key[KeyEvent.VK_LEFT];
		// boolean turnRight = key[KeyEvent.VK_RIGHT];

		controls.tick(forward, back, left, right);
	}
}
