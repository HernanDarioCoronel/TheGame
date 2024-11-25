package Main.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.GOType;

public abstract class GameObject {

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public void addXVelocity(float velocity) {
		this.xPos += velocity;
	}

	public void addYVelocity(float velocity) {
		this.yPos += velocity;
	}

	public GOType getId() {
		return id;
	}

	public void setId(GOType id) {
		this.id = id;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	protected float xPos, yPos;
	protected float velX, velY;
	protected float velocity;

	protected float width, height;

	protected GOType id;

	public GameObject(float xInitPos, float yInitPos, float width, float height, float velocity, GOType id) {
		this.xPos = xInitPos;
		this.yPos = yInitPos;
		this.width = width;
		this.height = height;
		this.velocity = velocity;
		this.id = id;
	}

	public void tick() {
		xPos += velX;
		yPos += velY;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) this.xPos, (int) this.yPos, (int)this.width, (int)this.height);
	}

	public abstract void render(Graphics g);

}
