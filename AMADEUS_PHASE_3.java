package com.AMADEUS.phase;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.concurrent.atomic.AtomicInteger;


public class AMADEUS_PHASE_3 extends Application {
    public static final AtomicInteger point = new AtomicInteger(500);
    private static final int ACTIVATION_COST = 90;
    private RewardManager rewardEngine;
    private Popup popup;
    private ImageView view;
    private Image frame_01, frame_02, frame_03, frame_04, frame_05, frame_06,
            frame_07, frame_08, frame_09, frame_10, frame_11, frame_12,frame_13,frame_14,frame_15,frame_16;
    private Timeline currentAnimation;
    private int currentLevel =0;


    private static AMADEUS_PHASE_3 instance;
    private Label promptLabel ;
    private Label responseLabel;
    private Stage primaryStage;
    final double POPUP_WIDTH = 550;
    final double POPUP_HEIGHT = 550;

    public static void main(String[] args) {
        launch(args);

    }
    public static AMADEUS_PHASE_3 getInstance() {
        return instance;
    }

    //ANIMATION FOR LEVELS
    private void updateAnimationTimeline(int currentPoint) {
        final double frame_len = 900.0;
        int newLevel = 0;
        if (currentPoint >1800) {
            newLevel =4;
        }
        else if (currentPoint > 1200) {
            newLevel = 3;
        } else if (currentPoint >= 800) {
            newLevel = 2;
        } else if (currentPoint >= 500) {
            newLevel = 1;
        }
        if (newLevel == this.currentLevel) {
            return;
        }


        if (currentAnimation != null) {
            currentAnimation.stop();
        }

        this.currentLevel = newLevel;
        if(newLevel ==4){
            Timeline LEVEL_4 = new Timeline(
                    new KeyFrame(Duration.ZERO, e -> {
                        view.setImage(frame_11);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len), e -> {
                        view.setImage(frame_12);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len*2), e -> {
                        view.setImage(frame_11);
                        view.setTranslateX(0);
                    })
            );
            LEVEL_4.setCycleCount(Animation.INDEFINITE);
            currentAnimation = LEVEL_4;
            currentAnimation.play();
        }

         else if(newLevel==3) {
            Timeline LEVEL_3 = new Timeline(
                    new KeyFrame(Duration.ZERO, e -> {
                        view.setImage(frame_05);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len), e -> {
                        view.setImage(frame_06);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len * 2), e -> {
                        view.setImage(frame_07);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len * 3), e -> {
                        view.setImage(frame_08);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len * 4), e -> {
                        view.setImage(frame_09);
                    })



            );
            LEVEL_3.setCycleCount(1);
             LEVEL_3.setOnFinished(event -> {
                 Timeline LEVEL_3_1 = new Timeline(
                         new KeyFrame(Duration.ZERO, e -> {
                             view.setImage(frame_09);
                         }),
                         new KeyFrame(Duration.millis(frame_len), e -> {
                             view.setImage(frame_10);
                             view.setTranslateX(0);
                         }),
                         new KeyFrame(Duration.millis(frame_len * 2), e-> {
                             view.setImage(frame_09);
                             view.setTranslateX(0);
                         })

                         );
                 LEVEL_3_1.setCycleCount(Animation.INDEFINITE);
                 currentAnimation = LEVEL_3_1;
                 currentAnimation.play();
             });
             currentAnimation = LEVEL_3;
             currentAnimation.play();
        }
         //LEVEL 2
         else if(newLevel==2) {
             Timeline LEVEL_2 = new Timeline(
                     new KeyFrame(Duration.ZERO, e -> {
                         view.setImage(frame_03);
                         view.setTranslateX(0);
                     }),
                     new KeyFrame(Duration.millis(frame_len), e -> {
                         view.setImage(frame_04);
                         view.setTranslateX(0);
                     }),
                     new KeyFrame(Duration.millis(frame_len * 2), e -> {
                         view.setImage(frame_03);
                         view.setTranslateX(0);
                     })

             );
             LEVEL_2.setCycleCount(Animation.INDEFINITE);
             currentAnimation = LEVEL_2;
             currentAnimation.play();
         }


        //LEVEL 1
        else if(newLevel==1) {
            Timeline LEVEL_1 = new Timeline(
                    new KeyFrame(Duration.ZERO, e -> {
                        view.setImage(frame_01);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len), e -> {
                        view.setImage(frame_02);
                        view.setTranslateX(3);
                    }),
                    new KeyFrame(Duration.millis(frame_len * 2), e -> {
                        view.setImage(frame_01);
                        view.setTranslateX(0);
                    })
            );
            LEVEL_1.setCycleCount(Animation.INDEFINITE);
            currentAnimation = LEVEL_1;
            currentAnimation.play();
        }
        else{
            Timeline LEVEL_0 = new Timeline(
                    new KeyFrame(Duration.ZERO, e -> {
                        view.setImage(frame_13);
                        view.setTranslateX(0);
                    }),
                    new KeyFrame(Duration.millis(frame_len), e -> {
                        view.setImage(frame_14);
                        view.setTranslateX(0);
            }),
                    new KeyFrame(Duration.millis(frame_len * 2), e -> {
                        view.setImage(frame_13);
                        view.setTranslateX(0);
                    })
            );
            LEVEL_0.setCycleCount(15);
            LEVEL_0.setOnFinished(event -> {
                Timeline LEVEL_0_1 = new Timeline(


                new KeyFrame(Duration.ZERO, e -> {
                    view.setImage(frame_15);
                    view.setTranslateX(0);
                }),
                        new KeyFrame(Duration.millis(frame_len), e -> {
                            view.setImage(frame_16);
                            view.setTranslateX(0);
                        }),
                        new KeyFrame(Duration.millis(frame_len * 2), e -> {
                            view.setImage(frame_15);
                            view.setTranslateX(0);
                        })



               );
                LEVEL_0_1.setCycleCount(Animation.INDEFINITE);
                currentAnimation = LEVEL_0_1;
                currentAnimation.play();
            });
            currentAnimation = LEVEL_0;
            currentAnimation.play();
        }

    }

