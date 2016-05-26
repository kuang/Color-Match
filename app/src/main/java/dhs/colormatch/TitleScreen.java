package dhs.colormatch;

import android.app.ActionBar;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TitleScreen extends ActionBarActivity {

    TextView StartGame;
    TextView instructions;
    int i = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_title_screen);

        StartGame = (TextView)findViewById(R.id.textView);
        instructions=(TextView)findViewById(R.id.textView3);
        instructions.setText("Choose the right color that matches what the word says. How many can you get? \n" +
                "\n" +
                "You have 30 seconds!");
        final String[] text = new String[]{"Ready,","Get Set,","Go!"};
        StartGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CountDownTimer time = new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        StartGame.setText(text[i]);
                        i++;

                    }

                    @Override
                    public void onFinish() {
                        Intent i = new Intent(TitleScreen.this, GameScreen.class);
                        startActivity(i);
                    }
                };
                time.start();


            }
        });
    }

    //derp
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_title_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
