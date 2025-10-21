package com.AMADEUS.phase;
import com.google.genai.types.GenerateContentConfig;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class AMADEUS_PHASE_2 implements Runnable {
    private final Label responseLabel;
    private final Label promptLabel;
    public AMADEUS_PHASE_2(Label responseLabel, Label promptLabel) {
        this.responseLabel = responseLabel;
        this.promptLabel = promptLabel;
    }
    static {
        try {
            if (!GraphicsEnvironment.isHeadless()) {
                Toolkit.getDefaultToolkit();
            }
        } catch (Exception e) {
            System.err.println("WARNING: Failed to initialize AWT Toolkit. Clipboard access may fail.");
        }
    }

    public String ClipBoardContent(){
        String Request = null;
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                Request = (String) clipboard.getData(DataFlavor.stringFlavor);
            }
        } catch (UnsupportedFlavorException | IOException e) {
            System.err.println("Clipboard access failed: " + e.getMessage());
        }
        return Request;
    }

    public String GenAI(String Request) {
        Client AMADEUS = Client.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))

                .build();

        //configs
        GenerateContentConfig config = GenerateContentConfig.builder()
                .temperature(0.5f)
                .maxOutputTokens(8000)
                .topP(0.5f)
                .build();


        GenerateContentResponse response =
                AMADEUS.models.generateContent(
                        "gemini-2.5-flash",
                        Request,
                        config);
        return response.text();


    }


    @Override
    public void run() {
        System.out.println("--- AI TASK STARTED (Standard Runnable) ---");

        try {
            // 1. API Key Check
            String apiKey = System.getenv("GEMINI_API_KEY");
            if (apiKey == null || apiKey.trim().isEmpty()) {
                Platform.runLater(() -> responseLabel.setText("ERROR: GEMINI_API_KEY environment variable is missing."));
                System.err.println("ERROR: GEMINI_API_KEY environment variable is missing. Cannot proceed.");
                return; // Exit thread
            }


            String request = ClipBoardContent();
            if (request == null) {
                Platform.runLater(() -> responseLabel.setText("AMADEUS AI: Clipboard is empty. Please copy text and say 'Arise'."));
                System.out.println("INFO: No content found on clipboard. Exiting AI Task.");
                return; // Exit thread if clipboard is empty
            }


            String context = "You're going to receive a code snippet or request. Analyze it for potential bugs, suggest improvements, keep the word count under 1000 words.If the code has no major flaws just say that, It could use some improvement but all things are just fine.DO NOT MENTION ANY OF THIS IN THE RESPONSE";
            String prompt = context + " Snippet/Request: " + request;
            Platform.runLater(() -> {
                promptLabel.setText("PROMPT: " + request);
                responseLabel.setText("AMADEUS AI: Starting analysis...");
            });



            String response = GenAI(prompt);


            Platform.runLater(() -> responseLabel.setText("AMADEUS AI: " + response));
            System.out.println("\n--- AMADEUS AI ANALYSIS COMPLETE ---\n");


        } catch (Exception e) {

            System.err.println("\n*** AMADEUS AI Task Failed ***");
            System.err.println("Error during execution: " + e.getMessage());
            e.printStackTrace();
        }


        }
}
