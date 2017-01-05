package xxl.learn.com.photoshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xxl.learn.com.photoshop.menu.menu1.Menu1_Lesson1_Activity;

public class BaseListActivity extends AppCompatActivity {
    private LinearLayout activityContent; //继承该类的activity的layout

    protected ListView mListView;
    protected List<Map<String,Object>> mList;
    protected Map<String,Object> mMap;
    protected SimpleAdapter mAdapter;

    protected String[] mFrom=new String[]{"title","img"};
    protected int[] mTo=new int[]{R.id.itembaselisttextview,R.id.itembaselistimageview};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_list);

        mListView=(ListView)findViewById(R.id.baselistlistview);

        mList=new ArrayList<Map<String, Object>>();
        mMap=null;

        mMap=new HashMap<String,Object>();
        mMap.put("title","shenmeng1");
        mMap.put("img","jdj");
        mMap.put("url", "xxl.learn.com.photoshop.menu.menu1.Menu1_Lesson1_Activity");
        mList.add(mMap);

        mMap=new HashMap<String,Object>();
        mMap.put("title","shenmeng2");
        mMap.put("img","dkdk");
        mMap.put("url", "xxl.learn.com.photoshop.menu.menu1.Menu1_Lesson1_Activity");
        mList.add(mMap);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent=new Intent(BaseListActivity.this,mList.get(position).get("url").getClass());
                //Intent intent=new Intent(BaseListActivity.this,Menu1_Lesson1_Activity.class);
                Intent intent=new Intent();
                intent.setClassName(BaseListActivity.this,mList.get(position).get("url").toString());
                startActivity(intent);
            }
        });


    }

    //为继承BaseActivity的Activity设置layout
    public void baseSetContentView(int layoutId){
        activityContent=(LinearLayout)findViewById(R.id.baselistcontent);
        //获得inflater
        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //把继承该BaseActivity的layoutId放进来显示
        View view=inflater.inflate(layoutId,null);
        //addview
        activityContent.addView(view);
    }


}
