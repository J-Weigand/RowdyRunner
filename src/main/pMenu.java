package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The following class holds the elements and their screen locations 
 * of the pause menu system for RowdyRunner
 */
public class pMenu {
	
	//Generates Buttons on Menu 
		public Rectangle resButton = 
				new Rectangle((main.WIDTH * main.SCALE) / 3 + 90, 250,
						150, 50);
		public Rectangle quitButton = 
				new Rectangle((main.WIDTH * main.SCALE) / 3 + 90, 350,
						150, 50);
		
		/**
		 * Renders locations, fonts, sizes, and dynamics of the texts stored 
		 * inside the generated buttons.
		 * @param g
		 */
		public void render(Graphics g) {
			//Declarations
			Graphics2D g2d = (Graphics2D) g;
			
			// Buttons
			Font f1 = new Font("arial", Font.BOLD, 28);
			g.setFont(f1);
			g.setColor(Color.WHITE);
			//draws the Resume Button 
			g.drawString("Resume", resButton.x + 19, resButton.y + 35);
			g2d.draw(resButton);
			//draws the Quit Button 
			g.drawString("Quit", quitButton.x + 45, quitButton.y + 35);
			g2d.draw(quitButton);
		}

}
