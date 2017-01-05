package xxl.learn.com.photoshop.uicontrol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class SeekBarPerfect extends SeekBar implements View.OnTouchListener {

    private onLong longClick;

    /**
     * 长按接口
     * @author terry
     *
     */
    public interface onLong {
        public boolean onLongClick(View v);
    }

    private onChange SeekBarChange;

    /**
     * 进度改变接口
     * @author terry
     *
     */
    public interface onChange {
        public void onStopTrackingTouch(SeekBarPerfect seekBar);

        public void onStartTrackingTouch(SeekBarPerfect seekBar);

        public void onProgressChanged(SeekBarPerfect seekBar, int progress,
                                      boolean fromUser);
    }


    private Handler hand;
    private Runnable runable;
    private Thread th;
    public static int i = 0;
    private boolean isStop = false;
    public static int pp = 0;
    public int index = 0;

    public SeekBarPerfect(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    public SeekBarPerfect(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
        this.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if (SeekBarChange != null) {
                    SeekBarChange.onStopTrackingTouch(SeekBarPerfect.this);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if (SeekBarChange != null) {
                    SeekBarChange.onStartTrackingTouch(SeekBarPerfect.this);
                }
            }

            @Override
            public void onProgressChanged(final SeekBar seekBar,
                                          final int progress, boolean fromUser) {
                if (SeekBarChange != null) {
                    SeekBarChange.onProgressChanged(SeekBarPerfect.this, progress,
                            fromUser);
                }
                hand = getHandler(1, SeekBarPerfect.this, progress);
            }
        });
        /**
         * 为runable 赋值
         */
        runable = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                do {
                    i++;
                    try {
                        Thread.sleep(40);
                        Message msg = hand.obtainMessage();
                        msg.arg1 = i;
                        msg.sendToTarget();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } while (isStop);
            }
        };
    }

    /**
     * 获取一个handler 对象
     * param 0代表onTouch 1代表onChange
     * param 视图对象
     * param 进度
     * return 返回一个handler对象
     */
    public Handler getHandler(final int j, final View v, final int progress) {
        Handler h = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                switch (j) {
                    case 0:
                        if (msg.arg1 == 3) {
                            if (longClick != null) {
                                longClick.onLongClick(v);
                            }
                        }
                        break;
                    case 1:
                        if (msg.arg1 == 1) {
                            pp = progress;
                        }
                        if (msg.arg1 == 2) {
                            if (pp != progress) {
                                i = 0;
                            }
                        }
                        if (msg.arg1 == 3) {
                            i = 0;
                            if (pp == progress) {
                                if (longClick != null) {
                                    longClick.onLongClick(SeekBarPerfect.this);
                                }
                            }
                        }
                        break;
                }
                super.handleMessage(msg);
            }
        };
        return h;
    }

    /**
     * 设置长按事件
     * @param longClick
     */
    public void setOnLongSeekBarClick(onLong longClick) {
        this.longClick = longClick;
    }

    /**
     * 设置进度改变事件
     * @param change
     */
    public void setOnSeekBarChange(onChange change) {
        this.SeekBarChange = change;
    }

    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("down");
                isStop = true;
                th = new Thread(runable);
                th.start();
                i = 0;
                hand = getHandler(0, v, 0);
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("up");
                isStop = false;
                break;

        }
        return false;
    }
}
