package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The following class holds the elements and their screen locations of the help
 * menu system for RowdyRunner
 */
public class hMenu {
	
	// Generates the back button for the help menu
	public Rectangle backButton = new Rectangle((main.WIDTH * main.SCALE) / 14, 650, 100, 50);

	/**
	 * Renders locations, fonts, sizes, and dynamics of the texts stored inside
	 * the generated buttons.
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		// Declarations
		Graphics2D g2d = (Graphics2D) g;
		
		// Description of the Game
		Font f1 = new Font("arial", Font.BOLD, 28);
		g.setFont(f1);
		g.setColor(Color.WHITE);
		g.drawString("Welcome to RowdyRunner!", (main.WIDTH * main.SCALE) / 4 + 95, 50);
		g.drawString("The objective of the game is to dodge the falling objects.",(main.WIDTH * main.SCALE) / 7, 80);
		g.drawString("You have one life to live. So, make it count.", (main.WIDTH * main.SCALE) / 5 + 25, 110);
		// Back Button
		g.drawString("Back", backButton.x + 15, backButton.y + 35);
		g2d.draw(backButton);
		// Explains the Controls of the Game
		Font f2 = new Font("arial", Font.BOLD, 20);
		g.setFont(f2);
		g.drawString("Controls:", 50, 175);
		g.drawString("- To Move Right Press the Right Arrow Key ", 100, 225);
		g.drawString("- To Move Left Press the Left Arrow Key", 100, 275);
		g.drawString("- To Move Up Press the Up Arrow Key", 100, 325);
		g.drawString("- To Move Down Press the Down Arrow Key", 100, 375);
		g.drawString("- To Pause Game Press ESC Key", 100, 425);
		// Developers
		g.drawString("Developers:", 50, 475);
		g.drawString("- Joshua Weigand, Wellington Rodrigues, Quaid Quintela, Daniel Molano, Lane Burris", 100, 525);
		g.drawString("Copyright © 2016", 750, 680);
	}
}
