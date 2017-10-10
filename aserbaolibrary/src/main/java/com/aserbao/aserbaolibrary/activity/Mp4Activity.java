package com.aserbao.aserbaolibrary.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaolibrary.R;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.tracks.AACTrackImpl;
import com.googlecode.mp4parser.authoring.tracks.h264.H264TrackImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class Mp4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp4);
    }


    public void btn_compound(View view) {
        try {
//            H264TrackImpl h264Track = new H264TrackImpl(new FileDataSourceImpl("video_water.mp4"));
//            F:\Android\AserbaoTestSummary\AserbaoAnimationSummart\app\video_water.mp4

            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String f = absolutePath + File.separator + "1.mp4";
            AACTrackImpl aacTrack = new AACTrackImpl(new FileDataSourceImpl(f));
            H264TrackImpl h264Track = new H264TrackImpl(new FileDataSourceImpl(f));
            Movie movie = new Movie();
            movie.addTrack(h264Track);
            movie.addTrack(aacTrack);
            Container mp4file = new DefaultMp4Builder().build(movie);
            FileChannel fc = new FileOutputStream(new File(absolutePath + File.separator + "output.mp4")).getChannel();
            mp4file.writeContainer(fc);
            fc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
