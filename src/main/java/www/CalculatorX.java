package www;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorX extends JPanel {
     JButton screen=new JButton("0");
     JPanel panel=new JPanel();
     float res;
     String end;
    boolean go;
    //создаем нужные переменные
     public CalculatorX() {//конструктор с нужными параметрами
         res = 0;
        end = "=";
        go = true;//инициализация переменных
         setLayout(new BorderLayout());
        add(screen, BorderLayout.SOUTH);
         add(panel, BorderLayout.CENTER);

        ActionListener insert = new Insert();//cоздаем классы вставки и исполнения команд
        ActionListener command = new Command();

        panel.setLayout(new GridLayout(4, 4));//указываем число кнопок в рфд и число рядов

        addP("7", insert);
        addP("8", insert);
        addP("9", insert);
        addP("/", command);

        addP("4", insert);
        addP("5", insert);
        addP("6", insert);
        addP("*", command);

        addP("1", insert);
        addP("2", insert);
        addP("3", insert);
        addP("-", command);

        addP("0", insert);
        addP(".", insert);
        addP("=", command);
        addP("+", command);
     }

    private void addP(String label, ActionListener listener) {//реализация метода добавления кнопок на панель
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class Insert implements ActionListener {//реализация класса вставки
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (go) {
                screen.setText("");
                go = false;
            }
            screen.setText(screen.getText() + input); }
    }
    private class Command implements ActionListener {//реализация класса команд
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (go) {
                if (command.equals("-")) {
                    screen.setText(command);
                    go = false;
                } else end = command;
            } else {
                raschet((float) Double.parseDouble(screen.getText()));
                end = command;
                go = true;
            }
        }
    }
    public void raschet(float x) {
        if ("+".equals(end)) {
            res += x;
        }
        if ("-".equals(end)) {
            res -= x;
        }
        if ("*".equals(end)) {
            res *= x;
        }
        if ("/".equals(end)) {
            res /= x;
        }
        if ("=".equals(end)) {
            res = x;
        }
        screen.setText(""+res);
    }
}
