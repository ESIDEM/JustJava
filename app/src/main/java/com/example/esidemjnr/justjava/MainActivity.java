package com.example.esidemjnr.justjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.name_field);
        String value = text.getText().toString();
        /**
         * Whipped cream checkbox
         */
        CheckBox whippedCream = (CheckBox) findViewById(R.id.Checkbox1);
        boolean hasWhipped = whippedCream.isChecked();
        /**
         * Chocolate checkbox
         */
        CheckBox whippedCream1 = (CheckBox) findViewById(R.id.Checkbox2);
        boolean hasChocolate = whippedCream1.isChecked();

        int price = calculatePrice(hasWhipped , hasChocolate);
        String priceMessage = createOrderSummary(value , price);
        displayMessage(priceMessage);
    }

    /**
     * This method calculate the price
     * Returning Ane and total price
     */
    public int calculatePrice(boolean hasWhipped , boolean hasChocolate){
        int basePrice = 5 ;
        if (hasWhipped == true){
            basePrice = basePrice + 1 ;
        }
        if(hasChocolate == true){
            basePrice = basePrice + 2 ;
        }
        return  quantity * basePrice ;
    }
    private String createOrderSummary(String name , int price){
        String priceMessage = "Name: " + name;
        priceMessage = priceMessage + "\nQuantity: " + quantity ;
        priceMessage = priceMessage + "\nTotal $" + price;
        priceMessage = priceMessage + "\n" + "Thank You" ;
        return priceMessage ;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increament(View view) {

        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decreament(View view) {
        quantity = quantity - 1 ;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_Text);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryText = (TextView) findViewById(R.id.orderSummary_Text);
        orderSummaryText.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary_Text);
        priceTextView.setText(message);
    }
}
