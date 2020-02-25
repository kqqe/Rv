package demo.com.sorted;

import java.util.ArrayList;
import java.util.Collections;

class Model {
    private ArrayList<Integer> numder = new ArrayList<>();

    ArrayList<Integer> getNumder() {
        return numder;
    }

    void setNumder(Integer num) {
            numder.add(num);
    }

    ArrayList<Integer> getSorted(){
        Collections.sort(numder);
        return numder;
    }
}
