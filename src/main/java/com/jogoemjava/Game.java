package com.jogoemjava;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    public static JFrame frame;
    private Thread thread;
    private boolean isRunning = true;
    private final int WIDTH = 160;
    private final int HEIGHT = 120;
    private final int SCALE = 4;

    private BufferedImage image;
    private Spritesheet sheet;
    private BufferedImage[] player;
    private int frames = 0;
    private int maxFrames = 20;
    private int curAnimation = 0, maxAnimation = 2;

    //Construtor
    public Game() {
        sheet = new Spritesheet("/spritesheet.png");
        player = new BufferedImage[2];
        player[0] = sheet.getSprite(0,0,16,16);
        player[1] = sheet.getSprite(16,0,16,16);
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    private void initFrame() {
        frame = new JFrame("Game #1");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void tick() {
        frames++;
        if(frames>maxFrames){
            frames = 0;
            curAnimation++;
            if (curAnimation >= maxAnimation){
                curAnimation = 0;
            }
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();

        g.setColor(new Color(88, 159, 71));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //Renderização do jogo
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(player[curAnimation],20,20,null);
        // ---------------
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        bs.show();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double quantidadeDeTicks = 60.0; //FPS desejado.
        double umSegundo = 1000000000;
        double tempoDeUmTick = umSegundo / quantidadeDeTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / tempoDeUmTick;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS " + frames);
                frames = 0;
                timer += 1000;
            }
        }
        stop();

    }
}
