package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Responsible for interpreting key presses and releases.
 * 
 * @author Team 2
 *
 */
public class KeyController extends KeyAdapter implements KeyListener {

	// Variable Declaration(s)
	Model model;

	/**
	 * <<Constructor>>
	 * 
	 * @param model
	 */
	public KeyController(Model model) {
		this.model = model;
	}

	/**
	 * Key Bindings (Start) + Identifies when arrow keys are PRESSED
	 */
	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (model.getState() == 1 || model.getState() == 6 || model.getState() == 7) {
			if (key == KeyEvent.VK_RIGHT) {
				model.p.setVelX(5);
			} else if (key == KeyEvent.VK_LEFT) {
				model.p.setVelX(-5);
			} else if (key == KeyEvent.VK_DOWN) {
				model.p.setVelY(5);
			} else if (key == KeyEvent.VK_UP) {
				model.p.setVelY(-5);
			} else if (key == KeyEvent.VK_ESCAPE) {
				// click escape while playing will pause
				if (model.pause == false) {
					model.pause = true;
				}
				// if game over will stay "paused" *bug fix*
				else if (model.State == model.State.pMenu || model.pause == true && model.over == true) {
					model.pause = true;
				}
				// if paused will resume
				else {
					model.pause = false;
				}
			} else if (key == KeyEvent.VK_S) {
				model.State = model.State.sMenu;
			}
		}
	}

	/**
	 * Key Bindings (Stop) + Identifies when arrow keys are RELEASED
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (model.getState() == 1 || model.getState() == 6 || model.getState() == 7) {
			if (key == KeyEvent.VK_RIGHT) {
				model.p.setVelX(0);
			} else if (key == KeyEvent.VK_LEFT) {
				model.p.setVelX(0);
			} else if (key == KeyEvent.VK_DOWN) {
				model.p.setVelY(0);
			} else if (key == KeyEvent.VK_UP) {
				model.p.setVelY(0);
			}
		}
	}
}
