package com.willy.fluxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.willy.fluxandroid.action.ActionCreator;
import com.willy.fluxandroid.dispatcher.Dispatcher;
import com.willy.fluxandroid.store.MainStore;

public class MainActivity extends AppCompatActivity {

    private Dispatcher mDispatcher;
    private ActionCreator mActionCreator;
    private MainStore mStore;
    private Button mButton,mButton2;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDispatcher = Dispatcher.getInstance();
        mActionCreator = ActionCreator.getInstance();
        mStore = MainStore.getInstance();

        mTextView = (TextView) findViewById(R.id.textView);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionCreator.createClickAction();
            }
        });

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionCreator.createOtherAction();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDispatcher.register(mStore);
        mStore.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDispatcher.unregister(mStore);
        mStore.unregister(this);
    }

    @Subscribe
    public void onStoreChange(MainStore.MainStoreChangeEvent storeChangeEvent) {
        mTextView.setText(mStore.getText());
    }

}
