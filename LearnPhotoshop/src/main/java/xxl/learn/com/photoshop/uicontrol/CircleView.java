package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import xxl.learn.com.photoshop.R;

/**
 * TODO: document your custom view class.
 */
public class CircleView extends ImageView {
    private int speed=500;  //每隔多长时间变换一次
    private float start=0.3f;
    private float end=0.8f;
    private int ficker=1;
    private Timer timer;


    public CircleView(Context context) {
        super(context);

    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect = canvas.getClipBounds();
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);// 防止边缘锯齿
        paint.setDither(true);//设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setStyle(Paint.Style.FILL);//画实心圆
        int radius=rect.bottom/2;
        canvas.drawCircle(radius, radius, radius, paint);


        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                //System.out.println("top");
                //System.out.println(msg.what);
                handler.sendMessage(msg);
            }
        }, 0, speed);


    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //System.out.println(OblongView.this.getAlpha());
            if(ficker==1){
                ficker=2;
                CircleView.this.setAlpha(end);
            }else if (ficker==2){
                ficker=1;
                CircleView.this.setAlpha(start);
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
