package blogspot.temukan_id.iak_bukalapak.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import blogspot.temukan_id.iak_bukalapak.R;
import blogspot.temukan_id.iak_bukalapak.util.PostDataAsynctack;

public class LoginActivity extends AppCompatActivity {

    private EditText editText1,editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = (EditText) findViewById(R.id.etEmail);
        editText2 = (EditText) findViewById(R.id.etPassword);

        button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PostDataAsynctack(LoginActivity.this,editText1.getText().toString(),editText2.getText().toString()).execute();
            }
        });
    }
}
