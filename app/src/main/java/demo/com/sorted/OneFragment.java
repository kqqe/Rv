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

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private EditText editText;
    final static  String TAG = "OneFragmentTag";

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.one_fragment, container,false);
        App app = (App)getActivity().getApplicationContext();
        Model model = app.getModel();
        final PresenterOne presenterOne = new PresenterOne(model);
        presenterOne.setOneFragment(this);
        recyclerView= view.findViewById(R.id.RvBefore);
        editText = view.findViewById(R.id.editTextAddNumber);
        Button buttonAdd= view.findViewById(R.id.buttonAddFrgOne);
        Button changeItem = view.findViewById(R.id.changeItem);
        manager = getFragmentManager();

        final TwoFragment twoFragment = new TwoFragment();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num = Integer.parseInt(editText.getText().toString().trim());
                presenterOne.OnButtonClicked(num);
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
        presenterOne.onViewCreate();
        return view;
    }

    public void onListChanged(ArrayList<Integer> list) {
        if (recyclerView.getAdapter() != null){
            recyclerView.getAdapter().notifyDataSetChanged();
        }else {
            RvAdapter adapter = new RvAdapter(list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }


    }
}