    public void safeUpdateUI(int currentPoint) {
        Platform.runLater(() -> {
            updateAnimationTimeline(currentPoint);

        });
    }

    public void triggerAnalysis() {
        //command handler
        Platform.runLater(() -> {

                    if (responseLabel == null && promptLabel == null && primaryStage == null && popup == null ) {
                        System.err.println("Error: UI components were not fully initialized in start() method.");
                        return;
                    }
                    if(currentLevel ==0){
                        System.out.println("System has fallen below the minimum threshold and will not work until the minimum threshold is met or in other words TIME OUT BIATCH");
                        return;
                    }
                    int currentPoints = point.addAndGet(-ACTIVATION_COST);
                    System.out.println("VOICE ACTIVATED: Cost of " + ACTIVATION_COST + " points deducted. New Score: " + currentPoints);
                    safeUpdateUI(currentPoints);

                    this.popup.show(primaryStage);


            responseLabel.setText("AMADEUS AI: Trigger received. Accessing clipboard...");


            AMADEUS_PHASE_2 logic = new AMADEUS_PHASE_2(responseLabel, promptLabel);
            Thread logicThread = new Thread(logic, "AMADEUS-AI-Processor");
            logicThread.setDaemon(true);
            logicThread.start();
        });
    }
    public void start(Stage worldLine) throws Exception {
        instance = this;
        this.primaryStage = worldLine;
        final double frame_len = 500.0;
        


        //images

         frame_01 = new Image("path to 0.png");
         frame_02 = new Image("path to 1.png");
         frame_03 =new Image("path to 2.png");
         frame_04 =new Image("path to 3.png");
         frame_05 = new Image("path to 3-1.png");
         frame_06= new Image("path to 3-2.png");
         frame_07 = new Image("path to 3-4.png");
         frame_08 = new Image("path to 3-5.png");
         frame_09 = new Image("path to 3-6.png");
         frame_10 = new Image("path to 3-7.png");
         frame_11 = new Image("path to 3-8.png");
         frame_12 = new Image("path to 3-9.png");
         frame_13 = new Image("path to 01.png");
        frame_14 = new Image("path to 02.png");
        frame_15 = new Image("path to 03.png");
        frame_16 = new Image("path to 04.png");

         //Exp collection
        this.rewardEngine = new RewardManager(this, point);
        rewardEngine.startPointIncrementer();

        //setting up scene

        VBox root = new VBox(); //setting up root
        root.setStyle("-fx-background-color: black;");
        Scene theatre = new Scene(root, Color.BLACK);
        view = new ImageView(frame_01);
        double imageWidth = 200;
        double imageHeight = 250;
        view.setFitWidth(imageWidth);
        view.setFitHeight(imageHeight);
        view.setX(0.0);
        view.setY(0.0);
        view.preserveRatioProperty().set(true);

        //Setting Up LAbel
         promptLabel = new Label("Copy code and relaunch to see the prompt.");
        promptLabel.setWrapText(true);
        promptLabel.setStyle(
                "-fx-text-fill: white;" +              // Set text color to WHITE
                        "-fx-font-family: 'Verdana';" +        // Use a readable font
                        "-fx-font-size: 14px;" +
                        "-fx-background-color: #0A1931;" + // Crucial for VBox background to show
                        "-fx-padding: 10;"
        );
        responseLabel = new Label("AMADEUS AI: Awaiting command...");
        responseLabel.setStyle("-fx-background-color: #24509b;" +
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Inter';" +        // Use a readable font
                "-fx-font-size: 14px;" +
                " -fx-padding: 10; " +
                "-fx-border-color: #24509b;" +
                " -fx-wrap-text: true;" +
                " -fx-font-weight: bold;");

        root.getChildren().add(view);

        updateAnimationTimeline(point.get());

        AMADEUS_VOICE_RECOG listener = new AMADEUS_VOICE_RECOG(this.instance);
        Thread listenerThread = new Thread(listener, "AMADEUS-Voice-Listener");
        listenerThread.setDaemon(true);
        listenerThread.start();

        //setting up Stage
        worldLine.setTitle("AMADEUS");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double xPos = screenBounds.getMaxX() - imageWidth;
        double yPos = screenBounds.getMaxY() - imageHeight;

        worldLine.setX(xPos);
        worldLine.setY(yPos);
        worldLine.setWidth(imageWidth);
        worldLine.setHeight(imageHeight);
        worldLine.setScene(theatre);
        worldLine.setAlwaysOnTop(true);
        worldLine.setResizable(false);

        this.popup = new Popup();
        Button closeButton = new Button("X");
        closeButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3 8 3 8;");
        closeButton.setOnAction(e -> this.popup.hide());

        Slider slider = new Slider(0, 1, 0);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickLabels(false);
        slider.setShowTickMarks(false);
        slider.setMinorTickCount(0);
        slider.setId("modern-scroll-slider");
        slider.setScaleY(-1);

        BorderPane header = new BorderPane();
        Label title = new Label("Prompt/Settings");
        title.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        header.setLeft(title);
        header.setRight(closeButton);

        promptLabel.setWrapText(true);
        promptLabel.setMaxWidth(Double.MAX_VALUE);

        ScrollPane scrollablePrompt = new ScrollPane(promptLabel);
        scrollablePrompt.setFitToWidth(true);
        scrollablePrompt.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollablePrompt.setStyle(
                "-fx-background: #0A1931; " +
                        "-fx-background-color: #0A1931; " +
                        "-fx-border-color: transparent;"
        );
        scrollablePrompt.setMaxHeight(Double.MAX_VALUE);
        scrollablePrompt.setMaxWidth(Double.MAX_VALUE);
        scrollablePrompt.setPrefHeight(0);
        scrollablePrompt.setMinHeight(0);
        scrollablePrompt.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        //scrollablePrompt.setScaleY(-1);

        ScrollPane scrollableResponse = new ScrollPane(responseLabel);
        scrollableResponse.setFitToWidth(true);
        scrollableResponse.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollableResponse.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);  // Show scrollbar when needed
        scrollableResponse.setStyle("-fx-background:#24509b; -fx-background-color: transparent;");
        scrollableResponse.setPrefHeight(0);  // Start with minimal height
        scrollableResponse.setMaxHeight(Double.MAX_VALUE);


