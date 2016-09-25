package main;

import java.awt.Graphics;

/**
 * Sets: - Boundaries, textures, location of the character model.
 */
public class Player extends Object {

	// Variable Declarations
	@SuppressWarnings("unused")
	private Textures tex;
	private double velX = 0;
	private double velY = 0;

	/**
	 * <<Constructor>> The Super Class being used is the Object class
	 * 
	 * @param x
	 * @param y
	 * @param tex
	 */
	public Player(double x, double y, Textures tex) {

		// Initializes our Player on the screen
		super(x, y);
		this.tex = tex;
	}

	/**
	 * Updates the movements of Rowdy
	 */
	public void tick() {
		x += velX;
		y += velY;

		// Lock the parameters for the player window
		if (x <= 0)
			x = 0;
		if (x >= 960)
			x = 960;
		if (y <= 0)
			y = 0;
		if (y >= 700)
			y = 700;
	}

	/**
	 * Draws Rowdy on the screen
	 * 
	 * @param g
	 * @param tex
	 */
	public void render(Graphics g, Textures tex) {
		g.drawImage(tex.player, (int) x, (int) y, null);
	}

	/**
	 * Setter for X-Direction
	 * 
	 * @param velX
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}

	/**
	 * Setter for Y-Direction
	 * 
	 * @param velY
	 */
	public void setVelY(double velY) {
		this.velY = velY;
	}

	/**
	 * get player X position
	 * 
	 * @return
	 */
	public double getX() {
		return x;

	}

}
