package com.base.engine;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;


/**
 * This class stores functions in a package for ease of use and funneling
 *
 */
public class Store {

	public static final int WIDTH = 1280, HEIGHT = 960;

	/**
	 * Create a window 800x600 for the game to run in
	 */
	public static void BeginSession() {
		Display.setTitle("JRPG GAME");
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			Keyboard.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,WIDTH,HEIGHT,0,1,-1);  // 1,-1 is 3d disable
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);

	}

	/**
	 * Draws the overworld with tiles
	 */

	public static void DrawQuad(float x, float y, float width, float height)
	{
		glBegin(GL_QUADS);
		glVertex2f(x,y);
		glVertex2f(x+width,y);
		glVertex2f(x+width,y+height);
		glVertex2f(x,y+height);
		glEnd();
	}

	/**
	 * Renders all the tiles drawn
	 */

	public static void DrawQuadTex(Texture tex,float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x,y,0); // 0 is for 3d
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1,1);
		glVertex2f(width,height);
		glTexCoord2f(0,1);
		glVertex2f(0,height);
		glEnd();
		glLoadIdentity();
	}

	/**
	 * Load the texture from a specific path and
	 * @return Texture
	 */

	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}

	/**
	 * Load the texture from a quick path
	 * @return Texture
	 */

	public static Texture QuickLoad(String name) {
		Texture tex = null;
		tex = LoadTexture("com/base/Resources/"+ name + ".png","PNG");
		return tex;
	}

}
