package main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 * Responsible for the generation and deletion of all the elements within the
 * game window.
 */
public class Controller {

	// Variable CLass Declarations
	private LinkedList<Entity> e = new LinkedList<Entity>();
	Entity entity;
	Random r = new Random();

	/**
	 * Generates a line of 20 at a single time
	 * 
	 * @param tex
	 */
	public Controller(Textures tex) {
		for (int x = 0; x < 25; x++) {

			addEntity(new Block(r.nextInt(1024), 10, tex));
		}
	}

	/**
	 * Adds Blocks to the entity array
	 * 
	 * @param entity
	 */
	private void addEntity(Entity entity) {
		e.add(entity);
	}

	/**
	 * Removes blocks from the entity array
	 * 
	 * @param entity
	 */
	public void removeEntity(Entity entity) {
		e.remove(entity);
	}

	/**
	 * Cycles entity array and and updates the location of each block and
	 * character +Completely Random based on the size of the window
	 */
	public void tick() {
		for (int i = 0; i < e.size(); i++) {
			entity = e.get(i);
			entity.tick();
		}
	}

	/**
	 * Graphic Rendering for blocks and characters generated in the array
	 * 
	 * @param g
	 * @param model
	 */
	public void render(Graphics g) {
		for (int j = 0; j < e.size(); j++) {
			entity = e.get(j);
			entity.render(g);
		}
	}

	/**
	 * 
	 * @return size of the array of blocks
	 */
	public double getSize() {
		return e.size();
	}

	/**
	 * 
	 * @param i
	 *            get block in position i from list.
	 * @return return block
	 */
	public Entity get(int i) {
		return e.get(i);
	}
}
