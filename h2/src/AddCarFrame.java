import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddCarFrame {
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

    public AddCarFrame(Garage garage) {
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("ДОБАВЯНЕ НА КОЛА");
        titleLabel.setBounds(300, 1, 400, 30);
        frameHome.add(titleLabel);

        JButton buttonHome = new JButton("НАЧАЛО");
        buttonHome.setBounds(10, 500, 150, 30);
        frameHome.add(buttonHome);

        buttonHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frameHome.dispose();
                new HomeFrame(garage);
            }
        });


        createAttributesPanel(garage);

        frameHome.setSize(800, 800);
        frameHome.setLayout(null);
        frameHome.setVisible(true);
    }

    private void createAttributesPanel(Garage garage) {

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




        JButton addNewCarButton = new JButton("Добави");
        addNewCarButton.setBounds(520, 440, 150, 30);

        frameHome.add(addNewCarButton);

        addNewCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frameHome.dispose();
                addNewCar(garage);
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

    private void addNewCar(Garage garage) {
        Car newCar = new Car();
        newCar.setType(typeTextField.getText());
        newCar.setNumberPlate(regNumTextField.getText());
        newCar.setBrand(brandTextField.getText());
        newCar.setModel(modelTextField.getText());
        newCar.setFuelConsumption(fuelConsumptionTextField.getText());
        newCar.setTankVolume(tankVolumeTextField.getText());
        newCar.setFuelType(fuelTypeComboBox.getSelectedItem().toString());
        newCar.setPower(powerTextField.getText());
        newCar.setTransmissionType(transmissionTypeComboBox.getSelectedItem().toString());
        newCar.setYearCreating(yearCreatingTextField.getText());
        newCar.setRegistrationDate(registrationDateTextField.getText());
        newCar.setInsuranceDate(insuranceDateTextField.getText());
        newCar.setReviewDate(reviewDateTextField.getText());
        newCar.setNextTireChangingDate(nextTireChangingDateTextField.getText());
        newCar.setKmToNextOilChanging(kmToNextOilChangingTextField.getText());

        if (newCar.getType() != null
            && newCar.getNumberPlate() != null
            && newCar.getBrand() != null
            && newCar.getModel() != null
            && newCar.getFuelConsumption() != 0
            && newCar.getTankVolume() != 0
            && newCar.getFuelType() != null
            && newCar.getPower() != 0
            && newCar.getTransmissionType() != null
            && newCar.getYearCreating() != 0
            && newCar.getRegistrationDate() != null
            && newCar.getInsuranceDate() != null
            && newCar.getReviewDate() != null
            && newCar.getNextTireChangingDate() != null
            && newCar.getKmToNextOilChanging() != 0) {
            garage.getCars().add(newCar);
        }

        new HomeFrame(garage);
    }
}
