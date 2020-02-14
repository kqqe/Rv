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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class TwoFragment extends Fragment {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private ArrayList<Integer> models;

    private RecyclerView recyclerView;

    private Button buttonBack;

    public final static  String TAG = "TwoFragmentTag";

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two_fragment, container,false);
        models = (ArrayList<Integer>) getArguments().getIntegerArrayList("kek");
        buttonBack = view.findViewById(R.id.buttonBack);
        manager = getFragmentManager();
        recyclerView= view.findViewById(R.id.RvAfter);
        final RvAdapter adapter = new RvAdapter(models);
        sorted(models);
        final OneFragment oneFragment = new OneFragment();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = manager.beginTransaction();
                if (manager.findFragmentByTag(TwoFragment.TAG) != null) {
                    transaction.replace(R.id.container, oneFragment, OneFragment.TAG);
                }
                transaction.commit();
            }

        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public  void sorted(ArrayList models)
    {
        Collections.sort(models);
    }

}
