package UI.Page.DifferentPane;

import Animal.Animal;
import GameRule. GameHistory;

import GameRule.GameRule;
import GameRule.Control;
import Map.Map;
import UI.Page.AnimalImageView.AnimalImage;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.*;

import Animal.SoundControl;
import GameRule.WhetherWin;
/**
 * Created by admin on 2016/12/24.
 */
//ִ����Ϸ��������
public class MapPane extends Pane {
    private ImageView imageView;
    private Button btFunction;
    private Animal animal;
    private Map map;
    private Rectangle rectangle[][], rectangles[][], left, right;
    private GameRule rule;
    private Control control;
    private AnimalImage animalImage;
    private boolean player;
    private GameHistory history;
    private int currentStep, lastStep, nextStep;
    private FunctionPane function;
    private WinPane winner;
    private SoundControl sound;
    private WhetherWin whether;

    public MapPane() throws FileNotFoundException {
        super();

        sound = new SoundControl();
        history = new GameHistory();
        animal = new Animal();
        map = new Map();
        rule = new GameRule();
        control = new Control();
        whether = new WhetherWin();
        player = true;
        currentStep = 0;
        lastStep = 0;
        nextStep = 0;

        //�����ʼ�������������Ӫ��Ϣ
        history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
        history.saveTeamHistory(animal.getTheTeam(), currentStep);

        //����ͼƬ
        imageView = new ImageView("pic/Map3.png");
        imageView.setFitHeight(760);
        imageView.setFitWidth(1280);
        getChildren().add(imageView);

        btFunction = new Button("function");
        btFunction.setPrefHeight(50);
        btFunction.setPrefWidth(120);
        btFunction.setLayoutX(600);
        btFunction.setLayoutY(0);
        getChildren().add(btFunction);
        btFunction.setOnAction(event ->{
            function.setVisible(true);
        });

        //����rectangle��������ʾ��ǰ���
        left = new Rectangle();  //��ʾ������
        left.setFill(Color.YELLOW);
        left.setWidth(133);
        left.setHeight(113);
        left.setLayoutX(0);
        left.setLayoutY(0);
        left.setEffect(new GaussianBlur(100));
        FadeTransition ft = new FadeTransition(Duration.millis(400),left);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE
        );
        ft.play();
        left.setVisible(false);
        getChildren().add(left);

        right = new Rectangle();  //��ʾ�ҷ�����
        right.setFill(Color.YELLOW);
        right.setWidth(133);
        right.setHeight(113);
        right.setLayoutX(1134);
        right.setLayoutY(0);
        right.setEffect(new GaussianBlur(100));
        left.setEffect(new GaussianBlur(100));
        FadeTransition rg = new FadeTransition(Duration.millis(400),right);
        rg.setToValue(0.0);
        rg.setAutoReverse(true);
        rg.setCycleCount(Animation.INDEFINITE
        );
        rg.play();
        right.setVisible(false);
        getChildren().add(right);

        setPlayer(player,left, right);

