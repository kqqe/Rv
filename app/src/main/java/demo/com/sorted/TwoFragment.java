package demo.com.sorted;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class TwoFragment extends Fragment {

    private OneFragment oneFragment = new OneFragment();

    public ArrayList<Integer> models = getArguments().getIntegerArrayList("kek");

    private RecyclerView recyclerView;


    public final static  String TAG = "TwoFragmentTag";

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two_fragment, container,false);
        ///?????
        recyclerView= view.findViewById(R.id.RvAfter);
        final RvAdapter adapter = new RvAdapter(models);
        sorted(models);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public  void sorted(ArrayList models)
    {
        Collections.sort(models);
    }

}
