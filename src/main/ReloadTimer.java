package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ReloadTimer takes in an incoming event and updates the tick and render method
 * accordingly. This allows the game to refresh the render rate at 60FPS.
 */
public class ReloadTimer implements ActionListener {

	// Variable Declarations
	Model model;
	View view;
	public int i = 0;

	/**
	 * Constructor: ReloadTimer
	 * 
	 * @param model
	 * @param view
	 */
	public ReloadTimer(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Takes an incoming event that needs to be updated and rendered
	 */
	public void actionPerformed(ActionEvent event) {
		model.tick();
		view.render();
	}
}
