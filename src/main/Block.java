package main;

import java.awt.Graphics;
import java.util.Random;

/**
 * Manages the Block elements by randomizing their spawn points, controlling
 * their speeds, and bounds.
 */
public class Block extends Object implements Entity {

	// Class Variable Declarations
	private double x, y;
	private Textures tex;
	Random r = new Random();

	/**
	 * <<Constructor>>
	 * 
	 * @param x
	 * @param y
	 * @param tex
	 */
	public Block(double x, double y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}

	/**
	 * Updates Block speed and resets the blocks once they hit the floor and
	 * don't become visible
	 */
	public void tick() {
		// Controls speed of elements
		y += 3;
		// Resets Blocks to the top
		if (y > (main.HEIGHT)) {
			y = 0;
			// Controls random generation: x-axis
			x = r.nextInt((main.WIDTH));
		}
	}

	/**
	 * Renders block image pulled from the SpriteSheet
	 */
	public void render(Graphics g) {
		g.drawImage(tex.block, (int) x, (int) y, null);
	}

	/**
	 * Getter - Block (Y-Coord.)
	 */
	public double getY() {
		return y;
	}

	/**
	 * Setter - Block (Y-Coord.)
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Getter - Block (X-Coord.)
	 */
	public double getX() {
		return x;
	}
}
