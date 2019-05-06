import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Timer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.getContentPane().add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);

            Calendar end = Calendar.getInstance();
            end.set(Calendar.HOUR_OF_DAY, 23);
            end.set(Calendar.MINUTE, 59);
            DefaultComboBoxModel<Date> model = new DefaultComboBoxModel<>();
            do {
                model.addElement(calendar.getTime());
                
                calendar.add(Calendar.MINUTE, 15);
            } while (calendar.getTime().before(end.getTime()));

            JComboBox<Date> cb = new JComboBox<>(model);
            cb.setRenderer(new DateFormattedListCellRenderer(new SimpleDateFormat("HH:mm")));

            add(cb);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public class DateFormattedListCellRenderer extends DefaultListCellRenderer {

            private DateFormat format;

            public DateFormattedListCellRenderer(DateFormat format) {
                this.format = format;
            }

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Date) {
                    value = format.format((Date) value);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        }

    }

}