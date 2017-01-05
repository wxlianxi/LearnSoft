package xxl.learn.com.photoshop;

import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.HashMap;
import java.util.Map;

import xxl.learn.com.photoshop.data.ConfigData;
import xxl.learn.com.photoshop.list.List_Menu1_Activity;


public class LogoActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private Map<Integer,Integer> soundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        soundPool= new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        soundMap=new HashMap<Integer,Integer>();
        soundMap.put(0,soundPool.load(LogoActivity.this,R.raw.dog,1));
        soundPool.play(soundMap.get(0),1,1,0,0,1);



    }

    //当界面得到焦点时候获取真实的显示区域宽高(不包括状态栏和虚拟按键)
    //因为别的生命周期得到的宽高不准确
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus==true){   //当界面得到焦点时候触发
            Rect rect = new Rect();
            this.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(rect);
            ConfigData.AppWidth=rect.width();               //获取真实的显示区域宽度(不包括状态栏和虚拟按键)并赋值给configdata方便调用
            ConfigData.AppHeight=rect.height();             //获取真实的显示区域高度(不包括状态栏和虚拟按键)并赋值给configdata方便调用
            System.out.println("AppWidth+" + ConfigData.AppWidth);
            System.out.println("AppHeight=" + ConfigData.AppHeight);
            Intent intent=new Intent(LogoActivity.this,BaseIndexActivity.class);
            startActivity(intent);
            finish();
            //onDestroy();  //finish()仅仅是将activity移出栈 ondestroy()是将activity所有资源释放


        }

    }

    //播放音效


}
