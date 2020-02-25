package demo.com.sorted;

import java.util.ArrayList;

public class PresenterTwo {
    private Model model;
    private TwoFragment twoFragment;

    public PresenterTwo(Model model) {
        this.model = model;
    }// передать фрагмент еще.

    public void setPresentorTwo(TwoFragment twoFragment) {
        this.twoFragment = twoFragment;
    }

    public void onViewCreate() {
        ArrayList<Integer> list = model.getSorted();
        twoFragment.onListChanged(list);
    }
}
