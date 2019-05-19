package nz.ac.aut.dms.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;


public class GameActivity extends Activity implements View.OnClickListener {
    public static final int MAX_NUMBER = 100;
    public static final Random rand = new Random();
    private TextView textmsg;
    private EditText numberInput;
    private Button validate;
    private int numberToFind, tryCounts, scores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        textmsg = (TextView) findViewById(R.id.textMessage);
        numberInput = (EditText) findViewById(R.id.numGuess);
        validate = (Button)findViewById(R.id.guessBtn);
        validate.setOnClickListener(this);
        numberToFind = rand.nextInt(MAX_NUMBER)+1;
    }

    @Override
    public void onClick(View v) {
        if(v==validate) {
            validate(v);
        }
    }

    private void validate(View v) {
        int n = Integer.parseInt(numberInput.getText().toString());
        tryCounts++;

        if(n==numberToFind) {
//            textmsg.setText("Correct! You have find the number " + numberToFind + " in " + tryCounts + " tries\nScores: " +
//                    scores+ "\nPlease start a new game!");
            startActivity(new Intent(this, BackActivity.class));
        }
        else if (n>numberToFind) {
            textmsg.setText("Too hight, try again! Count: " + tryCounts
            + "\nScores: " + scores);
        }
        else if (n<numberToFind) {
            textmsg.setText("Too low, try again! Count: " +tryCounts
            + "\nScores: " + scores);
        }
    }

}