        rectangle = new Rectangle[7][9]; //������ʾ������ߵķ���
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                rectangle[i][j] = new Rectangle();
                rectangle[i][j].setOpacity(0.3);
                rectangle[i][j].setFill(Color.BLUE);
                rectangle[i][j].setHeight(88);
                rectangle[i][j].setWidth(103);
                rectangle[i][j].setLayoutX(103 * j + 184);
                rectangle[i][j].setLayoutY(115 + 88 * i);
                getChildren().add(rectangle[i][j]);
                rectangle[i][j].setVisible(false);
            }
        }
        rectangles = new Rectangle[7][9];   //����ע���ѵ���Ķ���
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                rectangles[i][j] = new Rectangle();
                rectangles[i][j].setFill(Color.YELLOW);
                rectangles[i][j].setHeight(88);
                rectangles[i][j].setWidth(103);
                rectangles[i][j].setLayoutX(103 * j + 184);
                rectangles[i][j].setLayoutY(115 + 88 * i);
                getChildren().add(rectangles[i][j]);
                rectangles[i][j].setOpacity(0);
            }
        }
        control.setDisable(animal.getTheTeam(), player ,rectangles);

        animalImage = new AnimalImage(animal.getTheTeam(), animal.getNumberOfAnimal());  //add�����ͼƬ

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                animalImage.getAnimalImage()[i][j].setFitWidth(103);
                animalImage.getAnimalImage()[i][j].setFitHeight(88);
                animalImage.getAnimalImage()[i][j].setLayoutY(115 + 88 * i);
                animalImage.getAnimalImage()[i][j].setLayoutX(103 * j + 184);
                getChildren().add(animalImage.getAnimalImage()[i][j]);
            }
        }

        winner = new WinPane();
        winner.setPrefWidth(200);
        winner.setPrefHeight(100);
        winner.setLayoutY(330);
        winner.setLayoutX(530);
        getChildren().add(winner);
        winner.setVisible(false);
        winner.getBtOver().setOnAction(e ->{
            winner.setVisible(false);
        });

        function = new FunctionPane();
        function.setPrefWidth(120);
        function.setPrefHeight(510);
        function.setLayoutY(0);
        function.setLayoutX(600);
        getChildren().add(function);
        function.setVisible(false);
        function.setOnMouseExited(e ->{
            function.setVisible(false);
        });

        //���幦��
        function.getBtUndo().setOnAction(e ->{
            nextStep = currentStep;
            if(nextStep > 0){
                try {
                    history.changeMap(history.getTeamHistory()[currentStep-1], animal.getTheTeam(), history.getAnimalHistory()[currentStep-1],
                            animal.getNumberOfAnimal(), animalImage.getAnimalImage());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                nextStep = --currentStep;
                player = !player;
                setPlayer(player,left, right);
                control.setDisable(animal.getTheTeam(),player,rectangles);
            }
        });

        //�������幦��
        function.getBtRedo().setOnAction(e ->{
            nextStep = currentStep;
            if(nextStep < lastStep){
                try {
                    history.changeMap(history.getTeamHistory()[currentStep+1], animal.getTheTeam(), history.getAnimalHistory()[currentStep+1],
                            animal.getNumberOfAnimal(), animalImage.getAnimalImage());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                nextStep = ++currentStep;
                player = !player;
                setPlayer(player,left, right);
                control.setDisable(animal.getTheTeam(),player,rectangles);
            }
        });

        //���¿�ʼ����
        function.getBtRestart().setOnAction(e ->{
                    try {
                        history.changeMap(history.getTeamHistory()[0], animal.getTheTeam(), history.getAnimalHistory()[0],
                                animal.getNumberOfAnimal(), animalImage.getAnimalImage());
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    currentStep = 0;
            lastStep = 0;
            player = true;
            setPlayer(player,left, right);
            control.setDisable(animal.getTheTeam(),player,rectangles);
        });

        //�浵����
        function.getBtSave().setOnAction(e -> {
            try {
                System.out.println(getAvailableSaveCount());
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("saves/save" + getAvailableSaveCount() + ".dat"));
                output.writeObject(history);
                output.writeInt(currentStep);
                output.close();
            }catch (IOException ex) {
//                System.out.println("�޷�����浵");
                ex.printStackTrace();
            }
        });



            for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                animalImage.getAnimalImage()[i][j].addEventFilter(
                        MouseEvent.MOUSE_ENTERED_TARGET,
                        new AnimalHandler(i, j)
                );
                animalImage.getAnimalImage()[i][j].addEventFilter(
                        MouseEvent.MOUSE_EXITED_TARGET,
                        new AnimalHandlerTwo(i, j)
                );
                rectangles[i][j].addEventFilter(
                        MouseEvent.MOUSE_CLICKED,
                        new AnimalHandlerThree(i, j)
                );
            }
        }

    }

    public static int getAvailableSaveCount(){
        int i = 0;
        File f;
        do {
            i++;
            f = new File("saves/save" + i + ".dat");
        }while (f.exists());
        return i;
    }

