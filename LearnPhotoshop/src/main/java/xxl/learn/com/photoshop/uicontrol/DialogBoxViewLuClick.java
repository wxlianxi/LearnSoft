package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import xxl.learn.com.photoshop.R;

/**
 * Created by xxl on 16/4/9.
 */
public class DialogBoxViewLuClick extends FrameLayout {
    private TextView textView;
    private ImageView imageView;
    public DialogBoxViewLuClick(Context context) {
        super(context);
        initView(context);
    }

    public DialogBoxViewLuClick(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DialogBoxViewLuClick(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        View.inflate(context, R.layout.uicontrol_dialogbox_lu_click,this);
        //LayoutInflater.from(context).inflate(R.layout.uicontrol_dialogbox_lu_click,this,true);
        textView=(TextView)findViewById(R.id.dialogText_lu_click);
        imageView=(ImageView) findViewById(R.id.dialogImage_lu_click);
    }
    public void setTextView(String string){
        textView.setText(string);

    }


}
