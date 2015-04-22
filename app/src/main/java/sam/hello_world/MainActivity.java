package sam.hello_world;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


     TextView mainTextView;
     EditText mainEditText;
     ListView mainListView;
     ArrayAdapter mArrayAdapter;
     ArrayList mNameList;
     ShareActionProvider mShareActionProvider;
     private static final String PREFS = "prefs";
     private static final String PREF_NAME = "name";
    SharedPreferences mSharedPreferences;

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

        //List view
        mNameList = new ArrayList();
        mainListView = (ListView) findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);

        //Display Welcome Message
        displayWelcome();


    }

    public void displayWelcome(){
        mSharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        String name = mSharedPreferences.getString(PREF_NAME, "");

        if(name.length()>0){
            Toast.makeText(this, "Welcome back,"+name+"!",Toast.LENGTH_LONG).show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Welcome");
            alert.setMessage("What is your name?");

            final EditText input = new EditText(this);
            alert.setView(input);

            alert.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int whichButton){
                    String inputName=input.getText().toString();
                    SharedPreferences.Editor e = mSharedPreferences.edit();
                    e.putString(PREF_NAME, inputName);
                    e.commit();

                    Toast.makeText(getApplicationContext(),"Welcome,"+inputName,Toast.LENGTH_LONG).show();
                }
            });

            alert.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int whichButton){
                    //Nothing happens on negative button
                }
            });

            alert.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        // Adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item_share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
       mainTextView.setText("Button pressed!");
       mainTextView.setText(mainEditText.getText().toString());

       mNameList.add(mainEditText.getText().toString());
       mArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id){
        Log.d("Android", position + ":" + mNameList.get(position));
    }
}
