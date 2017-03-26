package UI.Page.DifferentPane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by admin on 2016/12/24.
 */

//��������
public class HelpPane extends Pane{
    Label helpInformation;
    ImageView imageView;
    Button bt1;
    String s1;
    public HelpPane(){
        super();
        imageView = new ImageView("pic/HelpPage.jpg");
        imageView.setFitWidth(1280);
        imageView.setFitHeight(760);

        getChildren().add(imageView);
        bt1 = new Button(("������ҳ��"));

        bt1.setLayoutX(600);
        bt1.setLayoutY(650);

        getChildren().add(bt1);

        s1 = "����������� ����������̺����У��ݾ��У����ӷ��ڸ����С�˫�������߸���" + "\n"  +
                "�������壨��Ʒ���ţ���һ����Ѩ(��Ʒ���м�)�� �����в�����Ƭˮ�򣬳�֮ΪС�ӡ�" +"\n" + "\n" +
                "����������� ���������ӹ�ʮ��������Ϊ����˫����˫�����а�ֻһ�������ӣ��³�Ϊ��" +"\n" +
                "�� �� ���������ս����ǿ������Ϊ����>ʨ>��>��>��>��>è>��" + "\n" + "\n" +
                "��������߷� ��Ϸ��ʼʱ���췽���ߣ�Ȼ���������塣ÿ�ο��߶�һֻ�ޣ�ÿֻ��ÿ��" + "\n" +
                "��һ���񣬳�������Ѩ��С�����⣬ǰ�����Ҿ��ɡ����ǣ�ʨ���������в�ͬ�߷���" + "\n" + "\n" +
                "ʨ�����ӷ���ʨ����С�ӱ�ʱ�������ݺ��ֱ����С�ӣ����ܰ�С�Ӷ԰��ĵз���С����" + "\n" +
                "��Ե�����������Է������ں��������·������Ͳ����������԰��ǶԷ����Լ�ս����" + "\n" +
                "ǰ���ޣ�Ҳ����������С�ӣ�" + "\n" + "\n" +
                "���ι��ӷ�������Ψһ��������С�ӵ��ޣ��߷�ͬ½����һ����ÿ����һ���������Ҿ�" + "\n" +
                "�ɣ����ң�½���ϵ������޲����Գ�С���е���С���е���Ҳ���ܳ�½���ϵ������໥" + "\n" +
                "�Բ���С��Ӱ�졣\n" + "\n" +
                "������ĳԷ� ������Է�����ͨ�Է�������˷�����ͨ�Է��ǰ����޵�ս����ǿ����ǿ��" + "\n" +
                "���Գ����ߡ� ����Է����£� 1������󷨣����޵ĳԷ�������ս����ǿ�������⣬Ω��" + "\n" +
                "�ܳ������ܳ��� 2�����Է�����ͬ���������ɻ���ԡ� 3�����壺���������壬רΪ" + "\n" +
                "���Ƶ��޵�ս�������Լ����ޣ��������ƣ��������������壬��ʧȥս������������������" + "\n" +
                "�඼���Գ�ȥ����������ࡣ �ۺ���ͨ�Է�������Է�����������˷��ܽ����£�\n" + "\n" +
                "����Գ����� è���Գ�è���� �ǿ��Գ��ǡ�è���� �����ԳԹ����ǡ�è���� ����" + "\n" +
                "�ԳԱ��������ǡ�è���� �����ԳԻ������������ǡ�è���� ʨ���Գ�ʨ��������������" + "\n" +
                "�ǡ�è���� ����Գ���ʨ���������������ǡ�è��";

        helpInformation = new Label(s1);
        helpInformation.setPadding(new Insets(20,20,20,20));
        helpInformation.setLayoutX(100);
        helpInformation.setLayoutY(50);
        getChildren().add(helpInformation);
    }

    public ImageView getImageView(){
        return imageView;
    }
    public Button getBt1(){
        return bt1;
    }
    public  String getS1(){
        return  s1;
    }
}



