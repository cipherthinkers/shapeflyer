package com.cipherthinkers.shapeflyer_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mChaosButton;
    private Button mSelectorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        mChaosButton = (Button) findViewById(R.id.chaos_button);
        mChaosButton.setOnClickListener(this);
        mSelectorButton = (Button) findViewById(R.id.selector_button);
        mSelectorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chaos_button:
                startActivity(new Intent(this, RandomFlyShapes.class));
                break;

            case R.id.selector_button:
                startActivity(new Intent(this, SelectShapeActivity.class));
                break;
        }
    }
}
