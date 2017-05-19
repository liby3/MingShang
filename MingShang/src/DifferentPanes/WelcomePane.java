package DifferentPanes;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//��ӭ����
public class WelcomePane extends Pane {

    private ImageView imageView;
    private Button bt1, bt2, bt3, bt4;
    public WelcomePane() {
        super();

        imageView = new ImageView("pic/map/MainPage.jpg");
        imageView.setFitHeight(getLayoutY());
        imageView.setFitWidth(getLayoutX());
        getChildren().add(imageView);
        

        bt1 = new Button("�µ�����");
        bt2 = new Button("����ָ��");
        bt3 = new Button("�������");
        bt4 = new Button("ж�׹���");

        bt1.setLayoutX(200);
        bt1.setLayoutY(350);
        
        bt2.setLayoutX(500);
        bt2.setLayoutY(350);
        
        bt3.setLayoutX(350);
        bt3.setLayoutY(350);
        
        bt4.setLayoutX(650);
        bt4.setLayoutY(350);

        getChildren().add(bt1);
        getChildren().add(bt2);
        getChildren().add(bt3);
        getChildren().add(bt4);
    }
    public ImageView getImageView() {
        return  imageView;
    }
    public Button getBt1() {
        return bt1;
    }
    public Button getBt2() {
        return  bt2;
    }
    public Button getBt3() {
        return bt3;
    }
    public Button getBt4() {
        return bt4;
    }
}