package com.example.demo21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener{
	public static Tienda tienda1 = new Tienda("Mall Guatemala", "Ciudad de Guatemala","2388-5600", "8:00AM - 5:00PM", "www.tienda1.com", "tienda1@tienda.com");
	public static Tienda tienda2 = new Tienda("Mall Mixco", "Ciudad de Mixco","2388-5601", "8:00AM - 5:00PM", "www.tienda2.com", "tienda2@tienda.com");
	public static Tienda tienda3 = new Tienda("Mall Villanueva", "Ciudad de Villanueva","2388-5602", "8:00AM - 6:00PM", "www.tienda3.com", "tienda3@tienda.com");
	
	public static final Hashtable<String, Tienda> tiendastarea1 = new Hashtable<String, Tienda>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tiendastarea1.put("Mall Guatemala", tienda1);
		tiendastarea1.put("Mall Mixco", tienda2);
		tiendastarea1.put("Mall Villanueva", tienda3);
		String[] arrayTienda = new String[]{"Mall Guatemala", "Mall Mixco", "Mall Villanueva"};
		ArrayList<String> tienda = new ArrayList<String>(Arrays.asList(arrayTienda));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tienda);
		
		ListView list = (ListView) findViewById(R.id.listView);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		String tienda = adapterView.getItemAtPosition(position).toString();
		Intent intent = new Intent(this, ControlTienda.class);
		intent.putExtra(ControlTienda.TIENDA, tienda);
		startActivity(intent);
		
		
	}

}
