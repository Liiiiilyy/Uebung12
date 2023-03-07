import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Minesweeper extends JFrame implements ActionListener {
    private final JButton[][] buttons;
    private final int ROWS = 8;
    private final int COLS = 8;

    public Minesweeper() {
        super("Minesweeper");
        setLayout(new GridLayout(ROWS, COLS));
        buttons = new JButton[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton(" ");
                button.addActionListener(this);
                buttons[i][j] = button;
                add(button);
            }
        }
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setText("X");
        button.setEnabled(false);
    }

    public static void main(String[] args) {
        new Minesweeper();
    }
}
