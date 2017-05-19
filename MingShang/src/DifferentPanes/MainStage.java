package DifferentPanes;

import GameRule.GameHistory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class MainStage extends Application {
    WelcomePane welcomePane;
    MapPane mapPane;
    HelpPane helpPane;
    LoadPane loadPane;
    Pane mainPane;
    private Media.SoundControl sound;
    private final static int HEIGHT = 650, WIDTH = 960;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        welcomePane = new WelcomePane();
        mapPane = new MapPane();
        helpPane = new HelpPane();
        loadPane = new LoadPane();
        mainPane = new Pane();
        mapPane.setVisible(false);
        helpPane.setVisible(false);
        loadPane.setVisible(false);
        mainPane.getChildren().addAll(welcomePane, mapPane, helpPane, loadPane);
        
        primaryStage.setResizable(false);
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        sound = new Media.SoundControl();
        sound.music();

        //welcome page
        welcomePane.getBt1().setOnAction(e-> {
            welcomePane.setVisible(false);
            mapPane.setVisible(true);
        });
        welcomePane.getBt2().setOnAction(e-> {
            welcomePane.setVisible(false);
            helpPane.setVisible(true);
        });
        welcomePane.getBt3().setOnAction(e-> {
            welcomePane.setVisible(false);
            loadPane.setVisible(true);
        });
        welcomePane.getBt4().setOnAction(e-> {
        	System.exit(0);
        });
        
        //help page
        helpPane.getBt1().setOnAction(e-> {
            helpPane.setVisible(false);
            welcomePane.setVisible(true);
        });

        //map page
        mapPane.getFunction().getBtReturn().setOnAction(e-> {
            mapPane.setVisible(false);
            welcomePane.setVisible(true);
        });

        //load page
        loadPane.getBt1().setOnAction(e-> {
            loadPane.setVisible(false);
            welcomePane.setVisible(true);
        });
        loadPane.getBt2().setOnAction(e-> {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("saves/" + loadPane.getCurrentSelected()));
                GameHistory history = (GameHistory)input.readObject();
                int steps = input.readInt();
                input.close();
                history.changeMap(history.getTeamHistory()[steps], mapPane.getRoles().getTheTeam(), 
                		history.getRolesHistory()[steps], mapPane.getRoles().getNumberOfRoles(), 
                		mapPane.getCharacter());
                loadPane.setVisible(false);
                mapPane.setVisible(true);

            } catch (IOException ex) {
                System.out.println("�޷���ȡ�浵");
            } catch (ClassNotFoundException ex){
                System.out.println("�浵�ļ�����");
            }
        });

        scene.getStylesheets().add("all.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("����");
        primaryStage.show();
    }
  public static void main(String[] args){
      Application.launch(args);
  }
}