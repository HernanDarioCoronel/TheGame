package Main.GameObjects;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.GOType;
import Main.SpeedEnum;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;

	public SmartEnemy(float xInitPos, float yInitPos, Handler handler) {
		super(xInitPos, yInitPos, 20, 20, SpeedEnum.VerySlow.getValue(), GOType.SmartEnemy);
		this.velX = this.velocity;
		this.velY = this.velocity;
		this.handler = handler;
		this.player = handler.objectList.get(0);
	}

	public void tick() {
		super.tick();

		float directionX = this.player.getxPos() - this.xPos;
		float directionY = this.player.getyPos() - this.yPos;

		float distance = (float) Math.sqrt(directionX * directionX + directionY * directionY);

		if (distance != 0) {
			directionX /= distance;
			directionY /= distance;
		}

		this.xPos += directionX * this.velocity;
		this.yPos += directionY * this.velocity;

		this.velX = (int) ((-1.0 / distance) * directionX);
		this.velY = (int) ((-1.0 / distance) * directionY);

		if (this.yPos <= 0 || this.yPos > Game.HEIGHT - this.height) {
			this.velY *= -1;
		}
		if (this.xPos <= 0 || this.xPos > Game.WIDTH - this.width) {
			this.velX *= -1;
		}

		handler.addObject(new Trail(this.xPos, this.yPos, this.width, this.height, this.velocity, this.handler,
				new Color(154, 115, 250), 0.01f));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(95, 80, 199));
		g.fillRect((int) this.xPos, (int) this.yPos, (int) this.width, (int) this.height);

	}

}
