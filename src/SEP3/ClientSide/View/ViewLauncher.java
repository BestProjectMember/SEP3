package SEP3.ClientSide.View;

import javafx.application.Application;

public class ViewLauncher implements Runnable {

    private Application view;

    /**
     * ViewLauncher constructor which takes
     * Application object as argument
     * @param view Application object
     */
    public ViewLauncher(Application view)
    {
        this.view = view;
    }

    /**
     * run method which starts the user
     * interface when the ViewLauncher constructor
     * is called in GUI class
     */
    @Override
    public void run()
    {
        Application.launch(view.getClass());
    }
}
