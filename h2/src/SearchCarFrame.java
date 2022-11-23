import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchCarFrame {
    JFrame frame = new JFrame("Търсене на кола");
    JFrame errorFrame = new JFrame();

    public SearchCarFrame(Garage garage) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Изберете критерий и потърсете:");
        label.setBounds(200, 100, 150, 30);

        String[] criteria = { "Регистрационен номер", "Марка", "Модел", "Дата на застраховане", "Дата на регистрация" };
        JComboBox criteriaComboBox = new JComboBox(criteria);
        criteriaComboBox.setBounds(200, 140, 150, 30);

        JTextField input = new JTextField(10);
        input.setBounds(360, 140, 150, 30);

        frame.add(label);
        frame.add(criteriaComboBox);
        frame.add(input);

        JButton searchCarButton = new JButton("Потърси");
        searchCarButton.setBounds(520, 500, 150, 30);

        frame.add(searchCarButton);

        searchCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();

                switch (criteriaComboBox.getSelectedItem().toString()){
                    case "Регистрационен номер":
                        new AllCarFrame(searchCarNumberPlate(garage, input.getText()), "КОЛИ С РЕГИСТРАЦИОНЕН НОМЕР: " + input.getText(), garage);
                        break;
                    case "Марка":
                        new AllCarFrame(searchCarByBrand(garage, input.getText()), "КОЛИ С МАРКА: " + input.getText(), garage);
                        break;
                    case "Модел":
                        new AllCarFrame(searchCarByModel(garage, input.getText()), "КОЛИ С МОДЕЛ: " + input.getText(), garage);
                        break;
                    case "Дата на застраховане":
                        new AllCarFrame(searchCarByInsuranceDate(garage, input.getText()), "КОЛИ С ДАТА НА ЗАСТРАХОВАНЕ: " + input.getText(), garage);
                        break;
                    case "Дата на регистрация":
                        new AllCarFrame(searchCarByRegisterDate(garage, input.getText()), "КОЛИ С ДАТА НА РЕГИСТРАЦИЯ: " + input.getText(), garage);
                        break;
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

    public List<Car> searchCarNumberPlate(Garage garage, String input) {
        List<Car> foundedCar = new ArrayList<>();
        for (Car car : garage.getCars()) {
            if (car.getNumberPlate().equals(input.toLowerCase())) {
                foundedCar.add(car);
            }
        }

        return foundedCar;
    }

    public List<Car> searchCarByBrand(Garage garage, String input) {
        List<Car> foundedCar = new ArrayList<>();
        for (Car car : garage.getCars()) {
            if (car.getBrand().equals(input.toLowerCase())) {
                foundedCar.add(car);
            }
        }

        return foundedCar;
    }

    public List<Car> searchCarByModel(Garage garage, String input) {
        List<Car> foundedCar = new ArrayList<>();
        for (Car car : garage.getCars()) {
            if (car.getModel().equals(input.toLowerCase())) {
                foundedCar.add(car);
            }
        }

        return foundedCar;
    }

    public List<Car> searchCarByRegisterDate(Garage garage, String input) {
        List<Car> foundedCar = new ArrayList<>();
        for (Car car : garage.getCars()) {
            if (car.getRegistrationDate().toString().equals(input.toLowerCase())) {
                foundedCar.add(car);
            }
        }

        return foundedCar;
    }

    public List<Car> searchCarByInsuranceDate(Garage garage, String input) {
        List<Car> foundedCar = new ArrayList<>();
        for (Car car : garage.getCars()) {
            if (car.getInsuranceDate().toString().equals(input.toLowerCase())) {
                foundedCar.add(car);
            }
        }

        return foundedCar;
    }
}
