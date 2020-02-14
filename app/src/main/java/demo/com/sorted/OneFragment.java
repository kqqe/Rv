package demo.com.sorted;

import android.content.Intent;
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
import java.util.List;

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private ArrayList<Integer> models = new ArrayList<>();
    private EditText editText;
    private Button buttonAdd;
    private Button changeItem;

    public final static  String TAG = "OneFragmentTag";

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.one_fragment, container,false);

        recyclerView= view.findViewById(R.id.RvBefore);
        editText = view.findViewById(R.id.editTextAddNumber);
        final RvAdapter adapter = new RvAdapter(models);
        buttonAdd= view.findViewById(R.id.buttonAddFrgOne);
        changeItem = view.findViewById(R.id.changeItem);
        manager = getFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("kek", models);
        final TwoFragment twoFragment = new TwoFragment();
        twoFragment.setArguments(bundle);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num = Integer.parseInt(editText.getText().toString().trim());
                models.add(num);
                if(num != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();

                }
            }
        });

        changeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = manager.beginTransaction();
                if (manager.findFragmentByTag(OneFragment.TAG) != null) {
                    transaction.replace(R.id.container, twoFragment, TwoFragment.TAG);
                }
                transaction.commit();
            }

        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

}
