package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * View assumes full control of all graphic rendering. Frames, Backgrounds,
 * Spritesheet(s), and their sprites are loaded here.
 */
@SuppressWarnings("serial")
public class View extends Canvas {

	// Variable Declarations
	public BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public final String TITLE = "RowdyRunner";
	private BufferedImage desert = null;
	private BufferedImage water = null;
	private BufferedImage space = null;
	public BufferedImage menu_d = null;
	public BufferedImage menu_w = null;
	public BufferedImage menu_s = null;
	public BufferedImage startmenu_d = null;
	public BufferedImage startmenu_w = null;
	public BufferedImage startmenu_s = null;
	public BufferedImage levelmenu_d = null;
	public BufferedImage levelmenu_w = null;
	public BufferedImage levelmenu_s = null;
	public BufferedImage genericMenu = null;
	public BufferedImage genericStart = null;
	public BufferedImage genericLevel = null;
	private BufferedImage spriteSheet = null;
	Model model;

	/**
	 * Constructor: View
	 * 
	 * @param model
	 */
	public View(Model model) {
		this.model = model;
	}

	/**
	 * The following method solemnly manages and initializes the JFrame window.
	 * + Adds game title + Sets default close operations + Forces window not to
	 * be resizable
	 */
	public void initPanel() {
		JFrame frame = new JFrame(TITLE);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Initializes Program: + Loads Background and Characters from resources +
	 * Sets Key Listeners (Keyboard input) + Sets initial Player Start Position
	 */
	public void initialize() {

		requestFocus(); // Avoids having to click in box for key entry

		// Graphic Loading - from resources folder
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/sprite_sheet.png");
			desert = loader.loadImage("/Desert.png");
			water = loader.loadImage("/Water.png");
			space = loader.loadImage("/Space.png");
			startmenu_d = loader.loadImage("/dStart.png");
			startmenu_w = loader.loadImage("/wStart.png");
			startmenu_s = loader.loadImage("/sStart.png");
			levelmenu_d = loader.loadImage("/dLevel.png");
			levelmenu_w = loader.loadImage("/wLevel.png");
			levelmenu_s = loader.loadImage("/sLevel.png");
			menu_d = loader.loadImage("/dMenu.png");
			menu_w = loader.loadImage("/wMenu.png");
			menu_s = loader.loadImage("/sMenu.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		addMouseListener(new MouseController(model, this));
		addKeyListener(new KeyController(model));
		model.tex = new Textures(this);
		model.p = new Player(475, 700, model.tex);
		model.c = new Controller(model.tex);
		model.c2 = new Controller(model.tex);
		model.h = new HitDetection(model);
		model.sMenu = new sMenu();
		model.pMenu = new pMenu();
		model.lvlMenu = new lvlMenu();
		model.hMenu = new hMenu();
		model.gameover = new Gameover();
		genericMenu = menu_d;
		genericLevel = levelmenu_d;
		genericStart = startmenu_d;
	}

	/**
	 * Updates and calls associated classes to render graphics + Responsible for
	 * enabling Multi-Buffering Strategies - Triple Buffering + Renders
	 * background images (Menu/Game) , player, and block graphics
	 */
	@SuppressWarnings("static-access")
	public void render() {

		// Buffer Strategy increases rendering speed/performance
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // Buffer Multiplier
			return;
		}

		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		// Generate Game
		if (model.State == model.State.dGame) {
			// grabs the desert player from the sprite sheet
			// desert player is identified by 1 in the second argument of
			// grabImage
			genericStart = startmenu_d;
			genericMenu = menu_d;
			g.drawImage(desert, 0, 0, null);
			model.tex.player = model.tex.ss.grabImage(1, 1, 64, 64);
			model.p.render(g, model.tex);
			model.c.render(g);
			model.c2.render(g);
			model.h.render();

		}
		if (model.State == model.State.wGame) {
			// grabs the water player from the sprite sheet
			// water player is identified by 7 in the second argument of
			// grabImage
			genericStart = startmenu_w;
			genericMenu = menu_w;
			g.drawImage(water, 0, 0, null);
			model.tex.player = model.tex.ss.grabImage(1, 7, 64, 64);
			model.p.render(g, model.tex);
			model.c.render(g);
			model.c2.render(g);
			model.h.render();
		}
		if (model.State == model.State.sGame) {
			genericStart = startmenu_s;
			genericMenu = menu_s;
			g.drawImage(space, 0, 0, null);
			// grabs the space player from the sprite sheet
			// space player is identified by 4 in the second argument of
			// grabImage
			model.tex.player = model.tex.ss.grabImage(1, 4, 64, 64);
			model.p.render(g, model.tex);
			model.c.render(g);
			model.c2.render(g);
			model.h.render();
		}
		// Generate Pause Menu
		if (model.pause == true && model.over != true) {
			// g.drawImage(genericLevel, 0, 0, null);
			model.pMenu.render(g);
		}
		// Generate Start Menu
		if (model.State == model.State.sMenu) {
			g.drawImage(genericStart, 0, 0, null);
			model.sMenu.render(g);
		}
		// Generate Level Menu
		if (model.State == model.State.lvlMenu) {
			g.drawImage(genericLevel, 0, 0, null);
			model.lvlMenu.render(g);
		}
		// Generate Help Menu
		if (model.State == model.State.hMenu) {
			g.drawImage(genericMenu, 0, 0, null);
			model.hMenu.render(g);
		}

		if (model.pause == true && model.over == true) {
			model.gameover.render(g);
		}

		//////////////////////////////////
		g.dispose();
		bs.show();
	}

	/**
	 * Getter to return the SpriteSheet to be used in render()
	 */
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
}
