import javax.swing.*;

abstract class Vehicle {
    JFrame errorFrame = new JFrame();

    private String type;
    private String numberPlate;
    private String brand;
    private String model;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        if (type != null && !type.isEmpty()) {
            if (type.length() <= 100) {
                this.type = type;
            } else {
                JOptionPane.showMessageDialog(errorFrame,
                        "Съжаляваме, стойността на полето \"Тип\" не трябва да превишава 100 символа!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNumberPlate() {
        return this.numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        if (numberPlate != null && !numberPlate.isEmpty()) {
            if (numberPlate.length() <= 10) {
                this.numberPlate = numberPlate;
            } else {
                JOptionPane.showMessageDialog(errorFrame,
                        "Съжаляваме, стойността \"Регистрационен номер\" не трябва да превишава 10 символа!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            if (brand.length() <= 20) {
                this.brand = brand;
            } else {
                JOptionPane.showMessageDialog(errorFrame,
                        "Съжаляваме, стойността \"Марка\" не трябва да превишава 20 символа!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if (model != null && !model.isEmpty()) {
            if (model.length() <= 20) {
                this.model = model;
            } else {
                JOptionPane.showMessageDialog(errorFrame,
                        "Съжаляваме, стойността \"Модел\" не трябва да превишава 20 символа!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JLabel createLabel(String attributeText, int x, int y) {
        JLabel label = new JLabel(attributeText);
        label.setBounds(x, y, 150, 30);

        return label;
    }
}
