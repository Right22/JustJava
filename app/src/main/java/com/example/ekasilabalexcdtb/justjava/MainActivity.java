package com.example.ekasilabalexcdtb.justjava;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //Global variable
    int quantity =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked
     */
    public void increment(View view) {
        if (quantity == 100){
            //Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffes", Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }
    /**
     * This method is called when the minus button is clicked
     */
    public void decrement(View view) {
        if (quantity == 1){
            //Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffe", Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
            quantity = quantity - 1;
            display(quantity);
    }
    /** Nhlamu -- 0740301421
     * Bossday -- 0720836013
     * 08324051379 Musa
     * thukzen tech and projects ---> COMPANY LOGO
     * 0723806351 ----> Abraham -- Mchipisi -- LOGO on the way
     *
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
         //
        //Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if the user wants whipped chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.add_chocolate_checkbox);
        boolean hasChocolateCheckBox = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolateCheckBox);
        String priceText = createOrderSummary(name, price, hasWhippedCream, hasChocolateCheckBox);

        //Intent intent = new Intent(Intent.ACTION_SENDTO);
        //intent.setData(Uri.parse("mailto:"));//Only mails apps should handle this
        //intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + name);

        //if(intent.resolveActivity(getPackageManager()) != null){
           /// startActivity(intent);
       // }
        displayMessage(priceText);

    }
    //Calculate the price of the order
    //@return total price
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
        //Price of 1 cup of coffe
        int basePrice = 5;
        //Add R1 if the user wants whipped cream
        if(addWhippedCream){
            basePrice += 1;
        }
        //Add R2 if the user wants chocolate
        if(addChocolate){
            basePrice += 2;
        }
        //Calculate the total order price by multiplying by quantity
        int price = quantity * basePrice;
        return price;
    }
    /**
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "";
        priceMessage += "\nName :" + " " + name;
        priceMessage += "\nAdd whipped cream?" + " " + addWhippedCream;
        priceMessage += "\nAdd chocolate?" + " " + addChocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal    : " + price;
        priceMessage += "\nThank you!";
        return  priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen
     */
    private void display(int numberOfCoffe){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffe);
    }
    //This method display the price of ordered coffe
    public void displayMessage(String myMessage) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(myMessage);
    }
}