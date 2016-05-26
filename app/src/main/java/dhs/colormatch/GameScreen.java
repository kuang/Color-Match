package dhs.colormatch;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;


public class GameScreen extends ActionBarActivity {
    TextView Prompt;
    Button topLeft;
    Button topRight;
    Button bottomLeft;
    Button bottomRight;
    Random randGen = new Random();
    Random r = new Random();
    ArrayList<int[]> randColor = new ArrayList<int[]>();
    ArrayList<String> colorNames = new ArrayList<String>();
    int counter = 0;
    int total = -1;
    long timeleft = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);

        CountDownTimer time = new CountDownTimer(30000,1000){
            public void onTick(long millisUntilFinished){
                timeleft = millisUntilFinished;
            };
            public void onFinish(){
                Intent i = new Intent(GameScreen.this,endScreen.class);
                i.putExtra("score",counter);
                i.putExtra("total",total);
                startActivity(i);
            }
        };
        colorNames.add("Red");colorNames.add("Green");colorNames.add("Blue");colorNames.add("Orange");
        randColor.add(new int[]{255,0,0,0});//red
        randColor.add(new int[]{0,255,0,1});//green
        randColor.add(new int[]{0,0,255,2});//blue
        randColor.add(new int[]{255,127,0,3});//orange
        Prompt = (TextView)findViewById(R.id.textView2);
        topLeft = (Button)findViewById(R.id.topLeft);
        topRight = (Button)findViewById(R.id.topRight);
        bottomLeft = (Button)findViewById(R.id.bottomLeft);
        bottomRight = (Button)findViewById(R.id.bottomRight);
        topLeft.setText("");topRight.setText("");bottomLeft.setText("");bottomRight.setText("");
        time.start();
        update();
        topRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(randColor.get(1)[3]==colorNames.indexOf(Prompt.getText())){
                    update();
                    counter++;

                }
                else{
                    update();
                }
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(randColor.get(2)[3]==colorNames.indexOf(Prompt.getText())){
                    update();
                    counter++;

                }
                else{
                    update();
                }
            }
        });
        topLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(randColor.get(0)[3]==colorNames.indexOf(Prompt.getText())){
                    update();
                    counter++;

                }
                else{
                    update();
                }
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(randColor.get(3)[3]==colorNames.indexOf(Prompt.getText())){
                    update();
                    counter++;

                }
                else{
                    update();
                }
            }
        });







    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_screen, menu);
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
    public void update(){
        Collections.shuffle(randColor);
        int nextColor = randGen.nextInt(4);
        Prompt.setText(colorNames.get(nextColor));
        int textColor =r.nextInt(4);
        Prompt.setTextColor(Color.rgb(randColor.get(textColor)[0],randColor.get(textColor)[1],randColor.get(textColor)[2]));
        topLeft.setBackgroundColor(Color.rgb(randColor.get(0)[0], randColor.get(0)[1], randColor.get(0)[2]));
        topRight.setBackgroundColor(Color.rgb(randColor.get(1)[0],randColor.get(1)[1],randColor.get(1)[2]));
        bottomLeft.setBackgroundColor(Color.rgb(randColor.get(2)[0], randColor.get(2)[1], randColor.get(2)[2]));
        bottomRight.setBackgroundColor(Color.rgb(randColor.get(3)[0],randColor.get(3)[1],randColor.get(3)[2]));
        total++;
    }
}

