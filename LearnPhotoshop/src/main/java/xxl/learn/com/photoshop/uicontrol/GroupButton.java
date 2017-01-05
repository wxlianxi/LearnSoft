package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import xxl.learn.com.photoshop.R;

/**
 * Created by xxl on 16/3/31.
 */
public class GroupButton extends LinearLayout {
    private TextView textView;
    private CircleIcoBackView img;
    public GroupButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public GroupButton(Context context) {
        super(context);
        initView(context);
    }

    public GroupButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.uicontrol_index_group_button,this);
        textView=(TextView)findViewById(R.id.uigbTv);
        img=(CircleIcoBackView)findViewById(R.id.uigbCibv);
    }

    public void setImg(int id){
        img.setBackgroundResource(id);
    }
    public void setTextView(String string){
        textView.setText(string);
    }
}
