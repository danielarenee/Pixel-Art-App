package frames;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel implements ActionListener, ChangeListener {

	public PixelArtPanel pixelArtPanel;
    // Sliders
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    private JLabel redValueLabel;
    private JLabel greenValueLabel;
    private JLabel blueValueLabel;
    private JLabel RLabel;
    private JLabel GLabel;
    private JLabel BLabel;


    private JButton black;
    private JButton blue;
    private JButton green;
    private JButton orange;
    private JButton pink;
    private JButton red;
    private JButton white;
    private JButton yellow;
    private JLabel predet;
    private ColorManager colorManager; 


    private JPanel colorIndicatorPanel;

    public Color currentColor;

    public ColorPanel(PixelArtPanel pixelArtPanel, ColorManager colorManager) {
    	 this.colorManager = colorManager; 
    	this.pixelArtPanel = pixelArtPanel;
    	 currentColor = Color.BLACK;
    	 colorIndicatorPanel = new JPanel(); 
    	 
    }

    public JPanel createColorPanel() {
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(null);
        
        colorPanel.setBounds(0, 0, 1000, 500); 

        // SLIDERS
        redSlider = new JSlider(0, 255);
        greenSlider = new JSlider(0, 255);
        blueSlider = new JSlider(0, 255);

        redSlider.setBounds(55, 45, 255, 35);
        greenSlider.setBounds(55, 65, 255, 35);
        blueSlider.setBounds(55, 25, 255, 35);
        
        redSlider.addChangeListener(this);
        greenSlider.addChangeListener(this);
        blueSlider.addChangeListener(this);

        colorPanel.add(redSlider);
        colorPanel.add(greenSlider);
        colorPanel.add(blueSlider);

        // SLIDER LABELS
        JLabel redLabel = new JLabel("Red:");
        JLabel greenLabel = new JLabel("Green:");
        JLabel blueLabel = new JLabel("Blue:");

        redLabel.setBounds(15, 50, 40, 20);
        greenLabel.setBounds(15, 70, 40, 20);
        blueLabel.setBounds(15, 30, 40, 20);

        colorPanel.add(redLabel);
        colorPanel.add(greenLabel);
        colorPanel.add(blueLabel);

        // SLIDERS NUMERIC VALUE
        redValueLabel = new JLabel("0");
        greenValueLabel = new JLabel("0");
        blueValueLabel = new JLabel("0");

        redValueLabel.setBounds(50, 140, 40, 20);
        greenValueLabel.setBounds(90, 140, 40, 20);
        blueValueLabel.setBounds(130, 140, 40, 20);

        colorPanel.add(redValueLabel);
        colorPanel.add(greenValueLabel);
        colorPanel.add(blueValueLabel);
        
        //RGB LABEL
        RLabel = new JLabel("R");
        RLabel.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        GLabel = new JLabel("G");
        GLabel.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        BLabel = new JLabel("B");
        BLabel.setFont(new Font("Lucida Sans", Font.BOLD, 15));

        RLabel.setBounds(50, 120, 40, 20);
        GLabel.setBounds(90, 120, 40, 20);
        BLabel.setBounds(130, 120, 40, 20);

        colorPanel.add(RLabel);
        colorPanel.add(GLabel);
        colorPanel.add(BLabel);

        // COLOR INDICATOR
        colorIndicatorPanel = new JPanel();
        colorIndicatorPanel.setBounds(220, 115, 50, 50);
        colorIndicatorPanel.setBackground(Color.black); 
        colorPanel.add(colorIndicatorPanel);

        // COLORS
        
        predet = new JLabel("Colores Predeterminados");
        predet.setBounds(60, 190, 200, 30);
        predet.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        predet.setBackground(Color.WHITE);  
        colorPanel.add(predet);
        
        
        black = new JButton("");
        black.setBounds(60, 230, 40, 40);
        black.setBackground(Color.black);
        black.setContentAreaFilled(false);
        black.setBorderPainted(false);
        black.setOpaque(true);
        black.addActionListener(this);
        colorPanel.add(black);

        orange = new JButton();
        orange.setBounds(120, 230, 40, 40);
        orange.setBackground(Color.orange);  
        orange.setContentAreaFilled(false);
        orange.setBorderPainted(false);
        orange.setOpaque(true);
        orange.addActionListener(this);
        colorPanel.add(orange);
        
        blue = new JButton("");
        blue.setBounds(180, 230, 40, 40);
        blue.setBackground(Color.blue);
        blue.setContentAreaFilled(false);
        blue.setBorderPainted(false);
        blue.setOpaque(true);
        colorPanel.add(blue);
        blue.addActionListener(this);
        
        yellow = new JButton();
        yellow.setBounds(240, 230, 40, 40);
        yellow.setBackground(Color.yellow);
        yellow.setContentAreaFilled(false);
        yellow.setBorderPainted(false);
        yellow.setOpaque(true);
        colorPanel.add(yellow);
        yellow.addActionListener(this);
        
        //
        
        
        white = new JButton("");
        white.setBounds(30, 280, 40, 40);
        white.setBackground(Color.white);
        white.setContentAreaFilled(false);
        white.setBorderPainted(false);
        white.setOpaque(true);
        colorPanel.add(white);
        white.addActionListener(this);
        
        
        green = new JButton();
        green.setBounds(90, 280, 40, 40);
        green.setBackground(Color.green);
        green.setContentAreaFilled(false);
        green.setBorderPainted(false);
        green.setOpaque(true);
        colorPanel.add(green);
        green.addActionListener(this);
        
        pink = new JButton("");
        pink.setBounds(150, 280, 40, 40);
        pink.setBackground(Color.pink);
        pink.setContentAreaFilled(false);
        pink.setBorderPainted(false);
        pink.setOpaque(true);
        colorPanel.add(pink);
        pink.addActionListener(this);
    
        
        red = new JButton();
        red.setBounds(210, 280, 40, 40);
        red.setBackground(Color.red);
        red.setContentAreaFilled(false);
        red.setBorderPainted(false);
        red.setOpaque(true);
        colorPanel.add(red);
        red.addActionListener(this);
        
       
        return colorPanel;
    }

    
    public void setColorr(Color color) {
        currentColor = color;
        pixelArtPanel.setCurrentColor(color);
        colorIndicatorPanel.setBackground(color);
        pixelArtPanel.repaint();
      }
    
    public void updateColorIndicator(Color color) {
        colorIndicatorPanel.setBackground(color);
    }
    
    
    @Override
    public void stateChanged(ChangeEvent e) {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        Color color = new Color(red, green, blue);
        currentColor = color;
        pixelArtPanel.setCurrentColor(color);

       
       colorIndicatorPanel.setBackground(color);
      

        redValueLabel.setText(Integer.toString(red));
        greenValueLabel.setText(Integer.toString(green));
        blueValueLabel.setText(Integer.toString(blue));
    }

  
    @Override
    
    public void actionPerformed(ActionEvent e) {
        
      
        if (e.getSource() == black) {
        	colorManager.setCurrentColor(Color.BLACK);
        	updateColorIndicator(Color.BLACK); 
      }
        
        if (e.getSource() == blue) {
        	colorManager.setCurrentColor(Color.BLUE);
        	updateColorIndicator(Color.BLUE); 
        }
        
        if (e.getSource() == green) {
        	colorManager.setCurrentColor(Color.GREEN);
        	updateColorIndicator(Color.GREEN); 
        }
        if (e.getSource() == orange) {
        	colorManager.setCurrentColor(Color.ORANGE);
        	updateColorIndicator(Color.ORANGE); 
        }
        if (e.getSource() == pink) {
        	colorManager.setCurrentColor(Color.PINK);
        	updateColorIndicator(Color.PINK); 
        }
        if (e.getSource() == red) {
        	colorManager.setCurrentColor(Color.RED);
        	updateColorIndicator(Color.RED); 
        }
        if (e.getSource() == white) {
        	colorManager.setCurrentColor(Color.WHITE);
        	updateColorIndicator(Color.WHITE); 
        }
        if (e.getSource() == yellow) {
        	colorManager.setCurrentColor(Color.YELLOW);
        	updateColorIndicator(Color.YELLOW); 
        }
        }
    	
}
