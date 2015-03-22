package com.example.juan.hangman;

/**
 * Created by juan on 26/01/15.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class World {
    //private Image _scene;
    private MainActivity _parent;

    public World(MainActivity parent) {
        //_scene = new Scene();
        _parent = parent;
        ImageView image = (ImageView) _parent.findViewById(R.id.imageView1);
        Bitmap bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.th);
        image.setImageBitmap(bMap);

    }

    //Controls the background world of the game
    public void restartWord(String currentSelection) {
        //Create layout. Write an "X" for each character of the chosen word.
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < currentSelection.length(); i++)
            output.append("X");
        TextView textView = (TextView) _parent.findViewById(R.id.TextView2);
        textView.setText(output);
    }

    /*
     * @brief Shows the word on the screen. Characters not discovered are hidden
     */
    public void showWord(String userWord) {
        TextView textView = (TextView) _parent.findViewById(R.id.TextView2);
        textView.setText(userWord);
    }

    public void drawErrorState(int state) {
        ImageView image = (ImageView) _parent.findViewById(R.id.imageView1);
        switch (state) {
            case 1:
                showToastMessage("Head!!!");
                Bitmap bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.head);
                image.setImageBitmap(bMap);
                break;
            case 2:
                showToastMessage("Body!!!");
                bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.body);
                image.setImageBitmap(bMap);
                break;
            case 3:
                showToastMessage("Left arm!!!");
                bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.leftarm);
                image.setImageBitmap(bMap);
                break;
            case 4:
                showToastMessage("Right arm!!!");
                bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.rightarm);
                image.setImageBitmap(bMap);
                break;
            case 5:
                showToastMessage("Left leg!!!");
                bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.leftleg);
                image.setImageBitmap(bMap);
                break;
            case 6:
                showToastMessage("You lose!!!");
                bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.rightleg);
                image.setImageBitmap(bMap);
                EditText editText = (EditText) _parent.findViewById(R.id.filter_edittext);
                editText.setText("");
                TextView textView = (TextView) _parent.findViewById(R.id.TextView3);
                textView.setText("");
                textView = (TextView) _parent.findViewById(R.id.TextView2);
                textView.setText("");
                bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.th);
                image.postDelayed(
                        new Runnable() {
                            public void run() {
                            }
                        }, 2000);
                image.setImageBitmap(bMap);
        }
    }

    public void cleanUp() {
        EditText editText = (EditText) _parent.findViewById(R.id.filter_edittext);
        editText.setText("");
        TextView textView = (TextView) _parent.findViewById(R.id.TextView3);
        textView.setText("");
        textView = (TextView) _parent.findViewById(R.id.TextView2);
        textView.setText("");
        ImageView image = (ImageView) _parent.findViewById(R.id.imageView1);
        Bitmap bMap = BitmapFactory.decodeResource(_parent.getResources(), R.drawable.th);
        image.setImageBitmap(bMap);
    }

    /*
     * @brief Helper method to show toast messages
     */
    public void showToastMessage(String text) {
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(_parent.getApplicationContext(), text, duration);
        toast.show();
    }


}