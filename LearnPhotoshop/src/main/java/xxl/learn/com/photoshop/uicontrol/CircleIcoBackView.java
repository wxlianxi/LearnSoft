package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * TODO: document your custom view class.
 */
public class CircleIcoBackView extends ImageView {


    public CircleIcoBackView(Context context) {
        super(context);

    }

    public CircleIcoBackView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CircleIcoBackView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect = canvas.getClipBounds();
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);//防止边缘锯齿
        paint.setDither(true);//设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setStyle(Paint.Style.STROKE);//画空心圆
        paint.setStrokeWidth(5);
        int c = rect.bottom/2;//圆心
        int radius=(rect.bottom-5)/2;//半径
        canvas.drawCircle(c, c, radius, paint);

    }



}
