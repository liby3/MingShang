package DifferentPanes;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class LoadPane extends Pane {
   private ImageView imageView;
   private Button bt1, bt2;

    private ListView<String> saveList;
    public LoadPane(){
        super();
        imageView = new ImageView("pic/map/LoanPage.jpg");

        getChildren().add(imageView);
        bt1 = new Button("返回");
        bt1.setLayoutX(500);
        bt1.setLayoutY(300);
        bt2 = new Button("载入");
        bt2.setLayoutX(500);
        bt2.setLayoutY(400);
        bt2.setOnAction(e -> refresh());
        saveList = new ListView<>();
        refresh();
        getChildren().addAll(saveList, bt1, bt2);

        //高斯模糊，对背景图片模糊
        GaussianBlur blur = new GaussianBlur(20.0);
        imageView.setEffect(blur);
    }

    //提供方法刷新当前存档文件列表
    public void refresh(){
        saveList.getItems().clear();
        File d = new File("saves");
        File[] files = d.listFiles();
        for(int i=0;i<files.length;i++) {
            if(files[i].getName().matches("^save[0-9]+.dat$")) {
                saveList.getItems().add(files[i].getName());
            }
        }
        if(saveList.getItems().size()>0) {
            saveList.getSelectionModel().select(0);
            bt2.setDisable(false);
        } else {
            bt2.setDisable(true);
        }
    }
    public ImageView getImageView() {
        return imageView;
    }
    public Button getBt1() {
        return bt1;
    }
    public Button getBt2() {
        return bt2;
    }
    public String getCurrentSelected() {
        return saveList.getItems().get(saveList.getSelectionModel().getSelectedIndex());
    }
}