        HBox contentArea = new HBox(5);
        contentArea.getChildren().addAll(scrollablePrompt, slider);
        HBox.setHgrow(scrollablePrompt, Priority.ALWAYS);



        VBox popupContent = new VBox(5);
        popupContent.getChildren().addAll(
                header,
                contentArea,
                scrollableResponse
        );
        VBox.setVgrow(contentArea, Priority.ALWAYS);
        VBox.setVgrow(scrollableResponse, Priority.ALWAYS);
        VBox.setVgrow(scrollablePrompt, Priority.ALWAYS);

        popupContent.setStyle("-fx-background-color: #0A1931; -fx-border-color: #b39595; -fx-border-width: 2; -fx-padding: 10;");

        // Set dimensions
        popup.setHeight(POPUP_HEIGHT);
        popup.setWidth(POPUP_WIDTH);

        // Calculate coordinates for the top-right corner of the screen
        double popupX = screenBounds.getMaxX() - POPUP_WIDTH;
        double popupY = screenBounds.getMinY();

        popupContent.setMaxWidth(POPUP_WIDTH);
        popupContent.setMaxHeight(POPUP_HEIGHT);
        popupContent.setPrefWidth(POPUP_WIDTH);
        popupContent.setPrefHeight(POPUP_HEIGHT);
        popupContent.setMinWidth(POPUP_WIDTH);
        popupContent.setMinHeight(POPUP_HEIGHT);

        // Apply position
        this.popup.setX(popupX);
        this.popup.setY(popupY);
        popupContent.getStylesheets().add(getClass().getResource("/slider.css").toExternalForm());
        slider.valueProperty().bindBidirectional(scrollablePrompt.vvalueProperty());
        popup.getContent().add(popupContent);

        worldLine.show();
    }
    @Override
    public void stop() throws Exception {
        if (rewardEngine != null) {
            rewardEngine.shutdownScheduler();
        }
        super.stop();
    }
}

