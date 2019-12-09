package com.example.finalprojectavg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class Minigameplay extends View {
    private Bitmap ghost[] = new Bitmap[1];
    private int ghostx = 80;
    private int ghosty;
    private int ghostSpeed;
    private int canvasWidth, canvasHeight;
    private int score;

    private Bitmap downwall;
    private int downwallx = -1000, downwally = -1000, downwallSpeed = 16;
    private Bitmap upwall;
    private int upwallx = -1000, upwally = -1000, upwallSpeed = 16;
    //private Paint wallPaint = new Paint();

    private boolean touch = false;

    private Bitmap backgroudImage;
    private Paint scorepaint = new Paint();


    public Minigameplay(Context context) {
        super(context);
        ghost[0] = BitmapFactory.decodeResource(getResources(), R.drawable.realghost);
        backgroudImage = BitmapFactory.decodeResource(getResources(), R.drawable.back1);
        downwall = BitmapFactory.decodeResource(getResources(), R.drawable.wall);
        upwall = BitmapFactory.decodeResource(getResources(), R.drawable.wall);
        scorepaint.setColor(Color.WHITE);
        scorepaint.setTextSize(70);
        scorepaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorepaint.setAntiAlias(true);
        ghosty = 550;

        //wallPaint
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(backgroudImage, 0, 0, null);//background
        //canvas.drawBitmap(ghost, 0, 0, null);//draw ghost
        int minGhostY = ghost[0].getHeight();
        int maxGhostY = canvasHeight - ghost[0].getHeight() + 3;
        ghosty += ghostSpeed;
        if (ghosty < minGhostY) {
            ghosty = minGhostY;
        }
        if (ghosty > maxGhostY) {
            ghosty = maxGhostY;
        }
        ghostSpeed += 2;

        if (touch) {
            canvas.drawBitmap(ghost[0], ghostx, ghosty, null);
            touch = false;
        } else {
            canvas.drawBitmap(ghost[0], ghostx, ghosty, null);
        }



        if (hitwall(ghostx, ghosty, upwallx, upwally, downwallx, downwally)) {
            canvas.drawText("Score : game over", 200, 60, scorepaint);
            Intent tofinal = new Intent(getContext(),finale.class);
            tofinal.putExtra("score", score);
            tofinal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            getContext().startActivity(tofinal);
            ghostx = -4000;
        } else {
            score++;
        }

        downwallx -= downwallSpeed;
        upwallx -= downwallSpeed;
        if (downwallx < 0 - downwall.getWidth()) {
            //upwallx
            downwallx = canvasWidth + 30;
            downwally = (int) Math.floor(Math.random() * (maxGhostY - minGhostY)) + minGhostY + ghost[0].getHeight() + 60;
            //upwallx = downwallx;
            //upwally = downwally + 8;
        }
        if (upwallx < 0 - downwall.getWidth()) {
            //upwallx
            upwallx = canvasWidth + 30;
            upwally = downwally - downwall.getHeight() - ghost[0].getHeight() - 320;
            //upwallx = downwallx;
            //upwally = downwally + 8;
        }
        canvas.drawBitmap(downwall, downwallx, downwally, null);
        canvas.drawBitmap(downwall, upwallx, upwally, null);


        canvas.drawText("Score : " + score, 200, 60, scorepaint);


    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touch = true;
            ghostSpeed = -27;
        }
        return true;
    }

    public boolean hitwall(int ghostx, int ghosty, int upwallx, int upwally, int downwallx, int downwally) {
        Rect ghostHITBOX = new Rect(ghostx, ghosty, ghostx + ghost[0].getWidth(), ghosty + ghost[0].getHeight());
        Rect upHITBOX = new Rect(upwallx, upwally, upwallx + upwall.getWidth(), upwally + upwall.getHeight());
        Rect downHITBOX = new Rect(downwallx, downwally, downwallx + downwall.getWidth(), downwally + downwall.getHeight());
        return ghostHITBOX.intersect(upHITBOX) || ghostHITBOX.intersect(downHITBOX);
    }
}
