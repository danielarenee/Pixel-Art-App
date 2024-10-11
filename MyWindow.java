package frames;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MyWindow extends JFrame implements ActionListener, ChangeListener {

    private int width;
    private int height;
    private JPanel contentPane;
    private JPanel colorContentPane; 
    public PixelArtPanel pixelArtPanel;
    public ColorPanel window;
    private JButton delete;
    private JButton save;
    private JButton upload;
    private JLabel title;
    private ColorManager colorManager;

    public MyWindow(int width, int height) {
        this.width = width;
        this.height = height;
        colorManager = new ColorManager(); 
        pixelArtPanel = new PixelArtPanel(colorManager); 
        window = new ColorPanel(pixelArtPanel, colorManager); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        components();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(true); 
        setVisible(true);
    }
    private void components() {
        contentPane = new JPanel();
        pixelArtPanel = new PixelArtPanel(colorManager);
        window = new ColorPanel(pixelArtPanel, colorManager); 
        
        contentPane.setLayout(null);
        contentPane.setBackground(Color.gray);
        contentPane.setBounds(0, 0, width, height);

        pixelArtPanel.setBounds(350, 130, width - 400, height - 200);
        contentPane.add(pixelArtPanel);

        //SAVE
        save = new JButton("Guardar Dibujo");
        save.setBounds(20, 20, 160, 30);
        contentPane.add(save);
        save.addActionListener(this);

        
        //UPLOAD
        upload = new JButton("Subir Imagen");
        upload.setBounds(20, 50, 160, 30);
        contentPane.add(upload);
        upload.addActionListener(this);

        delete = new JButton("Despejar");
        delete.setBounds(50, 80, 100, 30);
        contentPane.add(delete);
        delete.addActionListener(this);
        
        //Title
        title = new JLabel("Pixel Art");
        title.setBounds(500, 2, 200, 200);
        title.setFont(new Font("Lucida Sans", Font.BOLD, 45));
        title.setForeground(Color.WHITE); 
        title.setHorizontalAlignment(SwingConstants.CENTER); 
        title.setVerticalAlignment(SwingConstants.CENTER); 
        contentPane.add(title);
        
    
        colorContentPane = new JPanel();
        colorContentPane.setLayout(null); 
        colorContentPane.setBackground(Color.lightGray); 
        colorContentPane.setBounds(20, 200, 160, 200); 
        contentPane.add(colorContentPane); 

        JPanel colorPanel = window.createColorPanel(); 
        colorPanel.setBounds(0, 0, 320, 500); //el blanquito
        colorContentPane.setBounds(20, 130, 320, 500);
        colorContentPane.add(colorPanel); // Agrega el panel de color definido en ColorPanel a colorContentPane

        add(contentPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            deletePixelArt();
        }
        if (e.getSource() == save) {
            savePixelArt();
        }
        if (e.getSource() == upload) {
            uploadPixelArt();
        }
    }

    private void deletePixelArt() {
        contentPane.remove(pixelArtPanel);
        pixelArtPanel = new PixelArtPanel(colorManager);
        pixelArtPanel.setBounds(350, 130, width - 400, height - 200);
        contentPane.add(pixelArtPanel);
        repaint();
    }

    private void savePixelArt() {
        BufferedImage image = new BufferedImage(pixelArtPanel.getWidth(), pixelArtPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        pixelArtPanel.paint(g2d);
        g2d.dispose();
        
        try {
            String fileName = "pixel_art.png";
            File file = new File(fileName);
            JOptionPane.showMessageDialog(this, "Dibujo guardado como: " + fileName, "Éxito!" , JOptionPane.INFORMATION_MESSAGE);
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void uploadPixelArt() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "png", "jpg", "gif"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(selectedFile);

                // Calcular la escala
                int panelWidth = pixelArtPanel.getWidth();
                int panelHeight = pixelArtPanel.getHeight();
                double scaleFactor = Math.min(panelWidth / (double) image.getWidth(), panelHeight / (double) image.getHeight());

                // Calcular las dimensiones de la escala
                int scaledWidth = (int) (image.getWidth() * scaleFactor);
                int scaledHeight = (int) (image.getHeight() * scaleFactor);

                // Poner el tamaño del panel para que coincida con la escala de la imagen
                pixelArtPanel.setSize(scaledWidth, scaledHeight);
                pixelArtPanel.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
                pixelArtPanel.setMinimumSize(new Dimension(scaledWidth, scaledHeight));
                pixelArtPanel.setMaximumSize(new Dimension(scaledWidth, scaledHeight));
                pixelArtPanel.revalidate();

              
                Graphics2D g2d = (Graphics2D) pixelArtPanel.getImage().getGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
                pixelArtPanel.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
    }
}