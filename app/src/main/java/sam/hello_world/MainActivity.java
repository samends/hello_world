package sam.hello_world;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {


     TextView mainTextView;
     EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainButton;

        //text view
        mainTextView=(TextView)findViewById(R.id.main_textview);
        mainTextView.setText("Name");

        //button view
        mainButton=(Button)findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        //Edit text view
        mainEditText = (EditText)findViewById(R.id.main_edittext);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
       v.setRotation(90);
       mainTextView.setText("Button pressed!");
       mainTextView.setText(mainEditText.getText().toString()+"is learning android development");
    }
}
