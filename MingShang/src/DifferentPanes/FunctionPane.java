package DifferentPanes;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by admin on 2017/1/3.
 */

public class FunctionPane extends Pane {
    private Button btUndo, btSave, btRestart, btReturn;
    public FunctionPane(){
        super();

        btUndo = new Button("»ÚÆå");
        btUndo.setPrefHeight(50);
        btUndo.setPrefWidth(100);
        btUndo.setLayoutX(10);
        btUndo.setLayoutY(10);
        getChildren().add(btUndo);

        btSave = new Button("´æµµ");
        btSave.setPrefHeight(50);
        btSave.setPrefWidth(100);
        btSave.setLayoutX(10);
        btSave.setLayoutY(110);
        getChildren().add(btSave);

        btRestart = new Button("ÖØÀ´");
        btRestart.setPrefHeight(50);
        btRestart.setPrefWidth(100);
        btRestart.setLayoutX(10);
        btRestart.setLayoutY(210);
        getChildren().add(btRestart);

        btReturn = new Button("ÍË³ö");
        btReturn.setPrefHeight(50);
        btReturn.setPrefWidth(100);
        btReturn.setLayoutX(10);
        btReturn.setLayoutY(310);
        getChildren().add(btReturn);
    }
    
    public Button getBtUndo() {
        return btUndo;
    }

    public Button getBtSave() {
        return btSave;
    }

    public Button getBtRestart() {
        return btRestart;
    }

    public Button getBtReturn() {
        return btReturn;
    }
}
