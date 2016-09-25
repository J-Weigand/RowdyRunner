package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Reads in the buffer images
 */
public class BufferedImageLoader {

	// Variable Declaration
	private BufferedImage image;

	/**
	 * Loads images from resources and throws IOException if unable
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public BufferedImage loadImage(String path) throws IOException {
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
}
