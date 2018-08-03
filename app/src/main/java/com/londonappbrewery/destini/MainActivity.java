package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex; // I prefer start it from 0, to match the array positions

    private static final Story[] mStoryBank = new Story[] {
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End, 0, 0),
            new Story(R.string.T5_End, 0, 0),
            new Story(R.string.T6_End, 0, 0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        // Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHistory(true);
            }
        });

        // Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHistory(false);
            }
        });

    }

    private void updateHistory(boolean isAns1) {
        switch (mStoryIndex) { // I prefer a switch-case to the if-else conditions
            case 0:
                mStoryIndex = isAns1 ? 2 : 1;
                break;
            case 1:
                mStoryIndex = isAns1 ? 2 : 3;
                break;
            case 2:
                mStoryIndex = isAns1 ? 5 : 4;
                break;
        }
        mStoryTextView.setText(mStoryBank[mStoryIndex].getLabel());
        int idTop = mStoryBank[mStoryIndex].getButtonTop();
        int idBottom = mStoryBank[mStoryIndex].getButtonBottom();
        if (idTop != 0) {
            mButtonTop.setText(idTop);
            mButtonTop.setVisibility(View.VISIBLE);
        } else {
            mButtonTop.setVisibility(View.GONE);
        }
        if (idTop != 0) {
            mButtonBottom.setText(idBottom);
            mButtonBottom.setVisibility(View.VISIBLE);
        } else {
            mButtonBottom.setVisibility(View.GONE);
        }
    }
}
