package com.example.lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoController {
    @FXML
    private Button sorsolGomb;
    @FXML
    private Label sorsoltSzamLabel;
    @FXML
    private HBox sorsoltSzamok;
    private static final Random rng = new Random();
    private List<Integer> sorsoltSzamokLista = new ArrayList<>();

    @FXML
    public void sorsolCLick(ActionEvent actionEvent) {
        if(sorsoltSzamokLista.size()==5){
            Collections.sort(sorsoltSzamokLista);
            sorsoltSzamok.getChildren().clear();
            for (int szam: sorsoltSzamokLista){
                sorsoltSzamok.getChildren().add(new Label(String.valueOf(szam)));
            }
        }else {
            int sorsoltSzam = rng.nextInt(98)+1;
            while (sorsoltSzamokLista.contains(sorsoltSzam)){
                sorsoltSzam = rng.nextInt(98)+1;
            }
            sorsoltSzamokLista.add(sorsoltSzam);
            sorsoltSzamLabel.setText(String.valueOf(sorsoltSzam));

            sorsoltSzamok.getChildren().clear();
            for (int szam: sorsoltSzamokLista){
                sorsoltSzamok.getChildren().add(new Label(String.valueOf(szam)));
            }
        }

        if(sorsoltSzamokLista.size()==5){
            sorsolGomb.setText("Rendez");
        }
    }
}