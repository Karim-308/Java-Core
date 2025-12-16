package lab8;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BouncingClock extends JPanel {
    
    private int x = 100;
    private int y = 100;
    private int deltaX = 2;  
    private int deltaY = 2;  
   
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    
    public BouncingClock() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLUE);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        
        String time = dateFormat.format(new Date());
        g.drawString(time, x, y);
    }
    
    public void updatePosition() {
       
        x += deltaX;
        y += deltaY;
        
        
        int textWidth = 350;  
        int textHeight = 20;
        
        // Bounce off edges
        if (x <= 0 || x + textWidth >= getWidth()) {
            deltaX = -deltaX;  // reverse horizontal 
        }
        
        if (y <= textHeight || y >= getHeight()) {
            deltaY = -deltaY;  // reverse vertical
        }
        repaint();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BouncingClock clock = new BouncingClock();
        frame.add(clock);
        frame.pack();
        frame.setVisible(true);
        
        Thread animationThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50); 
                    clock.updatePosition();  //  Update position
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        animationThread.start(); 
    }
}