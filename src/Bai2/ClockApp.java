package Bai2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ClockApp extends JFrame {
    private JTextField timezoneField;

    public ClockApp() {
        setTitle("Clock App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        timezoneField = new JTextField(10);
        JButton createButton = new JButton("Create Clock");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createClock();
            }
        });

        add(new JLabel("Timezone:"));
        add(timezoneField);
        add(createButton);
    }

    private void createClock() {
        String timezone = timezoneField.getText().trim();
        if (!timezone.isEmpty()) {
            ClockFrame clockFrame = new ClockFrame(timezone);
            clockFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClockApp clockApp = new ClockApp();
                clockApp.setVisible(true);
            }
        });
    }
}
