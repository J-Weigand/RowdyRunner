package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GameTimer contains the timing variables that are used in the scoring system.
 * It will update the game timer to reflect the current game state (Game/Menu).
 * This will directly effect the scoring system used in RowdyRunner.
 */
public class GameTimer implements ActionListener {

	// Variable Declarations
	int sec = 0;
	int min = 0;
	int hour = 0;
	Model model;
	View view;
	int count;
	public int level;

	/**
	 * Constructor: GameTimer
	 * 
	 * @param model
	 * @param view
	 */
	public GameTimer(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * The following method starts the game timer once the game state has been
	 * changed to the game state (1)
	 */
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent event) {
		if ((model.pause == false) && ((model.State == model.State.sGame) || (model.State == model.State.dGame)
				|| (model.State == model.State.wGame))) {
			timer();
		}
	}

	/**
	 * The following method allows the console output to reflect a time interval
	 * based on Hours:Minutes:Seconds. //increasing level every 10 seconds.
	 */
	public void timer() {
		if (model.resetTimer == true) {
			sec = 0;
			min = 0;
			hour = 0;
			model.resetTimer = false;
		}
		System.out.println(hour + " hours " + min + " minutes " + sec + " seconds");
		if (hour == 0 && min == 0 && sec == 0) {
			level = 0;
		}

		if (sec != 0 && sec % 10 == 0) {
			count++;
			// System.out.println("Level: " + level);

			if (count == 1) {
				count = 0;
				level++;
				System.out.println("Level: " + (level));
			}
		}

		sec++;
		if (sec % 60 == 0) {
			sec = 0;
			min++;
		}
		if (min % 60 == 0 && min != 0) {
			min = 0;
			hour++;
		}
	}
}
