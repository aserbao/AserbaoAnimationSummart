package com.aserbao.aserbaoanimationsummart.classify.module.ui.fragment.dialogFragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.fragment.FragmentActivity;

public class MyDialogFragment extends DialogFragment {
    int mNum;

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    public static MyDialogFragment newInstance(int num) {
        MyDialogFragment f = new MyDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");

        // Pick a style based on the num.
        int style = DialogFragment.STYLE_NORMAL,
                theme = android.R.style.Theme_Holo;
        switch (mNum%4) {
            case 0:
                style = DialogFragment.STYLE_NO_TITLE;
                break;
            case 1:
                style = DialogFragment.STYLE_NO_FRAME;
                break;
            case 2:
                style = DialogFragment.STYLE_NO_INPUT;
                break;
            case 3:
                style = DialogFragment.STYLE_NORMAL; break;
        }
        switch (mNum%16) {
            case 0:
            case 4:
            case 8:
            case 12:
                theme = android.R.style.Theme_Holo; break;
            case 1:
            case 5:
            case 9:
            case 13:
                theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 2:
            case 6:
            case 10:
            case 14:
                theme = android.R.style.Theme_Holo_Light; break;
            case 3:
            case 7:
            case 11:
            case 15:
                theme = android.R.style.Theme_Holo_Light_Panel; break;
        }
        Toast.makeText(getActivity(), "Style===="+ String.valueOf(style) + "theme======"+String.valueOf(theme), Toast.LENGTH_SHORT).show();
        setStyle(style, theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText("Dialog #" + mNum + ": using style "
                + String.valueOf(mNum));
        // Watch for button clicks.
        Button button = (Button)v.findViewById(R.id.show);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                ((FragmentActivity)getActivity()).showDialog();
            }
        });
        return v;
    }
}