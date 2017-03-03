package com.example.fake2edison.a2048;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fake2edison on 2017/3/2.
 */

public class GameView extends GridLayout {
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }
    public GameView(Context context){
        super(context);
        initGameView();
    }
    public GameView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        initGameView();
    }
    private void initGameView(){
        setColumnCount(4);
        setBackgroundColor(0xffbbaba0);
        setOnTouchListener(new OnTouchListener() {
            private float startX,startY,offX,offY;
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offX = event.getX()-startX;
                        offY = event.getY()-startY;

                        if(Math.abs(offX)>Math.abs(offY)){
                            if(offX<-5)
                                swiftLeft();
                            else if(offX>5)
                                swiftRight();
                        }else{
                            if(offY<-5)
                                swiftUp();
                            else if(offY>5)
                                swiftDown();
                        }
                        break;

                }
                return true;
            }
        });

    }

    private void addRandonNumber(){

        emptyPoints.clear();
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                if(cardMaps[x][y].getNumber()<=0){
                    emptyPoints.add(new Point(x,y));
                }
            }
        }
        Point p = emptyPoints.remove((int)(Math.random() * emptyPoints.size()));
        cardMaps[p.x][p.y].setNumber(Math.random()>0.1?2:4);
    }
    private void startGame(){
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                cardMaps[x][y].setNumber(0);
            }
        }
        addRandonNumber();
        addRandonNumber();

    }


    protected void onSizeChanged(int w,int h,int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        int cardWidth = (Math.min(w,h)-10)/4;
        addCard(cardWidth,cardWidth);
        startGame();

    }
    private void addCard(int cardWidth,int cardHeight){
        Card c;
        for(int y = 0;y<4;y++) {
            for (int x = 0; x < 4; x++) {
                c = new Card(getContext());
                c.setNumber(0);
                addView(c,cardWidth,cardHeight);
                cardMaps[x][y] = c;
            }
        }
    }
    private void swiftRight(){

    }
    private void swiftLeft(){

    }
    private void swiftUp(){

    }
    private void swiftDown(){

    }
    public Card[][] cardMaps = new Card[4][4];
    public List<Point> emptyPoints = new ArrayList<Point>();
}
