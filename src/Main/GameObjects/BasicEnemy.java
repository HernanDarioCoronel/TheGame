package Main.GameObjects;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.GOType;
import Main.SpeedEnum;

public class BasicEnemy extends GameObject {

	private Handler handler;

	public BasicEnemy(float xInitPos, float yInitPos, Handler handler) {
		super(xInitPos, yInitPos, 16.0f, 16.0f, SpeedEnum.Normal.getValue(), GOType.BasicEnemy);
		this.velX = velocity;
		this.velY = velocity;
		this.handler = handler;

	}

	public void tick() {
		super.tick();

		if (this.yPos <= 0 || this.yPos > Game.HEIGHT - this.height) {
			this.velY *= -1;
		}
		if (this.xPos <= 0 || this.xPos > Game.WIDTH - this.width) {
			this.velX *= -1;
		}

		handler.addObject(new Trail(this.xPos, this.yPos, this.width, this.height, this.velocity, this.handler,
				new Color(230, 69, 69), 0.01f));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) this.xPos, (int) this.yPos, (int) this.width, (int) this.height);

	}

}
