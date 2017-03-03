package com.example.fake2edison.a2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by fake2edison on 2017/3/2.
 */

public class Card extends FrameLayout {
    public Card(Context context) {
        super(context);
        label = new TextView(getContext());
        label.setTextSize(32);
        label.setBackgroundColor(0x33ffffff);
        label.setGravity(Gravity.CENTER);

        LayoutParams lp = new LayoutParams(-1,-1);
        addView(label,lp);
        lp.setMargins(10,10,0,0);

        setNumber(0);
    }

    private int number = 0;
    public int getNumber(){
        return this.number;
    }
    public void setNumber(int num){
        this.number = num;
        if(number <= 0){
            label.setText("");
        } else label.setText(""+number);
    }
    public boolean equals(Card o){
        return getNumber() == o.getNumber();
    }
    private TextView label;
}
