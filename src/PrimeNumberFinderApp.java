import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeNumberFinderApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prime Number Finder");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel lowerBoundLabel = new JLabel("Enter lower bound:");
        JTextField lowerBoundField = new JTextField();
        JLabel upperBoundLabel = new JLabel("Enter upper bound:");
        JTextField upperBoundField = new JTextField();
        JButton findPrimesButton = new JButton("Find Primes");

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        frame.add(lowerBoundLabel);
        frame.add(lowerBoundField);
        frame.add(upperBoundLabel);
        frame.add(upperBoundField);
        frame.add(findPrimesButton);
        frame.add(new JScrollPane(resultArea));

        findPrimesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");

                try {
                    int lowerBound = Integer.parseInt(lowerBoundField.getText());
                    int upperBound = Integer.parseInt(upperBoundField.getText());

                    if (upperBound < lowerBound) {
                        JOptionPane.showMessageDialog(frame, "Upper bound must be greater than or equal to lower bound.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        for (int i = lowerBound; i <= upperBound; i++) {
                            if (isPrime(i)) {
                                resultArea.append(i + "\n");
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
