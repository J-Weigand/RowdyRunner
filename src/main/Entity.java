package main;

import java.awt.Graphics;

/**
 * Interface class that eliminates the need for lengthy
 * add and delete methods in the controller class.
 */
public interface Entity {
	
	public double getX();
	public double getY();
	
	public void tick();
	public void render (Graphics g);
}
