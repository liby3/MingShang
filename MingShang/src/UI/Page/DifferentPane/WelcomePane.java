package UI.Page.DifferentPane;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by admin on 2016/12/25.
 */
//��ӭ����
public class WelcomePane extends Pane {

    private ImageView inageView;
    private Button bt1 , bt2, bt3, bt4;
    public WelcomePane(){
        super();

        inageView = new ImageView("pic/MainPage.jpg");
        getChildren().add(inageView);

         bt1 = new Button("��ʼ");
         bt2 = new Button("����");
         bt3 = new Button("����");
         bt4 = new Button("����");

        bt1.setLayoutX(500);
        bt1.setLayoutY(400);
        bt2.setLayoutX(600);
        bt2.setLayoutY(400);
        bt3.setLayoutX(700);
        bt3.setLayoutY(400);
        bt4.setLayoutX(600);
        bt4.setLayoutY(450);

        bt4.setOnAction(e->{
            System.exit(0);
        });

        getChildren().add(bt1);
        getChildren().add(bt2);
        getChildren().add(bt3);
        getChildren().add(bt4);
    }
    public ImageView getInageView(){
        return  inageView;
    }
    public Button getBt1(){
        return bt1;
    }
    public Button getBt2(){
        return  bt2;
    }
    public Button getBt3(){
        return bt3;
    }
    public Button getBt4(){
        return bt4;
    }
}