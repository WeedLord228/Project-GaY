package MainPackage;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    public Handler handler;

    public Game(){
        new Window(1000 , 563 , "Grave and Yellow" , this);
        start();
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        handler.addObject(new Main_hero(100 , 100 , ID.Player , handler));
    }

    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg){
        new Game();
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 /amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while (delta>=1){
                tick();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer >1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick(){
        handler.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            //метод подготовки данных, обеспечивающий возможность отдачи
            //готового результата без прерывания процесса подготовки следующего результата.
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //////////////////////////////////

        g.setColor(Color.ORANGE);
        g.fillRect(0,0,1000,563);
        handler.render(g);

        //////////////////////////////////

        g.dispose();
        bs.show();
    }


}
