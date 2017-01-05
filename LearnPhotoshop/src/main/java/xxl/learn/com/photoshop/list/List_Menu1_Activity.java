package xxl.learn.com.photoshop.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xxl.learn.com.photoshop.BaseListActivity;
import xxl.learn.com.photoshop.R;

public class List_Menu1_Activity extends BaseListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_menu1);
        //baseSetContentView(R.layout.activity_list_menu1);


        mMap=new HashMap<String,Object>();
        mMap.put("title","shenmeng3");
        mMap.put("img","jdj");
        mMap.put("url", "xxl.learn.com.photoshop.menu.menu1.Menu1_Lesson1_Activity");
        mList.add(mMap);

        mMap=new HashMap<String,Object>();
        mMap.put("title","shenmeng4");
        mMap.put("img","dkdk");
        mMap.put("url", "xxl.learn.com.photoshop.menu.menu1.Menu1_Lesson1_Activity");
        mList.add(mMap);


        //创建适配器
        mAdapter=new SimpleAdapter(this,mList,R.layout.item_base_list,mFrom,mTo);

        mListView.setAdapter(mAdapter);

    }





    //元素的缓冲类 用于优化listview
    private static class ItemCache{
        public TextView mTextView;
        public ImageView mImageView;
    }



}
