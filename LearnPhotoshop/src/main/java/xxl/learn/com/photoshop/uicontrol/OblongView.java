package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;


import java.util.Timer;
import java.util.TimerTask;

import xxl.learn.com.photoshop.R;

/**
 * TODO: document your custom view class.
 */
public class OblongView extends ImageView {
    private int speed=800;  //每隔多长时间变换一次
    private float start=0.3f;
    private float end=0.8f;
    private int ficker=1;
    private Timer timer;
    private Animation aIn;

    public OblongView(Context context) {
        super(context);

    }

    public OblongView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public OblongView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        this.setAlpha(start);
        Rect rect=canvas.getClipBounds();
        System.out.println(rect);
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);

        //System.out.println("start..");


        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg=new Message();
                //System.out.println("top");
                //System.out.println(msg.what);
                handler.sendMessage(msg);
            }
        },0,speed);


    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //System.out.println(OblongView.this.getAlpha());
            if(ficker==1){
                ficker=2;
                //aIn = new AlphaAnimation(start,end);
                //aIn.setDuration(speed-500);
                //aIn.setFillAfter(true);
                //OblongView.this.startAnimation(aIn);
                OblongView.this.setAlpha(end);
            }else if (ficker==2){
                ficker=1;
                //aIn = new AlphaAnimation(end,start);
                //aIn.setDuration(speed-500);
                //aIn.setFillAfter(true);
                //OblongView.this.startAnimation(aIn);
                OblongView.this.setAlpha(start);
            }
        }
    };

    public void stop(){
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }
}
