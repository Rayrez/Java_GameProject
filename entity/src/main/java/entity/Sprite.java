package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private Image spriteImage;
	private char baseIcon;
	private String fileName;
	
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
	
	public Image getImage() {
		return this.spriteImage;
	}
	
	public char getIcon() {
		return this.baseIcon;
	}
}
