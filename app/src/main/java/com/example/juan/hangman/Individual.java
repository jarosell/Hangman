package com.example.juan.hangman;

/**
 * Created by juan on 26/01/15.
 */


import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Individual{
    private float _life;
    private float _initialLife;
    private MainActivity _parent;

    public  Individual(float initLife, MainActivity parent){
     _life = initLife;
     _initialLife = initLife;
     _parent = parent;
    }

    /* inherited */
    public float life(){
     return _life;
    }

    /* inherited */
    public void life(float life){
     _life = life;
    }

    /* inherited */
    public void increaseLife( float delta){
     _life = _life + delta;
    }

    public void decreaseLife(float delta){
     _life = _life - delta;
    }

    public void reset(){
     _life = _initialLife;
    }

    public char getNextCharacterGuess(View v){
     EditText editText=(EditText) _parent.findViewById(R.id.filter_edittext);
     InputMethodManager imm = (InputMethodManager) _parent.getSystemService(_parent.INPUT_METHOD_SERVICE);
     imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
     char car = editText.getText().toString().charAt(0);
     return car;
    }
}
