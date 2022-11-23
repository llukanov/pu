import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AllCarFrame {
    JFrame frame = new JFrame("Коли в гаража");

    public AllCarFrame(List<Car> cars, String title, Garage garage) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel titleLabel = new JLabel(title);
        titleLabel.setBounds(300, 1, 400, 30);
        frame.add(titleLabel);

        frame.add(createLabel("Вид", 200, 30));
        frame.add(createLabel("Модел", 400, 30));
        frame.add(createLabel("Рег. номер", 600, 30));

        int counter = 1;
        for (Car car:
             cars) {
            frame.add(createLabel(car.getType(), 100, counter * 100));
            frame.add(createLabel(car.getModel(), 300, counter * 100));
            frame.add(createLabel(car.getNumberPlate(), 500, counter * 100));

            JButton deleteCarButton = new JButton("Изтрий");
            deleteCarButton.setBounds(700, counter * 100, 150, 30);
            frame.add(deleteCarButton);

            deleteCarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    frame.dispose();
                    garage.getCars().remove(car);
                    new HomeFrame(garage);
                }
            });

            counter++;
        }

        JButton buttonHome = new JButton("НАЧАЛО");
        buttonHome.setBounds(10, 500, 150, 30);
        frame.add(buttonHome);

        buttonHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new HomeFrame(garage);
            }
        });

        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public JLabel createLabel(String attributeText, int x, int y) {
        JLabel label = new JLabel(attributeText);
        label.setBounds(x, y, 200, 30);

        return label;
    }
}
