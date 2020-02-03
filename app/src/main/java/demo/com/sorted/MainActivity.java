package demo.com.sorted;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    public ArrayList<Integer> models = new ArrayList<>();
    private EditText editText;
    private Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerViewAfter);
        editText = findViewById(R.id.editText);
        final RvAdapter adapter = new RvAdapter(models);
        buttonAdd= findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num = Integer.parseInt(editText.getText().toString().trim());
                 models.add(num);
                 if(num != null) {
                     sorted(models);
                     recyclerView.getAdapter().notifyDataSetChanged();
                 }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        sorted(models);

    }

    public  void sorted(ArrayList models)
    {
        Collections.sort(models);
    }
}
