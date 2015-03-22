package com.example.juan.hangman;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/*
 * Hangman.
 *
 */
public class MainActivity extends Activity{
    private GameControl _theGame;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _theGame = new GameControl( this );
    }



    /*
    * @brief Button "NewWord" clicked. Empty everything and try a new word.
    */
    public void onClickCleanUp(View v) {
        _theGame.onClickCleanUp(v);
    }

    /*
     * @brief Button "OK" clicked
     */
    public void onClickOk(View v) {
        _theGame.onClickOk(v);
    }

    /*
     * @brief Button "Cancel" clicked
     */
    public void onClickCancel(View v) {
        _theGame.onClickCancel(v);
    }
}



/*



http://freecomputerbooks.com/Killer-Game-Programming-in-Java.html
public class final Sprite extends SynchronousThread{
private:
  Image [] _seqImages;
  int _currImageIndex;

public:



}

public interface Controllable{

  public void moveUp();

  public void moveDown();


  public void moveRight();


  public void moveLeft();

}


public interface Animable{

public void setAnimationSpeed( float speed);

public float animationSpeed();

}

public interface Controllable{

public int chooseNextFrame(int keyCode);

}


public class Element{
private:
  Sprite _sprite;

public:

}

 */
