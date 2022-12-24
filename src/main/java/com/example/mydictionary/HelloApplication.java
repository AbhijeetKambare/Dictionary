package com.example.mydictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    Label meaningLabel;
    TextField wordTextField;
    Button searchButton;
    ListView suggestionList;

    DictionaryUsingHashmap dictionaryUsingHashmap =new DictionaryUsingHashmap();
    Pane createContent(){
        Pane root=new Pane();    //blank window'
        root.setPrefSize(500,500); //fixing the size of window

        TextField wordTextfield=new TextField();  //its like texbox
        wordTextfield.setTranslateX(20);
        wordTextfield.setTranslateY(20);

        Button searchButton=new Button("Search ");  //button to execute
        searchButton.setTranslateX(300);
        searchButton.setTranslateY(20);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               // meaningLabel.setText("Button is Clicked");
                String word= wordTextfield.getText();
                if(word.isBlank() || word.isEmpty()){
                    meaningLabel.setText("please Enter A valid ");
                    meaningLabel.setTextFill(Color.RED);
                }else
                {
                    String meaning = dictionaryUsingHashmap.getMeaning(word);
                    meaningLabel.setText(meaning);
                    meaningLabel.setTextFill(Color.BLACK);
                }
            }
        });
        meaningLabel =new Label("this is a Result");  //to dispaly searched word
        meaningLabel.setTranslateX(20);
        meaningLabel.setTranslateY(60);

        suggestionList=new ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(100);
        suggestionList.setMinSize(330,50);
        suggestionList.setMaxSize(300,50);
        String [] wordList ={"anand","abhi","ravi","rahul"};
        //fetch from database or trie
        suggestionList.getItems().addAll(wordList);
        suggestionList.setOrientation(Orientation.HORIZONTAL);

        suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selectedWord= (String) suggestionList.getSelectionModel().getSelectedItem();
                meaningLabel.setText(selectedWord);
                //on click find meaning and dsiplay it
            }
        });
        root.getChildren().addAll(wordTextfield,searchButton,meaningLabel,suggestionList);
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}