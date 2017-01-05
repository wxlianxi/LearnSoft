package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import xxl.learn.com.photoshop.R;

/**
 * Created by xxl on 16/4/8.
 */
public class DialogBoxViewLu extends RelativeLayout{
    private TextView textView;
    public DialogBoxViewLu(Context context) {
        super(context);
        initView(context);
    }

    public DialogBoxViewLu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DialogBoxViewLu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.uicontrol_dialogbox_lu,this);
        textView=(TextView)findViewById(R.id.dialogText_lu);
    }
    public void setTextView(String string){
        textView.setText(string);
    }
}
