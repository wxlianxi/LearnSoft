package xxl.learn.com.photoshop;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;


public class IndexActivity extends Activity {
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);




    }
    //按钮事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){   //当按了返回键
            return true;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //以下两种均为干掉整个app
        //或者用下面这种方式
        //System.exit(0);
        //建议用这种
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
