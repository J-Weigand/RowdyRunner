package main;

import java.awt.image.BufferedImage;

/**
 * Parses the images from the SpriteSheet
 */
public class SpriteSheet {

	// Variable Declarations
	private BufferedImage image;

	/**
	 * <<Constructor>>
	 * 
	 * @param image
	 */
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Grabs and crops out images found on the SpriteSheet
	 * 
	 * @param col
	 * @param row
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage grabImage(int col, int row, int width, int height) {

		BufferedImage img = image.getSubimage((col * 32) - 32, (row * 32) - 32, width, height);
		return img;
	}

}
