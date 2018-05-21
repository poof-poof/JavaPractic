package com.ru.alexbataikin.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ActionListener{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    private JTextArea log = new JTextArea();
    private JTextField tfMessage = new JTextField();
    private JButton btnSend =  new JButton("Send");
    private JButton btnConnect = new JButton("Connect to local server");
    private JPanel downPanel = new JPanel(new BorderLayout());
    private String clientName;

    ClientGUI(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Client");
        setResizable(false);

        JScrollPane scroll = new JScrollPane(log);
        scroll.setAutoscrolls(true);
        log.setLineWrap(true);
        log.setEditable(false);

        downPanel.add(tfMessage,BorderLayout.CENTER);
        downPanel.add(btnSend,BorderLayout.EAST);

        add(btnConnect, BorderLayout.NORTH);
        add(downPanel,BorderLayout.SOUTH);
        add(scroll, BorderLayout.CENTER);

        tfMessage.setVisible(false);
        btnSend.setVisible(false);

        tfMessage.addActionListener(this);
        btnSend.addActionListener(this);
        btnConnect.addActionListener(this);

        setVisible(true);

        clientName = "Client " + (int)(Math.random() * 10);

    }

    private void putLog(String message){
        log.append(message + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == tfMessage || src == btnSend){
            putLog(clientName + ": " + tfMessage.getText());
            tfMessage.setText(null);
            tfMessage.requestFocusInWindow();
        }else if (src == btnConnect){
            //connect to server
            btnConnect.setVisible(false);
            tfMessage.setVisible(true);
            btnSend.setVisible(true);
        }else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }
}
