package sam.hello_world;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //Initialize Variables
     TextView mainTextView;
     EditText mainEditText;
     ArrayAdapter mArrayAdapter;
     ArrayList aList = new ArrayList();
     Button mainButton;
     ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text view
        mainTextView=(TextView)findViewById(R.id.main_textview);
        mainTextView.setText("Name");

        //button view
        mainButton=(Button)findViewById(R.id.main_button);
        mainButton.setOnClickListener(this); //Register Event Listener for button

        //Edit text view
        mainEditText = (EditText)findViewById(R.id.main_edittext);

        //List View
        mainListView = (ListView)findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,aList);
        mainListView.setOnItemClickListener(this); //Register Event listener for List View
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

    //Event Listeners
    @Override
    public void onClick(View v) {
       v.setRotation(90);
       mainTextView.setText("Button pressed!");
       mainTextView.setText(mainEditText.getText().toString()+"is learning android development");
       aList.add(mainEditText.getText().toString());
       mArrayAdapter.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView parent, View view, int position, long id){
        Log.d("omg android", position + ": " + aList.get(position));
    }
}