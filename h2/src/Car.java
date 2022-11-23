import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Car extends Vehicle {
    private int fuelConsumption;
    private int tankVolume;
    private String fuelType;
    private int power;
    private String transmissionType;
    private int yearCreating;
    private LocalDate registrationDate;
    private LocalDate insuranceDate;
    private LocalDate reviewDate;
    private LocalDate nextTireChangingDate;
    private int kmToNextOilChanging;

    public int getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        if (fuelConsumption != null && !fuelConsumption.isEmpty()) {
            try {
                if (Integer.parseInt(fuelConsumption) > 0) {
                    this.fuelConsumption = Integer.parseInt(fuelConsumption);
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Разход на гориво\" трябва да е по-голяма от 0!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getTankVolume() {
        return this.tankVolume;
    }

    public void setTankVolume(String tankVolume) {
        if (tankVolume != null && !tankVolume.isEmpty()) {
            try {
                if (Integer.parseInt(tankVolume) > 0) {
                    this.tankVolume = Integer.parseInt(tankVolume);
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Обем на резервоара\" не трябва да е по-голяма от 0!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        if (fuelType != null && !fuelType.isEmpty()) {
           this.fuelType = fuelType;

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(String power) {
        if (power != null && !power.isEmpty()) {
            try {
                if (Integer.parseInt(power) > 0) {
                    this.power = Integer.parseInt(power);
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Мощност\" не трябва да е по-голяма от 0!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getTransmissionType() {
        return this.transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        if (transmissionType != null && !transmissionType.isEmpty()) {
            this.transmissionType = transmissionType;
        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getYearCreating() {
        return this.yearCreating;
    }

    public void setYearCreating(String yearCreating) {
        if (yearCreating != null && !yearCreating.isEmpty()) {
            try {
                int currentYear = Year.now().getValue();
                if (Integer.parseInt(yearCreating) > 0 && Integer.parseInt(yearCreating)  <= currentYear) {
                    this.yearCreating = Integer.parseInt(yearCreating);
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Година на изадаване на модела\" не трябва да е по-голяма от 0 и да не в бъдещето!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        if (registrationDate != null && !registrationDate.isEmpty()) {
            try {
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate regDateLD = LocalDate.parse(registrationDate, formatter);

                if (!regDateLD.isAfter(currentDate)) {
                    this.registrationDate = regDateLD;
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Дата на регистрация\" не трябва да е по-голяма от 0 и да не в бъдещето!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getInsuranceDate() {
        return this.insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        if (insuranceDate != null && !insuranceDate.isEmpty()) {
            try {
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate insuranceDateLD = LocalDate.parse(insuranceDate, formatter);

                if (!insuranceDateLD.isAfter(currentDate)) {
                    this.insuranceDate = insuranceDateLD;
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Обем на застраховка\" не трябва да е по-голяма от 0 и да не в бъдещето!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getReviewDate() {
        return this.reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        if (reviewDate != null && !reviewDate.isEmpty()) {
            try {
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate reviewDateLD = LocalDate.parse(reviewDate, formatter);

                if (!reviewDateLD.isAfter(currentDate)) {
                    this.insuranceDate = reviewDateLD;
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Дата на преглед\" не трябва да е по-голяма от 0 и да не в бъдещето!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getNextTireChangingDate() {
        return this.nextTireChangingDate;
    }

    public void setNextTireChangingDate(String nextTireChangingDate) {
        if (nextTireChangingDate != null && !nextTireChangingDate.isEmpty()) {
            try {
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate nextTireChangingDateLD = LocalDate.parse(nextTireChangingDate, formatter);

                if (!nextTireChangingDateLD.isBefore(currentDate)) {
                    this.insuranceDate = nextTireChangingDateLD;
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"Дата на следваща смяна на гуми\" не трябва да е по-голяма от 0 и да не в миналото!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getKmToNextOilChanging() {
        return this.kmToNextOilChanging;
    }

    public void setKmToNextOilChanging(String kmToNextOilChanging) {
        if (kmToNextOilChanging != null && !kmToNextOilChanging.isEmpty()) {
            try {
                if (Integer.parseInt(kmToNextOilChanging) >= 0) {
                    this.kmToNextOilChanging = Integer.parseInt(kmToNextOilChanging);
                } else {
                    JOptionPane.showMessageDialog(errorFrame,
                            "Съжаляваме, стойността на полете \"КМ за следваща смяна на гуми \" не трябва да е по-малка от 0!",
                            "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(errorFrame,
                        "Некоректна стойност!",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(errorFrame,
                    "Съжаляваме, трябва да добавите стойност!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }


}
