package nz.ac.aut.dms.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BackActivity extends Activity implements View.OnClickListener{
    public TextView txtMsg;
    public Button playAgain;
    public Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_layout);
        txtMsg = (TextView)findViewById(R.id.resultMsg);
        playAgain = (Button) findViewById(R.id.plyaAgainBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        playAgain.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v==playAgain) {
            startActivity(new Intent(this, GameActivity.class));
        }
        else if(v==exitBtn) {
            System.exit(0);
        }
    }


}
