package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class Sprite.
 *
 * @author Pierre GARRIDO
 */
public class Sprite {

	/**
	 * Variable declarations.
	 */
	private Image spriteImage;
	private char baseIcon;
	private String fileName;

	/**
	 * Instantiates a new sprite.
	 *
	 * @param icon;
	 * 			The icon's picture.
	 * @param file;
	 * 			The file path.
	 */
	public Sprite(char icon, String file) {
		this.baseIcon = icon;
		this.fileName = file;
		
		try {
			this.spriteImage = ImageIO.read(new File(this.fileName));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to open and read the given file");
		}
	}

	/**
	 * Gets the Image.
	 *
	 * @return The image (the sprite).
	 */
	public Image getImage() {
		return this.spriteImage;
	}

	/**
	 * Gets the icon.
	 *
	 * @return the icon.
	 */
	public char getIcon() {
		return this.baseIcon;
	}
}
