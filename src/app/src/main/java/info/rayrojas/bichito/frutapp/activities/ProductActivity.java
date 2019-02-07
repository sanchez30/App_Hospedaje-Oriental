package info.rayrojas.bichito.frutapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import info.rayrojas.bichito.frutapp.R;
import info.rayrojas.bichito.frutapp.helpers.QueueUtils;
import info.rayrojas.bichito.frutapp.models.Product;

public class ProductActivity extends AppCompatActivity {

    Product productObject;
    TextView productName;
    TextView textDescription;
    QueueUtils.QueueObject queue = null;
    ArrayList<Product> items;
    int _productId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent myIntent = getIntent(); // gets the previously created intent
        _productId = myIntent.getIntExtra("productId", 0);
        queue = QueueUtils.getInstance(this.getApplicationContext());

        items = new ArrayList<>();

        Product.injectProductsFromCloud(queue, items, this);


    }
    public void refreshList() {
        for(Product i : items) {
            if ( i.getId() == _productId ) {
                fill(i);
                return;
            }
        }
        Intent o = new Intent(ProductActivity.this, ProductListActivity.class);
        o.putExtra("status", "error");
        startActivity(o);
        finish();
        return;
    }
    public void fill(Product productObject) {
        productName = (TextView)findViewById(R.id.textViewName);
        textDescription = (TextView)findViewById(R.id.textDescription);
        productName.setText(productObject.getName());
        textDescription.setText(productObject.getDescription());
    }
}
