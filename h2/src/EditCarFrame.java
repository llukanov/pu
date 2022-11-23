import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EditCarFrame {
    JTextField typeTextField = new JTextField(10);
    JTextField regNumTextField = new JTextField(10);
    JTextField brandTextField = new JTextField(10);
    JTextField modelTextField = new JTextField(10);

    JTextField fuelConsumptionTextField = new JTextField(10);

    JTextField tankVolumeTextField = new JTextField(10);

    JTextField powerTextField = new JTextField(10);

    String[] transmissionTypes = { "Ръчна", "Автоматична" };
    JComboBox transmissionTypeComboBox = new JComboBox(transmissionTypes);

    String[] fuelTypes = { "Дизел", "Бензин/Газ" };
    JComboBox fuelTypeComboBox = new JComboBox(fuelTypes);

    JTextField yearCreatingTextField = new JTextField(10);
    JTextField registrationDateTextField = new JTextField(10);

    JTextField insuranceDateTextField = new JTextField(10);
    JTextField reviewDateTextField = new JTextField(10);
    JTextField nextTireChangingDateTextField = new JTextField(10);
    JTextField kmToNextOilChangingTextField = new JTextField(10);
    JFrame frameHome = new JFrame("Добавяне на кола");
    JFrame errorFrame = new JFrame("Грешка");

    public EditCarFrame(Car car, Garage garage) {
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createButtonsPanel();
        createAttributesPanel(car, garage);

        frameHome.setSize(800, 800);
        frameHome.setLayout(null);
        frameHome.setVisible(true);
    }

    private void createButtonsPanel() {
        JButton buttonAddCar = new JButton("Добави");
        buttonAddCar.setBounds(10, 500, 150, 30);

        JButton buttonDeleteCar = new JButton("Изтрий");
        buttonDeleteCar.setBounds(10, 550, 150, 30);

        JButton buttonUpdateCar = new JButton("Обнови");
        buttonUpdateCar.setBounds(10, 600, 150, 30);

        JButton buttonSearchCar = new JButton("Търси");
        buttonSearchCar.setBounds(10, 650, 150, 30);

        JButton buttonShowCars = new JButton("Всички");
        buttonShowCars.setBounds(10, 700, 150, 30);

        frameHome.add(buttonAddCar);
        frameHome.add(buttonDeleteCar);
        frameHome.add(buttonUpdateCar);
        frameHome.add(buttonSearchCar);
        frameHome.add(buttonShowCars);
    }

    private void createAttributesPanel(Car car, Garage garage) {

        createAttributePanel("Вид:", typeTextField, 200, 20);

        createAttributePanel("Регистрационен номер:", regNumTextField, 360, 20);

        createAttributePanel("Марка:", brandTextField, 520, 20);

        createAttributePanel("Модел:", modelTextField, 200, 100);

        createAttributePanel("Разход на гориво:", fuelConsumptionTextField, 360, 100);

        createAttributePanel("Обем на резервоара:", tankVolumeTextField, 520, 100);

        fuelTypeComboBox.setBounds(200, 220, 150, 30);
        JLabel fuelTypeLabel = new JLabel("Тип гориво:");
        fuelTypeLabel.setBounds(200, 180, 150, 30);
        frameHome.add(fuelTypeLabel);
        frameHome.add(fuelTypeComboBox);

        createAttributePanel("Мощност:", powerTextField, 360, 180);

        transmissionTypeComboBox.setBounds(520, 220, 150, 30);
        JLabel transmissionTypeLabel = new JLabel("Вид скоростна кутия:");
        transmissionTypeLabel.setBounds(520, 180, 150, 30);
        frameHome.add(transmissionTypeLabel);
        frameHome.add(transmissionTypeComboBox);

        createAttributePanel("Година на създаване:", yearCreatingTextField, 200, 260);

        createAttributePanel("Дата на регистрация:", registrationDateTextField, 360, 260);

        createAttributePanel("Дата на застраховка:", insuranceDateTextField, 520, 260);

        createAttributePanel("Дата на преглед:", reviewDateTextField, 200, 340);

        createAttributePanel("Дата на следваща смяна на гуми:", nextTireChangingDateTextField, 360, 340);

        createAttributePanel("КМ за следваща смяна на масло:", kmToNextOilChangingTextField, 520, 340);

        JButton addNewCarButton = new JButton("Редактирай");
        addNewCarButton.setBounds(520, 440, 150, 30);

        frameHome.add(addNewCarButton);

        addNewCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frameHome.dispose();
                addNewCar(car, garage);
            }
        });
    }

    private void createAttributePanel(String attributeText, JTextField textField, int x, int y) {
        JLabel label = new JLabel(attributeText);
        label.setBounds(x, y, 150, 30);
        textField.setBounds(x, y+40, 150, 30);
        frameHome.add(label);
        frameHome.add(textField);
    }

    private void addNewCar(Car car, Garage garage) {
        if (typeTextField.getText() != null
                && regNumTextField.getText() != null
                && brandTextField.getText() != null
                && modelTextField.getText() != null
                && fuelConsumptionTextField.getText() != null
                && tankVolumeTextField.getText() != null
                && fuelTypeComboBox.getSelectedItem().toString() != null
                && powerTextField.getText() != null
                && transmissionTypeComboBox.getSelectedItem().toString() != null
                && yearCreatingTextField.getText() != null
                && registrationDateTextField.getText() != null
                && insuranceDateTextField.getText() != null
                && reviewDateTextField.getText() != null
                && nextTireChangingDateTextField.getText() != null
                && kmToNextOilChangingTextField.getText() != null) {
            car.setType(typeTextField.getText());
            car.setNumberPlate(regNumTextField.getText());
            car.setBrand(brandTextField.getText());
            car.setModel(modelTextField.getText());
            car.setFuelConsumption(fuelConsumptionTextField.getText());
            car.setTankVolume(tankVolumeTextField.getText());
            car.setFuelType(fuelTypeComboBox.getSelectedItem().toString());
            car.setPower(powerTextField.getText());
            car.setTransmissionType(transmissionTypeComboBox.getSelectedItem().toString());
            car.setYearCreating(yearCreatingTextField.getText());
            car.setRegistrationDate(registrationDateTextField.getText());
            car.setInsuranceDate(insuranceDateTextField.getText());
            car.setReviewDate(reviewDateTextField.getText());
            car.setNextTireChangingDate(nextTireChangingDateTextField.getText());
            car.setKmToNextOilChanging(kmToNextOilChangingTextField.getText());
        }

        new HomeFrame(garage);
    }
}
