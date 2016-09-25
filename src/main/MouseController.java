package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * MouseController implements MouseListener and takes appropriate action for
 * each mouse event
 */
public class MouseController implements MouseListener {
	
	// Variable Declarations
	Model model;
	View view;

	/**
	 * <<constructor>>
	 * 
	 * @param model
	 * @param view
	 */
	public MouseController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Mouse event handler
	 */
	@SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e) {

		// Variable Declaration
		int x = e.getX();
		int y = e.getY();

		// Start Menu - Options
		if (model.State == model.State.sMenu) {
			model.resetTimer = true;
			if (x >= main.WIDTH / 9 + 100 && x <= main.WIDTH / 9 + 200) {
				// Start button
				if (y >= 250 && y <= 300) {
					model.State = model.State.lvlMenu;
				}
				// Help button
				else if (y >= 350 && y <= 400) {
					model.State = model.State.hMenu;
				}
				// Quit button
				else if (y >= 450 && y <= 500) {
					System.exit(0);
				}
				if (x >= main.WIDTH / 9 + 100 && x <= main.WIDTH / 9 + 200) {
					// Theme Button (Easter Egg)
					if (y >= 550 && y <= 600) {
						if (view.genericStart == view.startmenu_d) {
							view.genericMenu = view.menu_w;
							view.genericStart = view.startmenu_w;
							view.genericLevel = view.levelmenu_w;
						} else if (view.genericStart == view.startmenu_w) {
							view.genericMenu = view.menu_s;
							view.genericStart = view.startmenu_s;
							view.genericLevel = view.levelmenu_s;
						} else if (view.genericStart == view.startmenu_s) {
							view.genericMenu = view.menu_d;
							view.genericStart = view.startmenu_d;
							view.genericLevel = view.levelmenu_d;
						}
					}
				}

			}
		}
		
		// Level menu
		if (model.State == model.State.lvlMenu) {
			model.resetTimer = true;
			if (x >= 58 && x <= main.WIDTH / 9 + 60) {
				if (y >= 650 && y <= 700) {
					model.State = model.State.sMenu;
				}
			}
			if (y >= 300 && y <= 515) {
				if (x >= 70 && x <= 325) {
					model.State = model.State.dGame;
				} else if (x >= 384 && x <= 639) {
					model.State = model.State.wGame;
				} else if (x >= 698 && x <= 953) {
					model.State = model.State.sGame;

				}
			}
		}

		// Help Menu
		if (model.State == model.State.hMenu) {
			model.resetTimer = true;
			if (x >= 58 && x <= main.WIDTH / 9 + 60) {
				if (y >= 650 && y <= 700) {
					model.State = model.State.sMenu;
				}
			}
		}
		
		// Game Over
		if (model.State == model.State.pMenu || model.pause == true && model.over == true) {
			model.resetTimer = true;
			model.over = false;
			model.pause = false;
			model.p.x = 512;
			model.p.y = 768;
			model.tickcontrol = 0;
			model.c = new Controller(model.tex);
			model.c2 = new Controller(model.tex);
			if (x >= main.WIDTH / 9 + 320 && x <= main.WIDTH / 9 + 470) {
				// Retry button
				if (y >= 250 && y <= 305) {
					model.over = false;
					model.pause = false;
					model.State = model.State.lvlMenu;
				} else if (y >= 350 && y <= 405) {
					model.State = model.State.sMenu;
				// Quit button
				} else if (y >= 450 && y <= 505) {
					System.exit(0);
				}
			}
		}

		// Pause Menu - Options
		if (model.State == model.State.pMenu || model.pause == true && model.over == false) {
			if (x >= main.WIDTH / 3 + 90 && x <= main.WIDTH / 3 + 240) {
				// Resume button
				if (y >= 250 && y <= 300) {
					model.pause = false;
				}
				// Quit button
				else if (y >= 350 && y <= 400) {
					System.exit(0);
				}
			}
		}
	}

	/**
	 * Un-Used
	 * Needed to fulfill MouseListener Requirement
	 */
	public void mouseClicked(MouseEvent e) {
	}
	/**
	 * Needed to fulfill MouseListener Requirement
	 */
	public void mouseReleased(MouseEvent e) {
	}
	/**
	 * Needed to fulfill MouseListener Requirement
	 */
	public void mouseEntered(MouseEvent e) {
	}
	/**
	 * Needed to fulfill MouseListener Requirement
	 */
	public void mouseExited(MouseEvent e) {
	}
}
