package com.example.efficientsorting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView randomArrayText = findViewById(R.id.randomArrayT);
        randomArrayText.setMovementMethod(new ScrollingMovementMethod());

        TextView orderedArrayText = findViewById(R.id.orderedArrayT);
        orderedArrayText.setMovementMethod(new ScrollingMovementMethod());

    }

    public void start(View b) {
        EditText editTextLength = findViewById(R.id.lenght);
        int legth = Integer.parseInt(editTextLength.getText().toString());
        Thread selectionSort = new Thread() {
          @Override
          public void run() {
              int[] randomArrayToSort = generateRandomArray(legth);
              String randomArray = arrayToString(randomArrayToSort);
              long initialTime = System.currentTimeMillis();
              Sorting.selectionSort(randomArrayToSort);
              long time = System.currentTimeMillis() - initialTime;
              String orderedArray = arrayToString(randomArrayToSort);
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      TextView randomArrayText = findViewById(R.id.randomArrayT);
                      randomArrayText.setText("Random array: " + randomArray);

                      TextView orderdArrayText = findViewById(R.id.orderedArrayT);
                      orderdArrayText.setText("Ordered array: " + orderedArray);

                      TextView timeT = findViewById(R.id.timeT);
                      timeT.setText("Time: " + time + "ms.");
                  }
              });
          }
        };
        selectionSort.start();
    }

    public static int[] generateRandomArray(int size) {
        Random ran = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ran.nextInt(1000);
        }
        return arr;
    }

    public static String arrayToString(int arr[]) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i] + ", ");
        }
        return s.toString();
    }
}