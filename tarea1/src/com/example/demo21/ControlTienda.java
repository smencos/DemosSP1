package com.example.demo21;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ControlTienda extends Activity {
	private String tienda_nombre ="";
	public static final String TIENDA ="tienda";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tienda);
		
		Intent intent = getIntent();
		tienda_nombre = (intent.getStringExtra(TIENDA));
		Tienda tiendaMos = MainActivity.tiendastarea1.get(tienda_nombre);
		String nombre = tiendaMos.name1;
		String dire = tiendaMos.direccion1;
		final String te = tiendaMos.telefono1;
		String hora = tiendaMos.horario1;
		String ema = tiendaMos.email1;
		String we = tiendaMos.website1;
		TextView nombret = (TextView) findViewById(R.id.nombre_tienda);
		nombret.setText(nombre);
		TextView direc = (TextView) findViewById(R.id.direccion_tienda);
		direc.setText(dire);
		TextView tele = (TextView) findViewById(R.id.telefono_tienda);
		tele.setText(te);
		TextView horas = (TextView) findViewById(R.id.horario_tienda);
		horas.setText(hora);
		TextView emal = (TextView) findViewById(R.id.email_tienda);
		emal.setText(ema);
		TextView wel = (TextView) findViewById(R.id.sitio_tienda);
		wel.setText(we);
		
		
		Linkify.addLinks(wel, Linkify.ALL);
		Linkify.addLinks(emal, Linkify.ALL);
		Linkify.addLinks(direc, Linkify.MAP_ADDRESSES);
		Linkify.addLinks(tele, Linkify.ALL);
		
		Button btnllamar = (Button)findViewById(R.id.llamar);
		btnllamar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String uri = "tel:" + te;
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse(uri));
				startActivity(intent);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.country_detail, menu);
		return true;
	}

	public String getCountry() {
		return tienda_nombre;
	}



}
