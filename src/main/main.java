package main;

import java.awt.Dimension;

import javax.swing.Timer;

/**
 * Main Class that holds the calls for: Game Loop initialization +
 * ImageBuffering + Ticks and Rendering + Key Bindings/Listeners
 * 
 * Developed by Joshua Weigand, Wellington Rodrigues, Quaid Quintela
 * 				Daniel Molano, and Lane Burris
 *
 */
public class main {

	// Windows Setup - Scaling
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static final int SCALE = 1;

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		// Model & View Declarations
		Model model = new Model();
		View view = new View(model);

		// Set/Lock Window Preferences
		view.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		view.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		view.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		// Timer Declarations
		GameTimer gametimer = new GameTimer(model, view);
		ReloadTimer reloadtimer = new ReloadTimer(model, view);

		// Creates Frame & Initializes Graphics
		model.visualize(view);

		// Start - Game Timer(s)
		new Timer(1000, gametimer).start();
		new Timer(16, reloadtimer).start();
	}
}
