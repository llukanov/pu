import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.setName("Моят гараж");

        new HomeFrame(garage);
    }

}