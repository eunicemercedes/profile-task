package dev.eunicemercedes.profileCustomer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        mostrar();
        TextView compartir = findViewById(R.id.compartir);
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();

            }
        });
    }

    void share() {
        Intent comparte = new Intent();
        comparte.setAction(Intent.ACTION_SEND);
        TextView textView1 = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);

//    comparte. setType("image/jpg");
//    Toast.makeText(this,Uri.parse("android.resource://"+getPackageName()+"/"+"R.drawable."+ getIntent().getStringExtra("PASSWORD") ).toString(),Toast.LENGTH_LONG);
//    comparte.putExtra(Intent.EXTRA_STREAM,  Uri.parse("android.resource://"+getPackageName()+"/"+"R.drawable."+ getIntent().getStringExtra("PASSWORD") ));
        comparte.putExtra(Intent.EXTRA_TEXT, textView1.getText().toString() + ";" +
                textView2.getText().toString() + ";" +
                textView3.getText().toString()
        );

        comparte.setType("text/plain");

        startActivity(Intent.createChooser(comparte, "Share With"));
        startActivity(comparte);

    }

    void mostrar() {
        Customer customer = Customers.validateCustomer(
                getIntent().getStringExtra("EMAIL"),
                getIntent().getStringExtra("PASSWORD"));


        TextView textView1 = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        textView1.setText(getIntent().getStringExtra("NOMBRE"));

        if (customer.getEmail() != "") {
            textView1.setText(customer.getNombre());
            textView2.setText(customer.getEmail());
            textView3.setText(customer.getTelefono());
            ImageView imageView = findViewById(R.id.imageView2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), getResources().getIdentifier(customer.getPassword(), "drawable", getPackageName())));
        }

    }


}
