package demo.com.sorted;

import java.util.ArrayList;

class PresenterOne {
    private Model model;
    private OneFragment oneFragment;

    public PresenterOne(Model model){
        this.model = model;
    }

    public void setOneFragment(OneFragment oneFragment) {
        this.oneFragment = oneFragment;
    }

    public void OnButtonClicked(Integer num){
        model.setNumder(num);
        ArrayList<Integer> list = model.getNumder();
        oneFragment.onListChanged(list);
    }

    public void onViewCreate() {
        oneFragment.onListChanged(model.getNumder());
    }

    //для/ каждой вьюхи свой перзентор, ска.!!!! а модель общая.
}
