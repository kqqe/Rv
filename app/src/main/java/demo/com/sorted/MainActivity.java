package demo.com.sorted;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {


    private OneFragment oneFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        oneFragment = new OneFragment();

        transaction = manager.beginTransaction();
        transaction.add(R.id.container, oneFragment, OneFragment.TAG);
        transaction.commit();
    }

}
