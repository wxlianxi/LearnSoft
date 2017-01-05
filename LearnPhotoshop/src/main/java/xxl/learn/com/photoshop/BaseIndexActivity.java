package xxl.learn.com.photoshop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import xxl.learn.com.photoshop.list.List_Menu1_Activity;

public class BaseIndexActivity extends AppCompatActivity {
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_index);
        bt1=(Button)findViewById(R.id.index_button_1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaseIndexActivity.this,List_Menu1_Activity.class);
                startActivity(intent);
            }
        });

    }

}
