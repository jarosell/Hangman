package com.example.juan.hangman;

/**
 * Created by juan on 26/01/15.
 */

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameControl{
 private  World _theWorld;
 private String []_englishWords;
 private String _currentSelection;
 private String _userWord;
 private int _chosenWord;
 //private int _errorCount;
 private Random _generator;
 private   Individual [] _theIndividuals;
 private MainActivity  _parent;

//Controls the input methods and translates them to the suitable objects
private void initWords(){
        _englishWords = new String[10];
        _englishWords[0] = "onion";
        _englishWords[1] = "car";
        _englishWords[2] = "train";
        _englishWords[3] = "flower";
        _englishWords[4] = "book";
        _englishWords[5] = "door";
        _englishWords[6] = "bottle";
        _englishWords[7] = "key";
        _englishWords[8] = "sword";
        _englishWords[9] = "phone";
        }

 /*
  * @brief Restarts the game conditions.
  */
public GameControl(MainActivity parent){
    _parent = parent;
    _theWorld = new World(parent);
    _theIndividuals = new Individual[1];
    _theIndividuals[0] = new Individual(6, parent);
    _generator = new Random();
    initWords();
    _userWord =new String();
    chooseWord();
    _theWorld.showWord(_userWord);
   }

 /*
  * @brief Restarts the game conditions.
  */
private void chooseWord(){
        _chosenWord = _generator.nextInt(10);
        _currentSelection = _englishWords[ _chosenWord ];
        StringBuffer word = new StringBuffer(_currentSelection);
        for (int i = 0; i < _currentSelection.length(); i++)
         word.setCharAt(i, 'X');
        _userWord = word.toString();
        _theWorld.restartWord(_currentSelection);
       }


 /*
  * @brief Button "OK" clicked
  */
public void onClickOk(View v){
        EditText editText=(EditText) _parent.findViewById(R.id.filter_edittext);
        char car=_theIndividuals[0].getNextCharacterGuess(v);
        editText.setText("");
        //was the character already used?
        TextView usedWords=(TextView) _parent.findViewById(R.id.TextView3);
        StringBuffer strUsed=new StringBuffer(usedWords.getText().toString());
        int idx=strUsed.toString().indexOf(car);
        if(idx!=-1){ //Show toast message and return.
        _theWorld.showToastMessage("You already used this character!!! "+car);
        return;
        }
        //look for car in the chosen word. If not found, change the drawing.
        idx=_currentSelection.indexOf(car);
        if(idx!=-1){
         _theWorld.showToastMessage("Well done!!");
         alignWords(car);
         _theWorld.showWord(_userWord);
        }
        else{
        _theWorld.showToastMessage("Opps.... ");
        strUsed.append(car);
        usedWords.setText(strUsed.toString());
        _theIndividuals[0].decreaseLife(1);
        _theWorld.drawErrorState(6 - (int) _theIndividuals[0].life());
        if(_theIndividuals[0].life()==0){   ////              (_errorCount ==6){
         chooseWord();
         _theWorld.showWord(_userWord);
         _theIndividuals[0].reset( );
        }
       }
      }

  /*
  * @brief Button "NewWord" clicked. Empty everything and try a new word.
  */
public void onClickCleanUp(View v){
        _theWorld.cleanUp();
        chooseWord();
        _theWorld.showWord(_userWord);
        }

 /*
  * @brief Button "Cancel" clicked
  */
public void onClickCancel(View v){
        EditText editText=(EditText)_parent.findViewById(R.id.filter_edittext);
        editText.setText("");
        }

/*
  * @brief Substitute in the userWord all the occurrences of "car" and check if the game is over.
  */
private void alignWords(char ch){
        StringBuffer word=new StringBuffer(_currentSelection);
        for(int i=0;i<_userWord.length();i++){
        if(_userWord.charAt(i)==_currentSelection.charAt(i))
        continue;
        if(_currentSelection.charAt(i)==ch)
        word.setCharAt(i,ch);
        else
        word.setCharAt(i,'X');
        }
        _userWord=word.toString();
        if(_userWord.compareTo(_currentSelection)==0)
        _theWorld.showToastMessage("You win!!!");
        }
}

