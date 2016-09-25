package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The following class holds the elements and their screen locations of the game
 * over menu system for RowdyRunner
 */
public class Gameover {
	// Generates Buttons for when Game is over
	public Rectangle tryButton = new Rectangle((main.WIDTH * main.SCALE) / 3 + 90, 250, 150, 50);
	public Rectangle mainButton = new Rectangle((main.WIDTH * main.SCALE) / 3 + 90, 350, 150, 50);
	public Rectangle quitButton = new Rectangle((main.WIDTH * main.SCALE) / 3 + 90, 450, 150, 50);

	/**
	 * Renders locations, fonts, sizes, and dynamics of the texts stored inside
	 * the generated buttons.
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		// Declarations
		Graphics2D g2d = (Graphics2D) g;
		Font f2 = new Font("arial", (Font.BOLD + Font.ITALIC), 60);
		g.setFont(f2);
		g.setColor(Color.WHITE);
		g.drawString("Game Over!", (main.WIDTH * main.SCALE) / 3, 150);

		// Buttons
		Font f1 = new Font("arial", Font.BOLD, 30);
		g.setFont(f1);
		g.setColor(Color.WHITE);
		// drawing Retry Button
		g.drawString("Retry", tryButton.x + 35, tryButton.y + 35);
		g2d.draw(tryButton);
		// drawing Menu Button
		g.drawString("Menu", mainButton.x + 35, mainButton.y + 35);
		g2d.draw(mainButton);
		// drawing Exit Button
		g.drawString("Exit", quitButton.x + 45, quitButton.y + 35);
		g2d.draw(quitButton);
	}

}
