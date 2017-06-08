package com.aserbao.aserbaoanimationsummart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoveScaleActivity extends AppCompatActivity {

    @BindView(R.id.image_view)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_scale);
        ButterKnife.bind(this);
    }

    public void start_move(View view) {
        startActivity(new Intent(this, MoveStarScaleTranlateActivity.class));
    }

    public void simple_animation(View view) {
//        startActivity(new Intent(this,MoveActivity.class));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Drawable resizeImage = resizeImage(bitmap, (int) event.getX(), (int) event.getY());
        imageView.setImageDrawable(resizeImage);

        return super.onTouchEvent(event);
    }

    public static Drawable resizeImage(Bitmap bitmap, int w, int h) {

        // load the origial Bitmap
        Bitmap BitmapOrg = bitmap;

        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = w;
        int newHeight = h;

        // calculate the scale
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the Bitmap
        matrix.postScale(2, 2);
        // if you want to rotate the Bitmap
        // matrix.postRotate(45);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
                height, matrix, true);

        // make a Drawable from Bitmap to allow to set the Bitmap
        // to the ImageView, ImageButton or what ever
        return new BitmapDrawable(resizedBitmap);

    }

}
