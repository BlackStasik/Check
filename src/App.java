import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{

    Check check = new Check();

    String good;
    double price = 0;
    int num = 0;
    double sum = 0;
    double ppp = 0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Чек");

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(25, 25, 25, 25));

        TextField goods = new TextField();
        goods.setPromptText("Товар...");
        goods.setMinSize(210, 20);
        TextField prise = new TextField();
        prise.setPromptText("Ціна...");
        TextField number = new TextField();
        number.setPromptText("Кількість...");
        number.setMinSize(70, 20);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setSpacing(15);
        hBox.getChildren().addAll(goods,prise,number);

        Button button = new Button("Додати в чек");
        button.setAlignment(Pos.CENTER);

        Label label = new Label("Сума чеку: ");

        HBox hBox1 = new HBox();
        hBox1.setSpacing(15);
        hBox1.getChildren().addAll(button,label);

        TextField money = new TextField();
        money.setPromptText("Заплатити...");
        money.setMinSize(120, 20);

        Button pay = new Button("Заплатити.");

        HBox h = new HBox();
        h.setSpacing(15);
        h.getChildren().addAll(money,pay);

        VBox box = new VBox();
        box.setSpacing(15);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(hBox,hBox1,h);

        pane.setTop(box);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                good = goods.getText();
                goods.setText("");
                price = Double.parseDouble(prise.getText());
                prise.setText("");
                num = Integer.parseInt(number.getText());
                number.setText("");
                price = price * num;
                sum += price;
                label.setText("Сума чеку: " + sum);
                check.write(good,price,num);
            }
        });

        pay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ppp = Double.parseDouble(money.getText());
                label.setText("Сума чеку: 0");
                check.getCheck(ppp);
            }
        });

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
