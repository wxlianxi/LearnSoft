package xxl.learn.com.photoshop.menu.menu1;

import android.os.Bundle;

import xxl.learn.com.photoshop.BaseLessonActivity;
import xxl.learn.com.photoshop.R;
import xxl.learn.com.photoshop.uicontrol.OblongMoveView;

public class Menu1_Lesson2_Activity extends BaseLessonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseSetContentView(R.layout.activity_menu1_lesson2);
        OblongMoveView a=(OblongMoveView)findViewById(R.id.a);
        a.setMove();
    }
}
