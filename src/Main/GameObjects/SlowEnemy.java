package Main.GameObjects;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.Handler;
import Main.IdEnum;
import Main.SpeedEnum;

public class SlowEnemy extends GameObject {

	private Handler handler;

	public SlowEnemy(int xInitPos, int yInitPos, Handler handler) {
		super(xInitPos, yInitPos, 20, 20, SpeedEnum.Slow.getValue(), IdEnum.SlowEnemy);
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

		handler.addObject(new Trail(this.xPos, this.yPos, this.width, this.height, this.velocity, IdEnum.Trail,
				this.handler, new Color(154, 115, 250), 0.01f));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(95, 80, 199));
		g.fillRect(this.xPos, this.yPos, this.width, this.height);

	}

}
