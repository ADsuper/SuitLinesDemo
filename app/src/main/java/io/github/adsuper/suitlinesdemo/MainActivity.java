package io.github.adsuper.suitlinesdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.adsuper.suitlinesdemo.suitlines.SuitLines;
import io.github.adsuper.suitlinesdemo.suitlines.Unit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.suitlines)
    SuitLines mSuitlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);
//        List<Unit> lines = new ArrayList<>();
//        for (int i = 0; i < 14; i++) {
//            lines.add(new Unit(new SecureRandom().nextInt(48), i + ""));
//        }
//        mSuitlines.setLineForm(true);
//        mSuitlines.setCoverLine(true);
//        mSuitlines.feedWithAnim(lines);
    }
    public void onBtnClick(View view) {
        mSuitlines.anim();
    }

    private boolean enable;
    public void onBtnClick1(View view) {
        mSuitlines.setCoverLine(enable = !enable);
    }

    public void onBtnClick13(View view) {
        int[] colors = new int[2];
        colors[0] = color[new SecureRandom().nextInt(7)];
        colors[1] = Color.WHITE;
        mSuitlines.setDefaultOneLineColor(colors);
    }

    private int curCount = 1;

    public void onBtnClick2(View view) {
        mSuitlines.setXySize(textSize = 8);
        init(curCount = 1);
    }

    public void onBtnClick3(View view) {
        init(++curCount);
    }

    public void onBtnClick4(View view) {
        if (curCount <= 1) {
            curCount = 1;
        }
        init(--curCount);
    }

    public void onBtnClick5(View view) {
        mSuitlines.setLineForm(!mSuitlines.isLineFill());
    }


    public void onBtnClick6(View view) {
        mSuitlines.setLineStyle(mSuitlines.isLineDashed()?SuitLines.SOLID:SuitLines.DASHED);
    }

    public void onBtnClick7(View view) {
        mSuitlines.setLineType(mSuitlines.getLineType() == SuitLines.CURVE ? SuitLines.SEGMENT : SuitLines.CURVE);
    }

    public void onBtnClick8(View view) {
        mSuitlines.disableEdgeEffect();
    }

    public void onBtnClick9(View view) {
        mSuitlines.setEdgeEffectColor(color[new SecureRandom().nextInt(7)]);
    }

    public void onBtnClick10(View view) {
        mSuitlines.setXyColor(color[new SecureRandom().nextInt(7)]);
    }

    private float textSize = 8;

    public void onBtnClick11(View view) {
        mSuitlines.setXySize(++textSize);
    }

    public void onBtnClick12(View view) {
        if (textSize < 6) {
            textSize = 6;
        }
        mSuitlines.setXySize(--textSize);
    }
    public void onBtnClick14(View view) {
        mSuitlines.disableClickHint();
    }
    public void onBtnClick15(View view) {
        mSuitlines.setHintColor(color[new SecureRandom().nextInt(7)]);
    }

    private int[] color = {Color.RED, Color.GRAY, Color.BLACK, Color.BLUE, 0xFFF76055, 0xFF9B3655, 0xFFF7A055};

    public void init(int count) {
        if (count <= 0) {
            count = 0;
        }
        if (count == 1) {
            List<Unit> lines = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                lines.add(new Unit(new SecureRandom().nextInt(48), (i+1)+"月"));
            }
            mSuitlines.feedWithAnim(lines);
            return;
        }

        SuitLines.LineBuilder builder = new SuitLines.LineBuilder();
        for (int j = 0; j < count; j++) {
            List<Unit> lines = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                lines.add(new Unit(new SecureRandom().nextInt(128), "" ));
            }
            builder.add(lines, new int[]{color[new SecureRandom().nextInt(7)], Color.WHITE});
        }
        builder.build(mSuitlines, true);

    }
}
