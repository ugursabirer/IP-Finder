package IPFinder;

import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class IPFinder extends JFrame implements ActionListener {

    JLabel label;
    JTextField textField;
    JButton button;

    IPFinder() {
        super("IP Finder");
        label = new JLabel("Enter URL: ");
        label.setBounds(50, 70, 150, 20);
        textField = new JTextField();
        textField.setBounds(50, 105, 175, 25);
        button = new JButton("Find IP");
        button.setBounds(50, 150, 75, 25);
        button.addActionListener(this);
        add(label);
        add(textField);
        add(button);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String url = textField.getText();
        try {
            InetAddress inetAddress = InetAddress.getByName(url);
            String ip = inetAddress.getHostAddress();
            JOptionPane.showMessageDialog(this, ip);
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    public static void main(String[] args) {
        new IPFinder();
    }
}
