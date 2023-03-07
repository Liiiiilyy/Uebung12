### Aufgabe 1: 统计奇数个数

编写一个方法int howManyOdds(int[] numbers)，用于统计传入的数组中有多少个奇数。

```java
 
public static int howManyOdds(int[] numbers) {
    int count = 0;
    for (int number : numbers) {
        if (number % 2 != 0) {
            count++;
        }
    }
    return count;
}

```

### Aufgabe 2: 判断奇偶性

编写一个方法boolean evenParity(int number)，用于判断输入数字的二进制表示中1的个数是否为偶数（也称为“奇偶校验”）。

```java
 
public static boolean evenParity(int number) {
    int count = 0;
    while (number != 0) {
        if ((number & 1) == 1) {
            count++;
        }
        number >>= 1;
    }
    return count % 2 == 0;
}

```

### Aufgabe 3: 矩阵转置

编写一个方法void transpose(final int[][] matrix)，用于转置一个方阵，即交换其行和列。例如，transpose将此矩阵转置为：

```

{{1 , 2, 3},
{4, 5, 6},
{7, 8, 9}}
```

变成了：

```

{{1 , 4, 7},
{2, 5, 8},
{3, 6, 9}}

```

```java

public static void transpose(final int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}

```

### Aufgabe 4: 文本转置

编写一个方法void transpose(final String[] matrix)，用于转置一个方形文本，即交换其行和列。例如，transpose将此文本转置为：

```

{" 123 ",
" 456 ",
" 789 "}
```

变成了：

```java

{" 147 ",
" 258 ",
" 369 "}

public static void transpose(final String[] matrix) {
    int n = matrix.length;
    int m = matrix[0].length();
    char[][] tempMatrix = new char[m][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            tempMatrix[j][i] = matrix[i].charAt(j);
        }
    }
    for (int i = 0; i < m; i++) {
        matrix[i] = new String(tempMatrix[i]);
    }
}
```

Aufgabe 5：转置矩阵

编写一个void transpose(final List<List<Integer>> matrix)方法，它可以转置一个正方形矩阵，即交换行和列。例如，transpose将从这个矩阵转换为：
`// import static java . util . Arrays . asList ;
asList ( asList (1, 2, 3) ,
asList (4, 5, 6) ,
asList (7, 8, 9));`
这个矩阵：

`asList ( asList (1, 4, 7) ,
 asList (2, 5, 8),
 asList (3, 6, 9));`

```java
public static void transpose(final List<List<Integer>> matrix) {
	int n = matrix.size();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix.get(i).get(j);
				matrix.get(i).set(j, matrix.get(j).get(i));
				matrix.get(j).set(i, temp);
			}
		}
}
```

- **extends是继承类，implements是实现接口**。 类只能继承一个，接口可以实现多个。 extends继承父类的时候可以重写父类的方法，也可以调用父类的非私有方法；implements实现接口，必须实现接口的所有方法。
- 扫雷简陋版

```java
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
```
