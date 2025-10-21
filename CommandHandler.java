package com.AMADEUS.phase;


public class CommandHandler {
    public void processHandler(String Command) {
        if (Command.equalsIgnoreCase("ARISE")) {
            AMADEUS_PHASE_3 logic = AMADEUS_PHASE_3.getInstance();
            if (logic != null) {
                System.out.println("Triggering AI analysis via UI.");
                logic.triggerAnalysis();
            } else {
                System.err.println("Error: AMADEUS_PHASE_3 UI is not running or not initialized.");
            }
            System.out.println("Logic Check");
        }
    }
}
