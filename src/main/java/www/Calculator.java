package www;
import javax.swing.*;
class Calculator extends JFrame {
    public static void main(String[] args) {

                Calculator frame = new Calculator();
            }
    public Calculator() {//Создаем конструктор с нужными параметрами
        setTitle("Cчет-машин!!");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalculatorX panel = new CalculatorX();//Вызов обьекта следующего класса
        add(panel);
        pack();
    }
}
