import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {
    JFrame frame = new JFrame();

    public HomeFrame(Garage garage) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("ДОБРЕ ДОШЛИ В ГАРАЖ: " + garage.getName());
        titleLabel.setBounds(250, 100, 400, 30);
        frame.add(titleLabel);

        createButtonsPanel(garage);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createButtonsPanel(Garage garage) {
        JButton buttonAddCar = new JButton("Добави");
        buttonAddCar.setBounds(300, 300, 150, 30);

        JButton buttonUpdateCar = new JButton("Обнови");
        buttonUpdateCar.setBounds(300, 350, 150, 30);

        JButton buttonSearchCar = new JButton("Търси");
        buttonSearchCar.setBounds(300, 400, 150, 30);

        JButton buttonShowCars = new JButton("Всички");
        buttonShowCars.setBounds(300, 450, 150, 30);

        frame.add(buttonAddCar);
        frame.add(buttonUpdateCar);
        frame.add(buttonSearchCar);
        frame.add(buttonShowCars);

        buttonAddCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new AddCarFrame(garage);
            }
        });

        buttonUpdateCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new ChoseCarForEditFrame(garage);
            }
        });

        buttonSearchCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new SearchCarFrame(garage);
            }
        });

        buttonShowCars.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new AllCarFrame(garage.getCars(), "ВСИЧКИ КОЛИ В ГАРАЖ: " + garage.getName(), garage);
            }
        });
    }
}
