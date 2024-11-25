package Main.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.IdEnum;

public abstract class GameObject {

	protected int xPos, yPos;
	protected int width, height;
	protected int velocity;

	protected IdEnum id;
	protected int velX, velY;

	public GameObject(int xInitPos, int yInitPos, int width, int height, int velocity, IdEnum id) {
		this.xPos = xInitPos;
		this.yPos = yInitPos;
		this.width = width;
		this.height = height;
		this.velocity = velocity;
		this.id = id;
	}

	public GameObject(int xInitPos, int yInitPos, double width, double height, int velocity, IdEnum id) {
		this.xPos = xInitPos;
		this.yPos = yInitPos;
		setWidth(width);
		setHeight(height);
		this.velocity = velocity;
		this.id = id;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setWidth(double width) {
		this.width = (int) width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHeight(double height) {
		this.height = (int) height;
	}

	public IdEnum getId() {
		return id;
	}

	public void setId(IdEnum id) {
		this.id = id;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public void tick() {
		xPos += velX;
		yPos += velY;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.xPos, this.yPos, this.width, this.height);
	}

	public abstract void render(Graphics g);

}
