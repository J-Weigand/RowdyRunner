package main;

/**
 * Super Class designed to set x and y variables for
 * all game objects (player, blocks)
 */
public class Object {
	
	//Variable Declaration
	public double x, y;
	
	/**
	 * Constructor: Object
	 * @param x
	 * @param y
	 */
	public Object (double x, double y){
		this.x = x;
		this.y = y;
	}
}
