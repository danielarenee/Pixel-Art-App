package frames;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Starter {

    public static void main(String[] args) {
        int width = 900;
        int height = 700;

        MyWindow frame = new MyWindow(width, height);
        frame.setTitle("Pixel Art App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}