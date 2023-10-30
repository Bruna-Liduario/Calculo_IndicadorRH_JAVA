package Indicadores;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Aplicaçao {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Calculos calc = new Calculos();
            calc.setVisible(true);
        });
    }
}
