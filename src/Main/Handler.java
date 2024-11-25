package Main;

import java.awt.Graphics;
import java.util.LinkedList;

import Main.GameObjects.GameObject;

public class Handler {

	public LinkedList<GameObject> objectList;

	public Handler() {
		objectList = new LinkedList<>();
	}

	public void removeObject(GameObject obj) {
		this.objectList.remove(obj);
	}

	public void addObject(GameObject obj) {
		this.objectList.add(obj);
	}

	public void tick() {
		for (int i = 0; i < objectList.size(); i++) {
			GameObject tempObject = objectList.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < objectList.size(); i++) {
			GameObject tempObject = objectList.get(i);
			tempObject.render(g);
		}

	}
}
