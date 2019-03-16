package com.example.user.sensorapp02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    Paint paint;
    private float posX,posY;
    private float velX,velY;
    private int r = 50;

    public CanvasView(Context con, AttributeSet as){
        super(con, as);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas cv){
        cv.drawColor(Color.BLACK);

        paint.setColor(Color.GREEN);
        cv.drawCircle(cv.getWidth() / 2 + posX, cv.getHeight() / 2 + posY, r, paint);
    }

    public void setPos(float ax, float ay, float width, float height){
        ax *= -1;
        float dt = 0.15f;

        posX += velX * dt + ax * dt * dt;
        velX += ax * dt;

        posY += velY * dt + ay * dt * dt;
        velY += ay * dt;

        if ((width / 2 + posX) < 0 + r){
            posX = -(width / 2) + r;
            velX *= -0.8;
        } else if ((width / 2 + posX) > width - r){
            posX = width / 2 - r;
            velX *= -0.8;
        }

        if ((height / 2 + posY) < 0 + r){
            posY = -(height / 2) + r;
            velY *= -0.8;
        } else if ((height / 2 + posY) > height - r) {
            posY = height / 2 - r;
            velY *= -0.8;
        }

        invalidate();   //再描画
    }
}
