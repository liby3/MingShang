package UI.Page.DifferentPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Created by admin on 2017/1/4.
 */
//��ʤ����ʾ����
public class WinPane extends Pane{
   private Button btOver;
   private Label lable1, lable2;
    public WinPane(){
        super();
        String s1 = "��Ϸ��������ϲ�ҷ�ʤ��";
        lable1 = new Label(s1);
        getChildren().add(lable1);
        lable1.setStyle("-fx-font-size:25;-fx-text-fill:white;");

        String s2 = "��Ϸ��������ϲ��ʤ��";
        lable2 = new Label(s2);
        getChildren().add(lable2);
        lable2.setStyle("-fx-font-size:25;-fx-text-fill:white;");

        btOver = new Button("����");
        getChildren().add(btOver);
        btOver.setStyle("-fx-font-size:25;-fx-test-fill:black;");
        btOver.setLayoutY(40);
        btOver.setLayoutX(70);

    }
    public Label getLable1(){
        return lable1;
    }
    public Label getLable2(){
        return lable2;
    }
    public Button getBtOver(){
        return btOver;
    }
}