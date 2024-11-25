package Main.GameObjects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Main.Handler;
import Main.IdEnum;

public class Trail extends GameObject {

	private float alpha = 1;
	Handler handler;
	Color color;
	private float life;
	private static final float MODIFIER = 0.99999999f;

	public Trail(int xInitPos, int yInitPos, int width, int height, int velocity, IdEnum id, Handler handler,
			Color color, float life) {
		super(xInitPos, yInitPos, width * MODIFIER, height * MODIFIER, velocity, id);
		this.handler = handler;
		this.color = color;
		this.life = life;
	}

	@Override
	public void tick() {
		super.tick();
		if (alpha > life) {
			alpha -= life - 0.0001f;
			setWidth(this.width * MODIFIER);
			setHeight(this.height * MODIFIER);
		} else {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));

		g.setColor(this.color);
		g2d.fill(getBounds());

		g2d.setComposite(makeTransparent(1));
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	}

}