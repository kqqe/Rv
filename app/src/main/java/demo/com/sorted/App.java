package demo.com.sorted;

import android.app.Application;

public class App extends Application {

    private Model model = new Model();

    public Model getModel() {
        return model;
    }
}
