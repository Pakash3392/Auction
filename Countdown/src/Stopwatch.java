import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Stopwatch extends JFrame implements ActionListener, Runnable
    {
     private long startTime;
     private final static java.text.SimpleDateFormat timerFormat = new java.text.SimpleDateFormat("mm : ss.SSS");
     private Integer [] timer = {1,2,3,4,5,6,7,8,9,10,30,60,120,160,180,210};
     private JComboBox<Integer> timerbox = new JComboBox<>(timer);
     private final JButton startStopButton= new JButton("Start/stop");
     private JPanel topPanel = new JPanel();
     private Thread updater;
     private boolean isRunning= false;
     private final Runnable displayUpdater= new Runnable()
         {
         public void run()
             {
             displayElapsedTime(System.currentTimeMillis() - Stopwatch.this.startTime);
         }
     };
     public void actionPerformed(ActionEvent ae)
         {
         if(isRunning)
             {
             long elapsed= System.currentTimeMillis() - startTime;
             isRunning= false;
             try
                 {
                 updater.join();
                 // Wait for updater to finish
             }
             catch(InterruptedException ie) {}
             displayElapsedTime(elapsed);
             // Display the end-result
         }
         else
             {
             startTime= System.currentTimeMillis();
             isRunning= true;
             updater= new Thread(this);
             updater.start();
         }
     }
     private void displayElapsedTime(long elapsedTime)
         {
   
         timerbox.setToolTipText(timerFormat.format(new java.util.Date(elapsedTime)));
     }
     public void run()
         {
         try
             {
             while(isRunning)
                 {
                 SwingUtilities.invokeAndWait(displayUpdater);
                 Thread.sleep(50);
             }
         }
         catch(java.lang.reflect.InvocationTargetException ite)
             {
             ite.printStackTrace(System.err);
             // Should never happen!
         }
         catch(InterruptedException ie) {}
         // Ignore and return!
     }
     public Stopwatch()
         {
    	 topPanel.setLayout(new GridLayout(1,2));
         timerbox.addActionListener(this); 
         startStopButton.addActionListener(this);
         getContentPane().add(startStopButton);
         getContentPane().add(timerbox);
         setSize(100,50);
         setVisible(true);
     }
     public static void main(String[] arg)
         {
         new Stopwatch().addWindowListener(new WindowAdapter()
             {
             public void windowClosing(WindowEvent e)
                 {
                 System.exit(0);
             }
         });
     }
}