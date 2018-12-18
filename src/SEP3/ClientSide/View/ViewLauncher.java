package SEP3.ClientSide.View;

import javafx.application.Application;

public class  ViewLauncher implements Runnable {

    private Application application;

    /**
     * ViewLauncher constructor which takes
     * Application object as argument
     * @param application Application object
     */
    public ViewLauncher(Application application)
    {
        this.application = application;
    }

    /**
     * run method which starts the user
     * interface when the ViewLauncher constructor
     * is called in GUI class
     */
    @Override
    public void run()
    {
        Application.launch(application.getClass());
    }
}
