package MainPackage;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    public Handler handler;
    private Camera camera;

    private BufferedImage map = null;
    private BufferedImage spriteSheet=null;

    public Game(){
        new Window(1000 , 563 , "Grave and Yellow" , this);
        start();
        handler = new Handler();
        camera = new Camera(0,0);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler,camera));

        BufferedImageLoader loader = new BufferedImageLoader();
        map = loader.loadImage("assets/Map.png");

        loadLevel(map);
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

        for (int i =0; i < handler.operatableObjects.size(); i++)
        {
            if (handler.operatableObjects.get(i).getId() == ID.Player)
            camera.tick(handler.operatableObjects.get(i));
        }

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
        Graphics2D g2d = (Graphics2D)g;
        //////////////////////////////////
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,1000,563);

        g2d.translate(-camera.getX(),-camera.getY());

        handler.render(g);

        g2d.translate(camera.getX(),camera.getY());

        //////////////////////////////////

        g.dispose();
        bs.show();
    }

    private void loadLevel(BufferedImage image)
    {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int x = 0; x < w; x++)
            for (int y = 0; y<h;y++)
            {
                int pixel = image.getRGB(x,y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;


                if(blue == 255)
                    handler.addObject(new Rock(x*32,y*32,ID.Rock));

                if (green == 255)
                    handler.addObject(new MainHero(x*32,y*32,ID.Player,handler));

                if (red == 255)
                    handler.addObject(new MeeleEnemy(x*32,y*32,ID.Enemy,handler));
            }
    }



}
