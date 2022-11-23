import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoseCarForEditFrame {
    JFrame frame = new JFrame("Избиране на кола за редактиране:");
    JFrame errorFrame = new JFrame();

    public ChoseCarForEditFrame(Garage garage) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Въведете регистрационен номер!");
        label.setBounds(280, 300, 400, 30);
        JTextField input = new JTextField(10);
        input.setBounds(300, 400, 150, 30);

        frame.add(label);
        frame.add(input);

        JButton searchCarButton = new JButton("Потърси");
        searchCarButton.setBounds(300, 440, 150, 30);

        frame.add(searchCarButton);

        searchCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Car foundCar = garage.getCars().stream().filter(car -> input.getText().equals(car.getNumberPlate())).findFirst().orElse(null);

                if (foundCar != null) {
                    new EditCarFrame(foundCar, garage);
                }
                else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Не е намерена кола с този регистрационен номер!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                    new HomeFrame(garage);
                }
            }
        });

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
}