/*��������ִ�����壬һ������ɵ�������ע�������ע������һ���棬�����һ�������ͬʱ�ı���Ӧ����Ӫ����Ͷ�������*/
   private class AnimalHandlerThree implements EventHandler<MouseEvent>{
        private int i;
        private int j;

        AnimalHandlerThree(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public void handle(MouseEvent event){
                if(control.isClick(rectangles)){
                    int k = PlaceOfVisibel(rectangles)/10;
                    int m = PlaceOfVisibel(rectangles)%10;
                    //�ж϶�������
                    if(animal.getNumberOfAnimal()[k][m] == 1){
                        if (rule.canMouseUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i == k -1 && j ==m){
                            /*�жϷ��������󣬶�player��lastStep��currentStep��������Ӫ�����ֺ�ͼƬ���в���������������ݱ�������ʷ����
                            ��ͬ
                             */
                            player = !player;
                            control.turnUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canMouseDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i == k + 1 && j==m){
                            player = !player;
                            control.turnDown(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canMouseLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j  == m - 1 && i == k){
                            player = !player;
                            control.turnLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canMouseRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j  == m + 1 && i == k){
                            player = !player;
                            control.turnRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal().clone(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam().clone(), currentStep);
                        }
                    }else if(animal.getNumberOfAnimal()[k][m] == 6 || animal.getNumberOfAnimal()[k][m] == 7){
                        if (rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                            map.getNumberOfMap()[k-1][m] == 1 && k - 3 == i && j == m) {
                            player = !player;
                            control.jumpUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else  if(k - 1 == i && map.getNumberOfMap()[k-1][m] != 1 && j == m &&
                                rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)){
                            player = !player;
                                 control.turnUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                            } else if (rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                map.getNumberOfMap()[k+1][m] == 1 && k + 3 == i && j == m) {
                            player = !player;
                            control.jumpDowwn(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        } else if(k + 1 == i && map.getNumberOfMap()[k+1][m] != 1 && j == m &&
                                rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)) {
                            player = !player;
                            control.turnDown(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if (rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                 map.getNumberOfMap()[k][m-1] == 1 && m - 4 == j && i == k) {
                            player = !player;
                            control.jumpLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        } else  if(m - 1 == j && map.getNumberOfMap()[k][m-1] != 1 && i == k &&
                                rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)) {
                            player = !player;
                            control.turnLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        } else if (rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                map.getNumberOfMap()[k][m+1] == 1 && m + 4 == j && i == k) {
                            player = !player;
                            control.jumpRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else  if(m + 1 == j && map.getNumberOfMap()[k][m+1] != 1 && i == k &&
                                rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m)) {
                            player = !player;
                            control.turnRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k, m, player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }
                    } else{
                        if (rule.canNormalUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i  == k - 1 && j == m){
                            player = !player;
                            control.turnUp(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canNormalDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                i  == k + 1 && j == m){
                            player = !player;
                            control.turnDown(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canNormalLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j == m - 1 && i == k){
                            player = !player;
                            control.turnLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }else if(rule.canNormalRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), k, m) &&
                                j == m + 1 && i == k){
                            player = !player;
                            control.turnRight(animal.getTheTeam(), animal.getNumberOfAnimal(), animalImage.getAnimalImage(), k ,m,player);
                            lastStep = ++currentStep;
                            history.saveAnimalHistory(animal.getNumberOfAnimal(), currentStep);
                            history.saveTeamHistory(animal.getTheTeam(), currentStep);
                        }
                    }
                    //ÿ�ε��ʱ�����ԭ�ȱ�����ı�־�������ÿɵ���Ķ���
                    rectangles[k][m].setOpacity(0);
                    control.setDisable(animal.getTheTeam(), player, rectangles);
                }else if(animal.getNumberOfAnimal()[i][j] != 0) {
                    //����������Ķ��󣬲����ÿɵ���Ķ��󣬵��ʱ���Ŷ�����Ч
                    rectangles[i][j].setOpacity(0.4);
                    sound.play(animal.getNumberOfAnimal()[i][j] - 1);
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 9; j++) {
                            rectangles[i][j].setDisable(false);
                        }
                    }
                }
           setPlayer(player,left, right);

            //�ж��ҷ��Ƿ�ʤ��
            if(whether.leftCannotMove(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap()) ||
                    whether.leftDiedOut(animal.getTheTeam()) || whether.rightEnter(animal.getTheTeam())){
                winner.setVisible(true);
                winner.getLable1().setVisible(true);
                winner.getLable2().setVisible(false);
                for(int i = 0; i < 7; i++){
                    for (int j = 0; j < 9; j++){
                        rectangles[i][j].setDisable(true);
                    }
                }
            }

            //�ж����Ƿ�ʤ��
            if(whether.rightCannotMove(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap()) ||
                    whether.rightDiedOut(animal.getTheTeam()) || whether.leftEnter(animal.getTheTeam())){
                winner.setVisible(true);
                winner.getLable1().setVisible(false);
                winner.getLable2().setVisible(true);
                for(int i = 0; i < 7; i++){
                    for (int j = 0; j < 9; j++){
                        rectangles[i][j].setDisable(true);
                    }
                }
            }
        }

    }

/* inner class ������Ҫ���ڵ���꾭��ĳһ�����Ϸ�ʱ�Զ��ı����ö�������ߵķ���
*/
   private class AnimalHandlerTwo implements EventHandler<MouseEvent> {
        private int i;
        private int j;

        AnimalHandlerTwo(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void handle(MouseEvent event) {
            //�ж϶�������
            if (animal.getNumberOfAnimal()[i][j] == 1) {
                if (rule.canMouseUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    //����������ʱ������Ӧλ��������ʾ��rectangle����ͬ
                    rectangle[i - 1][j].setVisible(false);
                }
                if (rule.canMouseDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(false);
                }
                if (rule.canMouseLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(false);
                }
                if (rule.canMouseRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(false);
                }
            } else if (animal.getNumberOfAnimal()[i][j] == 6 || animal.getNumberOfAnimal()[i][j] == 7) {
                if (rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i - 1][j] == 1) {
                        rectangle[i - 3][j].setVisible(false);
                    } else
                        rectangle[i - 1][j].setVisible(false);
                }
                if (rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i + 1][j] == 1) {
                        rectangle[i + 3][j].setVisible(false);
                    } else
                        rectangle[i + 1][j].setVisible(false);
                }
                if (rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j - 1] == 1) {
                        rectangle[i][j - 4].setVisible(false);
                    } else
                        rectangle[i][j - 1].setVisible(false);
                }
                if (rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j + 1] == 1) {
                        rectangle[i][j + 4].setVisible(false);
                    } else
                        rectangle[i][j + 1].setVisible(false);
                }
            } else {
                if (rule.canNormalUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i - 1][j].setVisible(false);
                }
                if (rule.canNormalDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(false);
                }
                if (rule.canNormalLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(false);
                }
                if (rule.canNormalRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(false);
                }
            }
        }
    }

    /*inner class ������Ҫ���ڵ�����뿪ĳ����ʱ��֮ǰ������ʾ�������ı������
     */
    private class AnimalHandler implements EventHandler<MouseEvent> {
        private int i;
        private int j;

        AnimalHandler(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void handle(MouseEvent event) {
            //�ж϶�������
            if (animal.getNumberOfAnimal()[i][j] == 1) {
                if (rule.canMouseUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    //������뿪�ö���ʱ�������Ӧ�ı�־����ͬ
                    rectangle[i - 1][j].setVisible(true);
                }
                if (rule.canMouseDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(true);
                }
                if (rule.canMouseLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(true);
                }
                if (rule.canMouseRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(true);
                }
            } else if (animal.getNumberOfAnimal()[i][j] == 6 || animal.getNumberOfAnimal()[i][j] == 7) {
                if (rule.canTigerUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i - 1][j] == 1) {
                        rectangle[i - 3][j].setVisible(true);
                    } else
                        rectangle[i - 1][j].setVisible(true);
                }
                if (rule.canTigerDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i + 1][j] == 1) {
                        rectangle[i + 3][j].setVisible(true);
                    } else
                        rectangle[i + 1][j].setVisible(true);
                }
                if (rule.canTigerLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j - 1] == 1) {
                        rectangle[i][j - 4].setVisible(true);
                    } else
                        rectangle[i][j - 1].setVisible(true);
                }
                if (rule.canTigerRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    if (map.getNumberOfMap()[i][j + 1] == 1) {
                        rectangle[i][j + 4].setVisible(true);
                    } else
                        rectangle[i][j + 1].setVisible(true);
                }
            } else {
                if (rule.canNormalUp(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i - 1][j].setVisible(true);
                }
                if (rule.canNormalDown(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i + 1][j].setVisible(true);
                }
                if (rule.canNormalLeft(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j - 1].setVisible(true);
                }
                if (rule.canNormalRight(animal.getTheTeam(), animal.getNumberOfAnimal(), map.getNumberOfMap(), i, j)) {
                    rectangle[i][j + 1].setVisible(true);
                }
            }
        }

    }

    //��ȡ��ǰ������Ķ����λ����Ϣ
    private int PlaceOfVisibel(Rectangle[][] rectangle){
        int i, j;
        for( i = 0; i < 7; i++){
            for( j = 0; j < 9; j++){
                if(rectangle[i][j].getOpacity() > 0.3)
                    return (10 * i + j);
            }
        }
        return -1;
    }

    public FunctionPane getFunction(){
        return function;
    }
    public Animal getAnimal(){
        return animal;
    }
    public  AnimalImage getAnimalImage(){
        return animalImage;
    }

    //��������л�����ʾ
    private  void setPlayer(boolean player, Rectangle left, Rectangle right){
        if (player) {
            left.setVisible(true);
            right.setVisible(false);
        } else {
            right.setVisible(true);
            left.setVisible(false);
        }
    }

}

