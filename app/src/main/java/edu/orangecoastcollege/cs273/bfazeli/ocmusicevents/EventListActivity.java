package edu.orangecoastcollege.cs273.bfazeli.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the adapter (which binds the ListView with the data in MusicEvent.java)
        // Since the data is in an array, we use an ArrayAdapter:

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        //setContentView(R.layout.activity_event_list);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id) {
        // 1) Get the position, get the title, get the details
        String title = MusicEvent.titles[pos];
        String details = MusicEvent.details[pos];

        // 2) Make a new Intent
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);

        // 3) Put the Strings into the Intent
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Details", details);

        // 4) Start activity
        startActivity(detailsIntent);
    }
}
