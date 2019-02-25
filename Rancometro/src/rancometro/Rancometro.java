
package rancometro;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author larissa souza
 */
public class Rancometro extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(5);

        Label lbl = new Label("Seu nome: ");
        lbl.setFont(Font.font("Arial", 15));
        GridPane.setHalignment(lbl, HPos.CENTER);
        gridpane.add(lbl, 0, 0);        
        //coluna 0, na linha 0         
        TextField txtfld = new TextField();
        GridPane.setHalignment(txtfld, HPos.LEFT);
        gridpane.add(txtfld, 1, 0);

        Label lbl1 = new Label("Nome do ranço: ");
        lbl1.setFont(Font.font("Arial", 15));
        GridPane.setHalignment(lbl1, HPos.CENTER);
        gridpane.add(lbl1, 0, 1);

        TextField txtfld1 = new TextField();
        GridPane.setHalignment(txtfld1, HPos.LEFT);
        gridpane.add(txtfld1, 1, 1);

        Label lbl2 = new Label("Você odeia essa pessoa? (S/N)");
        lbl2.setFont(Font.font("Arial", 15));
        GridPane.setHalignment(lbl1, HPos.CENTER);
        gridpane.add(lbl2, 0, 2);

        TextField txtfld2 = new TextField();
        GridPane.setHalignment(txtfld1, HPos.LEFT);
        gridpane.add(txtfld2, 1, 2);

        Label lbl3 = new Label("Essa pessoa odeia você? (S/N)");
        lbl3.setFont(Font.font("Arial", 15));
        GridPane.setHalignment(lbl1, HPos.CENTER);
        gridpane.add(lbl3, 0, 3);

        TextField txtfld3 = new TextField();
        txtfld3.setMinWidth(10);
        GridPane.setHalignment(txtfld1, HPos.LEFT);
        gridpane.add(txtfld3, 1, 3);
        
        Button btn = new Button();
        btn.setText("Calcular Ranço");
        GridPane.setHalignment(btn, HPos.LEFT);
        gridpane.add(btn, 0, 4);

        Label lbl4 = new Label("");
        lbl3.setFont(Font.font("Arial", 15));
        GridPane.setHalignment(lbl1, HPos.CENTER);
        gridpane.add(lbl4, 1, 5);        
        
        Button btn1 = new Button();
        btn1.setText("Calcular outros ranços");
        GridPane.setHalignment(btn1, HPos.LEFT);
        gridpane.add(btn1, 0, 5);
        
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtfld.clear();
                txtfld1.clear();
                txtfld2.clear();
                txtfld3.clear();                         
                txtfld.requestFocus();
            }
            
        });

        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txtfld2.getText().equalsIgnoreCase("S") && txtfld3.getText().equalsIgnoreCase("S")) {
                    lbl4.setText("100% ódio");
                } else if (txtfld2.getText().equalsIgnoreCase("S") && txtfld3.getText().equalsIgnoreCase("N")) {
                    lbl4.setText("50% ódio (Será que o problema não é você?)");
                } else if (txtfld2.getText().equalsIgnoreCase("N") && txtfld3.getText().equalsIgnoreCase("S")) {
                    lbl4.setText("50% ódio (O problema não é você...)");
                } else if (txtfld2.getText().equalsIgnoreCase("N") && txtfld3.getText().equalsIgnoreCase("N")) {
                    lbl4.setText("100% paz por aqui");
                } else {
                    lbl4.setText("Algo errado não está certo.");
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(gridpane);

        Scene scene = new Scene(root, 500, 225);
        

        primaryStage.setTitle("Rancômetro");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
