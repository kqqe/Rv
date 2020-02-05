package demo.com.sorted;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends FragmentActivity {


    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private Switch isBackStack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        isBackStack = (Switch)findViewById(R.id.switchBackStack);// попробовать без каста!
    }

        public void onClickFragment(View view) {
            transaction = manager.beginTransaction();

            switch (view.getId()) {

                case R.id.buttonAddFrgOne:
                    if (manager.findFragmentByTag(OneFragment.TAG) == null) {
                        transaction.add(R.id.container, oneFragment, OneFragment.TAG);
                    }
                    break;
                case R.id.buttonDelete:
                    if (manager.findFragmentByTag(OneFragment.TAG) != null) {
                        transaction.remove(oneFragment);
                    }
                    break;
                case R.id.buttonReplace:
                    if (manager.findFragmentByTag(OneFragment.TAG) != null) {
                        transaction.replace(R.id.container, twoFragment, TwoFragment.TAG);
                    }
                    if (manager.findFragmentByTag(TwoFragment.TAG) != null) {

                        transaction.replace(R.id.container, oneFragment, OneFragment.TAG);
                    }
                    break;
            }
            if (isBackStack.isChecked()) {
                transaction.addToBackStack(null);
             }

            transaction.commit();
    }




    public  void sorted(ArrayList models)
    {
        Collections.sort(models);
    }

}
