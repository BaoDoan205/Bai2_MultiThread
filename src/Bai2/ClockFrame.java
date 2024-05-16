package Bai2;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ClockFrame extends JFrame {
    private JLabel timeLabel;

    public ClockFrame(String timezone) {
        setTitle("Clock");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel);

        startClock(timezone);
    }

    private void startClock(String timezone) {
        Thread clockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    sdf.setTimeZone(TimeZone.getTimeZone(timezone));
                    String time = sdf.format(calendar.getTime());
                    timeLabel.setText(time);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        clockThread.start();
    }
}
