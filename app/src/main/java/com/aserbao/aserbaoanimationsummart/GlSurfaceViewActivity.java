package com.aserbao.aserbaoanimationsummart;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aserbao.aserbaoanimationsummart.gl.GLRender;

public class GlSurfaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl_surface_view);
        GLSurfaceView glv= (GLSurfaceView)findViewById(R.id.glv_main);
        GLRender render = new GLRender(this);
        glv.setRenderer(render);
    }
}
