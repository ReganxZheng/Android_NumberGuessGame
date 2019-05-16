package nz.ac.aut.dms.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends Activity {
    private EditText guess;
    private int score;
    private TextView scoreText, messageText;
    private int randNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        messageText = (TextView) findViewById(R.id.textMessage);
        guess = (EditText) findViewById(R.id.numGuess);

    }

    private void generateNumbers() {
        Random rand = new Random();
        randNum = rand.nextInt(100);
    }

    private String check() {
        int number = Integer.parseInt(String.valueOf(guess.getText()));
        String notify = "Correct!";
        if(randNum>number) {
            notify = "Guess too low, try again";
        }
        else if(randNum<number) {
            notify = "Guess too high, try again";
        }
        return notify;
    }

   public void btnClicked(View view) {
        messageText.setText(this.check());
   }
}
