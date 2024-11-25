package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Main.GameObjects.GameObject;

public class KeyInput extends KeyAdapter {

	private final GameObject player;

	public KeyInput(GameObject player) {
		this.player = player;
	}
	
	public void keyTyped(KeyEvent e) {keyPressed(e);}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		float velocity = this.player.getVelocity();

		if (key == KeyEvent.VK_W) {
			this.player.addYVelocity(-velocity);
		}
		if (key == KeyEvent.VK_S) {
			this.player.addYVelocity(velocity);
		}
		if (key == KeyEvent.VK_A) {
			this.player.addXVelocity(-velocity);
		}
		if (key == KeyEvent.VK_D) {
			this.player.addXVelocity(velocity);
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_RIGHT) {
			this.player.setVelX(0);
		}else if(key == KeyEvent.VK_LEFT) {
			this.player.setVelX(0);
		}else if(key == KeyEvent.VK_DOWN) {
			this.player.setVelY(0);
		}else if(key == KeyEvent.VK_UP) {
			this.player.setVelY(0);
		}
	}

}
