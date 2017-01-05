package xxl.learn.com.photoshop.menu.menu1;

import android.os.Bundle;
import android.widget.FrameLayout;

import xxl.learn.com.photoshop.BaseLessonActivity;
import xxl.learn.com.photoshop.R;

public class Menu1_Lesson1_Activity extends BaseLessonActivity {

    private int order=0; //记录学习到第几步骤 从0开始计数
    private FrameLayout.LayoutParams lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setOrders(6);//首先设置一共有多少步骤
        //baseSetContentView(R.layout.activity_menu1_lesson2);

        //OblongView ob=(OblongView)findViewById(R.id.oview);
        //System.out.println("swithctop" + switchTop(460));
        //ob.layout(switchLeft(235),switchTop(460),0,0);


        //FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(40,30);//设置宽高
        //lp.setMargins(switchLeft(235), switchTop(460), 0,0);//设置margin的left和switch
        //ob.setLayoutParams(lp);


        //ob.setPadding(switchLeft(235), switchTop(460), 0, 0);
        //System.out.println("jdjdjfl" + ob.getLeft() + ",");

        //step(super.order);


    }

    @Override
    protected void step(int num){
        switch (num){
            case 0:
                setLessonBackground(R.mipmap.menu1lesson1_1);
                setCircle(410, 235, 30);
                setDialogBoxLuClick(650,150,300,180,getString(R.string.menu1_lesson1_1));
                playAudio(R.raw.dog);
                break;
            case 1:
                setLessonBackground(R.mipmap.menu1lesson1_2);
                setCircle(150, 145, 50);
                setDialogBoxLu(650,150,300,180,getString(R.string.menu1_lesson1_2));
                playAudio(R.raw.dog);
                break;
            case 2:
                setLessonBackground(R.mipmap.menu1lesson1_3);
                setOblongMove(125,148,192,20,0);
                letOblongMove(0);
                setCircle(100,100,100);
                playAudio(R.raw.dog);
                break;
            case 3:
                setLessonBackground(R.mipmap.menu1lesson1_4);
                setOblong(100, 100, 30, 70);
                setCircle(35, 25, 50);
                playAudio(R.raw.dog);
                break;
            case 4:
                setLessonBackground(R.mipmap.menu1lesson1_4);
                setOblong(100, 100, 30, 70);
                setCircle(35, 25, 50);
                playAudio(R.raw.dog);
                break;
            case 5:
                setLessonBackground(R.mipmap.menu1lesson1_4);
                setOblong(100, 100, 30, 70);
                setCircle(35, 25, 50);
                playAudio(R.raw.dog);
                break;
            default:
                break;
        }
    }



}
