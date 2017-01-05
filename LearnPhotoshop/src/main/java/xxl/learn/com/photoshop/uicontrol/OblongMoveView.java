package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xxl on 16/3/31.
 */
public class OblongMoveView extends ImageView {
    private Canvas canvas;
    private int speed=500;  //每隔多长时间变换一次
    private Rect rect;
    private Paint paint;
    public OblongMoveView(Context context) {
        super(context);
    }

    public OblongMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OblongMoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect=canvas.getClipBounds();
        paint=new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
    }



    public void setMove(){
        Animation sIn = new ScaleAnimation(1f, 0, 1f, 1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f);
        sIn.setDuration(OblongMoveView.this.getLayoutParams().width * 10);
        sIn.setFillAfter(true);
        OblongMoveView.this.startAnimation(sIn);
    }

    public void stop(){

    }
}
