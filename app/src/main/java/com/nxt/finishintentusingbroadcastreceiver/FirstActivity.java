package com.nxt.finishintentusingbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by NXT on 26/10/2016.
 */

public class FirstActivity extends AppCompatActivity {

    public static final String ACTION_CLOSE="com.nxt.finishintentusingbroadcastreceive.ACTION_CLOSE";
    private FirstReceiver firstReceiver;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);
        Button button=(Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentFilter filter=new IntentFilter(ACTION_CLOSE);
                firstReceiver=new FirstReceiver();
                registerReceiver(firstReceiver,filter);
                Intent close=new Intent(FirstActivity.this,CloseActivity.class);
                startActivity(close);


                //startActivity(new Intent(FirstActivity.this,CloseActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(firstReceiver);
    }

    class FirstReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("firstReceiver","firstReceiver:))");
            if(intent.getAction().equals(ACTION_CLOSE)){
                FirstActivity.this.finish();
            }
        }
    }
}
