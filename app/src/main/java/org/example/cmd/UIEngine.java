package org.example.cmd;

import org.example.IBankApp;

import lombok.Builder;

@Builder
public class UIEngine {
    private IBankApp bankApp;
    private IBankScreen currentScreen;

    public void run() {

        Context.getInstance().setBankApp(bankApp);

        while (currentScreen != null) {
            currentScreen.show();
            currentScreen = currentScreen.next();
        }
    }

}
