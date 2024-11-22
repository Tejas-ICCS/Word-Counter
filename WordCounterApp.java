import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().setBackground(new Color(255, 255, 237));
        frame.setLayout(new BorderLayout());

        // Create a text area for input
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size between 10 and 20
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        // Set the preferred size to avoid horizontal scrollbar
        textArea.setPreferredSize(new Dimension(380, 300));
        
        // Add the text area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Disable horizontal scrollbar
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Show vertical scrollbar as needed
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton countWordsButton = new JButton("Count Words");
        JButton resetButton = new JButton("Reset");

        // Add action listener for Count Words button
        countWordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText().trim();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a paragraph.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    String[] words = text.split("\\s+");
                    int wordCount = words.length;
                    JOptionPane.showMessageDialog(frame, "Total Words: " + wordCount, "Word Count", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Add action listener for Reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        // Add buttons to the panel
        buttonPanel.add(countWordsButton);
        buttonPanel.add(resetButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}