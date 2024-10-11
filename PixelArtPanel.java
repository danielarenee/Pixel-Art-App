package frames;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class PixelArtPanel extends JPanel implements MouseListener, MouseMotionListener, ChangeListener {

    private BufferedImage image;
    private Graphics2D g2d;
    public Color currentColor; 
    private int cellSize = 20; 
    public JPanel colorIndicatorPanel;
    private ColorManager colorManager;


    public PixelArtPanel(ColorManager colorManager) {
    	 this.colorManager = colorManager;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
        
        image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.BLACK); 
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        
        g2d.setColor(currentColor);
        
      
       
        for (int x = 0; x <= getWidth(); x += cellSize) {
            g.drawLine(x, 0, x, getHeight());
        }
        for (int y = 0; y <= getHeight(); y += cellSize) {
            g.drawLine(0, y, getWidth(), y);
        }
    }
    
    public BufferedImage getImage() {
        return image;
    }
    
    public void setCurrentColor(Color color ) {
    	 colorManager.setCurrentColor(color);
         repaint(); 
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
    	int x = (int) (Math.floor((double)e.getX() / cellSize) * cellSize);
        int y = (int) (Math.floor((double)e.getY() / cellSize) * cellSize);
        g2d.setColor(colorManager.getCurrentColor()); 
        g2d.fillRect(x, y, cellSize, cellSize);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	int x = (int) (Math.floor((double)e.getX() / cellSize) * cellSize);
        int y = (int) (Math.floor((double)e.getY() / cellSize) * cellSize);
        g2d.setColor(colorManager.getCurrentColor()); 
        g2d.fillRect(x, y, cellSize, cellSize);
        repaint();
    }
    

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void stateChanged(ChangeEvent e) {}

    
}