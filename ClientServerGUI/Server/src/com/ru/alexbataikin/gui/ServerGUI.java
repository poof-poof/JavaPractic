package com.ru.alexbataikin.gui;

import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerGUI();
            }
        });
    }

    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    private JButton btnStart = new JButton("Запустить сервер");
    private JButton btnStop = new JButton("Остановить сервер");
    private JTextArea log = new JTextArea();

    ServerGUI(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Сервер");

        JPanel control = new JPanel(new GridLayout(1,2));
        control.add(btnStart);
        control.add(btnStop);

        JScrollPane scrol = new JScrollPane(log);
        scrol.setAutoscrolls(true);
        log.setLineWrap(true);
        log.setEditable(false);
        log.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        add(scrol);
        add(control,BorderLayout.SOUTH);

        btnStart.addActionListener(e -> {
            log.append("Server started!\n");
        });
        btnStop.addActionListener(e -> {
            log.append("Server stop\n");
        });

        setResizable(false);
        setVisible(true);
    }

}
