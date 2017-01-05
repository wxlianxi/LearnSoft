package xxl.learn.com.photoshop;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import xxl.learn.com.photoshop.data.ConfigData;
import xxl.learn.com.photoshop.uicontrol.CircleView;
import xxl.learn.com.photoshop.uicontrol.DialogBoxViewLu;
import xxl.learn.com.photoshop.uicontrol.DialogBoxViewLuClick;
import xxl.learn.com.photoshop.uicontrol.OblongMoveView;
import xxl.learn.com.photoshop.uicontrol.OblongView;
import xxl.learn.com.photoshop.uicontrol.SeekBarPerfect;

public class BaseLessonActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout activityContent; //继承该类的activity的layout
    private LinearLayout toolsLayout;//控制条的layout

    private ImageView lessonBackground; //课程的背景图
    private ImageView lessonUpground;//课程的前景图
    private OblongView oblong; //长方形控件
    private CircleView circle;//圆形单击控件
    private OblongMoveView oblongMove0;//长方形逐步消失控件
    private OblongMoveView oblongMove1;
    private OblongMoveView oblongMove2;
    private OblongMoveView oblongMove3;
    private OblongMoveView oblongMove4;
    private SeekBarPerfect seekBar; //自定义的seekbar控件
    private DialogBoxViewLuClick dialogBoxViewLuClick;//左上有箭头的可点击对话框
    private DialogBoxViewLu dialogBoxViewLu;//左上角有箭头的不可点击对话框
    private int seekBarMax=200; //seekbarperfect的最大值

    private MediaPlayer mediaPlayer;


    private FrameLayout.LayoutParams layoutParams;//设置自定义控件top left工具

    protected int order=0;//记录学习到第几步骤 0开始计数
    protected int orders=0;//一共多少步骤0开始计数
    private int seekbarorder=0; //seekbarperfect的内部步骤记录



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_lesson);
        toolsLayout=(LinearLayout)findViewById(R.id.toolslayout);//控制条layout
        lessonBackground=(ImageView)findViewById(R.id.lessonbackground);//课程背景图
        lessonUpground=(ImageView)findViewById(R.id.lessonupground);//课程前景图
        oblong=(OblongView)findViewById(R.id.oblong);
        circle=(CircleView)findViewById(R.id.circle);
        oblongMove0=(OblongMoveView)findViewById(R.id.oblongmove0);
        oblongMove1=(OblongMoveView)findViewById(R.id.oblongmove1);
        oblongMove2=(OblongMoveView)findViewById(R.id.oblongmove2);
        oblongMove3=(OblongMoveView)findViewById(R.id.oblongmove3);
        oblongMove4=(OblongMoveView)findViewById(R.id.oblongmove4);
        dialogBoxViewLuClick=(DialogBoxViewLuClick)findViewById(R.id.dialogBoxLuClick);
        dialogBoxViewLu=(DialogBoxViewLu)findViewById(R.id.dialogBoxLu);
        seekBar=(SeekBarPerfect)findViewById(R.id.seekBar);

        dialogBoxViewLuClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step(++order);
                seekBar.setProgress((int) ((double) seekBar.getMax() / (double) orders) * order); //设置seekbarperect现在的值
            }
        });



        findViewById(R.id.showtools).setOnClickListener(this);//为显示工具条按钮设置onclick
        findViewById(R.id.hidetools).setOnClickListener(this);//为隐藏工具条按钮设置onclick
        oblong.setOnClickListener(this);
        circle.setOnClickListener(this);

        seekBar.setMax(seekBarMax); //为seekbar设置最大值
        seekBar.setOnLongSeekBarClick(seekBarLong);     //为seekbar拖动进度条设置长按监听
        step(order);
    }



    //为继承BaseActivity的Activity设置layout
    public void baseSetContentView(int layoutId){
        activityContent=(LinearLayout)findViewById(R.id.llcontent);
        //获得inflater
        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //把继承该BaseActivity的layoutId放进来显示
        View view=inflater.inflate(layoutId,null);
        //addview
        activityContent.addView(view);
    }

    //设置控件的onClick事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showtools:
                toolsLayout.setVisibility(View.VISIBLE);
                findViewById(R.id.showtools).setVisibility(View.INVISIBLE);
                break;
            case R.id.hidetools:
                toolsLayout.setVisibility(View.INVISIBLE);
                findViewById(R.id.showtools).setVisibility(View.VISIBLE);
                break;
            case R.id.oblong:
                step(++order);
                seekBar.setProgress((int) ((double) seekBar.getMax() / (double) orders) * order); //设置seekbarperect现在的值
                break;
            case R.id.circle:
                step(++order);
                seekBar.setProgress((int) ((double) seekBar.getMax() / (double) orders) * order); //设置seekbarperect现在的值
                break;
            case R.id.dialogBoxLuClick:
            //case R.id.dialogImage_lu_click:
                if (v.getId()==R.id.dialogImage_lu_click){
                    step(++order);
                    seekBar.setProgress((int) ((double) seekBar.getMax() / (double) orders) * order); //设置seekbarperect现在的值
                }


                break;

            default:
                break;
        }
    }
    //按钮事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){   //当按了返回键
            //onDestroy(); //activity所占所有资源回收
            return super.onKeyDown(keyCode, event);
            //return true;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }


    //设置课程背景图
    protected void setLessonBackground(int background){
        clearUi();  //先将控件清屏
        lessonBackground.setImageResource(background);
        lessonBackground.setVisibility(View.VISIBLE);
    }

    //设置课程前景图
    protected void setLessonUpground(int background){
        lessonUpground.setImageResource(background);
        lessonUpground.setVisibility(View.VISIBLE);
    }
    //设置长方形框
    protected void setOblong(int left,int top,int width,int height){
        layoutParams=new FrameLayout.LayoutParams(switchWidth(width),switchHeight(height));
        layoutParams.setMargins(switchLeft(left),switchTop(top),0,0);
        oblong.setLayoutParams(layoutParams);
        oblong.setVisibility(View.VISIBLE);
    }
    //设置单击圆形
    protected void setCircle(int left,int top,int diameter){
        layoutParams=new FrameLayout.LayoutParams(switchWidth(diameter),switchHeight(diameter));
        layoutParams.setMargins(switchLeft(left),switchTop(top),0,0);
        circle.setLayoutParams(layoutParams);
        circle.setVisibility(View.VISIBLE);

    }
    //设置5个中的一个长方形逐步消失控件
    protected void setOblongMove(int left,int top,int width,int height,int which){
        layoutParams=new FrameLayout.LayoutParams(switchWidth(width),switchHeight(height));
        layoutParams.setMargins(switchLeft(left), switchTop(top), 0, 0);
        switch (which){
            case 0:
                oblongMove0.setLayoutParams(layoutParams);
                oblongMove0.setVisibility(View.VISIBLE);
                break;
            case 1:
                oblongMove1.setLayoutParams(layoutParams);
                oblongMove1.setVisibility(View.VISIBLE);
                break;
            case 2:
                oblongMove2.setLayoutParams(layoutParams);
                oblongMove2.setVisibility(View.VISIBLE);
                break;
            case 3:
                oblongMove3.setLayoutParams(layoutParams);
                oblongMove3.setVisibility(View.VISIBLE);
                break;
            case 4:
                oblongMove4.setLayoutParams(layoutParams);
                oblongMove4.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
    //让5个中的一个的 长方形逐渐消失控件
    protected void letOblongMove(int which){
        switch (which){
            case 0:
                oblongMove0.setMove();
                break;
            case 1:
                oblongMove1.setMove();
                break;
            case 2:
                oblongMove2.setMove();
                break;
            case 3:
                oblongMove3.setMove();
                break;
            case 4:
                oblongMove4.setMove();
                break;
            default:
                break;
        }
    }
    //设置不可点击对话框
    protected void setDialogBoxLu(int left,int top,int width,int height,String string){
        layoutParams=new FrameLayout.LayoutParams(switchWidth(width),switchHeight(height));
        layoutParams.setMargins(switchLeft(left),switchTop(top),0,0);
        dialogBoxViewLu.setLayoutParams(layoutParams);
        dialogBoxViewLu.setVisibility(View.VISIBLE);
        dialogBoxViewLu.setTextView(string);
    }
    //设置可点击对话框
    protected void setDialogBoxLuClick(int left,int top,int width,int height,String string){
        layoutParams=new FrameLayout.LayoutParams(switchWidth(width),switchHeight(height));
        layoutParams.setMargins(switchLeft(left),switchTop(top),0,0);
        dialogBoxViewLuClick.setLayoutParams(layoutParams);
        dialogBoxViewLuClick.setVisibility(View.VISIBLE);
        dialogBoxViewLuClick.setTextView(string);
    }
    //将控件清屏为下一次加载做准备
    protected void clearUi(){
        lessonUpground.setVisibility(View.GONE);
        lessonBackground.setVisibility(View.GONE);

        oblong.stop();
        oblong.setVisibility(View.GONE);

        circle.stop();
        circle.setVisibility(View.GONE);

        oblongMove0.stop();
        oblongMove0.setVisibility(View.GONE);
        oblongMove1.stop();
        oblongMove1.setVisibility(View.GONE);
        oblongMove2.stop();
        oblongMove2.setVisibility(View.GONE);
        oblongMove3.stop();
        oblongMove3.setVisibility(View.GONE);
        oblongMove4.stop();
        oblongMove4.setVisibility(View.GONE);

        dialogBoxViewLu.setVisibility(View.GONE);
        dialogBoxViewLuClick.setVisibility(View.GONE);

    }

    //子类必须重写的方法 用于控制学习到第几步
    protected void step(int num){

    }

    //首先设置一共多少步骤
    protected void setOrders(int orders){
        this.orders=--orders;
    }


    //seekbarPerfect的长按监听事件
    SeekBarPerfect.onLong seekBarLong=new SeekBarPerfect.onLong() {
        @Override
        public boolean onLongClick(View v) {
            int value=(int)((double)seekBar.getProgress()/((double)seekBar.getMax()/(double)orders));
            if(seekbarorder!=value){
                seekbarorder=value;
                order=value;
                step(order);
            }
            System.out.println("kdkgj="+value);

            return false;
        }
    };


    protected void playAudio(int id){
        if (mediaPlayer!=null){
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        mediaPlayer=MediaPlayer.create(this,id);
        mediaPlayer.start();
    }

    protected int switchTop(int top){
        return (int)((double)ConfigData.AppHeight/(double)768*top);
    }
    protected int switchLeft(int left){
        return (int)((double)ConfigData.AppWidth/(double)1280*left);
    }
    protected int switchWidth(int width){
        return (int)((double)ConfigData.AppWidth/(double)1280*width);
    }
    protected int switchHeight(int height){
        return (int)((double)ConfigData.AppHeight/(double)768*height);
    }

}
