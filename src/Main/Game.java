package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.Serial;
import java.util.Random;

import Main.GameObjects.BasicEnemy;
import Main.GameObjects.Player;

public class Game extends Canvas implements Runnable {

    @Serial
    private static final long serialVersionUID = -1285670934175365101L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = (int) ((double) WIDTH / 12 * 9);

    private Thread thread;
    private boolean running = false;
    private final HUD hud;
    private final Spawn spawn;

    private final Handler handler;

    public Game() {
        // window inicialization
        handler = new Handler();
        Random rnd = new Random();

        new Window(WIDTH, HEIGHT, "The Game", this);

        hud = new HUD();
        spawn = new Spawn(handler, hud);

        Player player1 = new Player((float) WIDTH / 2 - 32, (float) HEIGHT / 2 - 32, 32, 32, SpeedEnum.VeryFast.getValue(), handler);

        handler.addObject(player1);

        handler.addObject(new BasicEnemy(rnd.nextInt(0, WIDTH), rnd.nextInt(0, HEIGHT), handler));

        this.addKeyListener(new KeyInput(player1));
    }

    public static void main(String[] args) {
        // instancing a game
        new Game();
    }

    public void run() {
        // game loop
        this.requestFocus();
        long lastTime = System.nanoTime();
        final double TARGET_FRAMERATE = 60.0;
        final double OPTIMAL_FRAMERATE = 1000000000 / TARGET_FRAMERATE;
        double delta = 0;
        long timer = System.currentTimeMillis();
        //int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / OPTIMAL_FRAMERATE;
            lastTime = now;
            while (delta >= 1) {
                this.tick();
                delta--;
            }
            if (running) {
                render();
            }
            //frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                // showing frames
                timer += 1000;
                //frames = 0;

            }
            /*
			if (HUD.HEALTH == 0) {
				// stop();
			}*/
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.gray);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    private void tick() {
        handler.tick();
        hud.tick();
        spawn.tick();
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void start() {
        this.thread = new Thread(this);
        thread.start();
        running = true;
    }

    public static double clamp(double var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }
}
