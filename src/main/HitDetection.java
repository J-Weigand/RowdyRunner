package main;

/**
 * Manages the mechanism to detect a player hitting one of the blocks as they go
 * down.
 */
public class HitDetection {

	// Variable Declarations
	public double eSize;
	public double eSize2;
	public boolean hitDetect = false;
	Entity entity;
	Entity entity2;
	Model model;

	/**
	 * <<constructor>>
	 * 
	 * @param model
	 */
	public HitDetection(Model model) {
		this.eSize = model.c.getSize();
		this.eSize2 = model.c2.getSize();
		this.model = model;
	}

	/**
	 * Will check for hit of block except for the
	 * 
	 * @param blockX
	 *            position of the box in the x axis
	 * @param blockY
	 *            position of the box in the y axis
	 * @param playerX
	 *            position of the player in the x axis
	 * @param playerY
	 *            position of the player in the Y axis
	 */
	public boolean tick(double blockX, double blockY, double playerX, double playerY) {

		if ((blockY >= playerY + 64)) {
			return false;
		}
		if ((blockX <= playerX && blockX >= playerX - 10 && blockY >= playerY - 30)
				|| (blockX >= playerX && blockX <= playerX + 42 && blockY >= playerY - 30)) {
			model.pause = true;
			model.over = true;
		}
		return true;
	}

	/**
	 * Render the position of the block and the player. calls tick to test for
	 * hit.
	 * 
	 * @param p
	 * @param c
	 */
	public void render() {
		for (int i = 0; i < eSize; i++) {
			entity = model.c.get(i);
			tick(entity.getX(), entity.getY(), model.p.x, model.p.y);
		}
		for (int i = 0; i < eSize2; i++) {
			entity2 = model.c2.get(i);
			tick(entity2.getX(), entity2.getY(), model.p.x, model.p.y);
		}
	}
}
