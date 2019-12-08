package com.example.finalprojectavg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameplaypage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplaypage);
        Button opt1 = findViewById(R.id.opt1);
        Button opt2 = findViewById(R.id.opt2);
        Button mng = findViewById(R.id.minigame);
        mng.setVisibility(View.GONE);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(unused-> {
            Intent jumpback = new Intent(this, MainActivity.class);
            startActivity(jumpback);
            finish();
        });
        Tree gamestory = new Tree();
        setStory(gamestory);
        /**gamestory.story = "you r gay";
        gamestory.opt1s = "choose me";
        gamestory.opt2s = "choose no one";
        gamestory.left = new Tree();
        gamestory.left.story = "im gay";
        gamestory.right = new Tree();
        gamestory.right.story = "no ones gay";*/
        TextView gs = findViewById(R.id.gamedes);
        gs.setText(gamestory.story);
        opt1.setText(gamestory.opt1s);
        opt2.setText(gamestory.opt2s);
        opt1.setOnClickListener(unused-> {
            if (gamestory.left.game) {
                mng.setVisibility(View.VISIBLE);
                gotomng();
                /**mng.setOnClickListener(unused-> {
                 Intent jumpback = new Intent(this, minigame.class);
                 startActivity(jumpback);
                 finish();
                 });*/
            }
            gs.setText(gamestory.left.story);
            opt1.setText(gamestory.left.opt1s);
            opt2.setText(gamestory.left.opt2s);
            //gamestory = gamestory.left;
            opt1.setOnClickListener(used-> {
                if (gamestory.left.left.game) {
                    mng.setVisibility(View.VISIBLE);
                    gotomng();
                    /**mng.setOnClickListener(unused-> {
                        Intent jumpback = new Intent(this, minigame.class);
                        startActivity(jumpback);
                        finish();
                    });*/
                }
                gs.setText(gamestory.left.left.story);
                opt1.setText(gamestory.left.left.opt1s);
                opt2.setText(gamestory.left.left.opt2s);
                //gamestory = gamestory.left;
            });
            opt2.setOnClickListener(used-> {
                if (gamestory.left.right.game) {
                    mng.setVisibility(View.VISIBLE);
                    gotomng();
                    /**mng.setOnClickListener(unused-> {
                     Intent jumpback = new Intent(this, minigame.class);
                     startActivity(jumpback);
                     finish();
                     });*/
                }
                gs.setText(gamestory.left.right.story);
                opt1.setText(gamestory.left.right.opt1s);
                opt2.setText(gamestory.left.right.opt2s);
            });
        });
        opt2.setOnClickListener(unused-> {
            gs.setText(gamestory.right.story);
            opt1.setText(gamestory.right.opt1s);
            opt2.setText(gamestory.right.opt2s);
            opt1.setOnClickListener(used-> {
                gs.setText(gamestory.right.left.story);
                opt1.setText(gamestory.right.left.opt1s);
                opt2.setText(gamestory.right.left.opt2s);
                //gamestory = gamestory.left;
            });
            opt2.setOnClickListener(used-> {
                gs.setText(gamestory.right.right.story);
                opt1.setText(gamestory.right.right.opt1s);
                opt2.setText(gamestory.right.right.opt2s);
            });
        });
    }
    public void gotomng() {
        Button mng = findViewById(R.id.minigame);
        mng.setOnClickListener(unused-> {
            Intent jumpback = new Intent(this, minigame.class);
            startActivity(jumpback);
            finish();
        });
    }
    public void setStory(Tree gamestory) {
        gamestory.story = "you r gay";
        gamestory.opt1s = "choose me";
        gamestory.opt2s = "choose no one";
        gamestory.left = new Tree();
        gamestory.left.story = "im gay";
        gamestory.left.opt1s = "success im gay me";
        gamestory.left.opt2s = "success no one me";
        gamestory.right = new Tree();
        gamestory.right.story = "no ones gay";
        gamestory.right.opt1s = "success im gay no one";
        gamestory.right.opt2s = "success no one no one";
        gamestory.left.left = new Tree();
        gamestory.left.left.game = true;
        gamestory.left.left.story = "im gay left";
        gamestory.left.left.opt1s = "success im gay me left";
        gamestory.left.left.opt2s = "success no one me left";
        gamestory.left.right = new Tree();
        gamestory.left.right.story = "im gay right";
        gamestory.left.right.opt1s = "success im gay me right";
        gamestory.left.right.opt2s = "success no one me right";
        gamestory.right.left = new Tree();
        gamestory.right.left.story = "no ones gay left";
        gamestory.right.left.opt1s = "success im gay no one left";
        gamestory.right.left.opt2s = "success no one no one left";
        gamestory.right.right = new Tree();
        gamestory.right.right.story = "no ones gay right";
        gamestory.right.right.opt1s = "success im gay no one right";
        gamestory.right.right.opt2s = "success no one no one right";
        /**TextView gs = findViewById(R.id.gamedes);
        gs.setText(gamestory.story);
        opt1.setText(gamestory.opt1s);
        opt2.setText(gamestory.opt2s);*/
    }
    public class Tree {
        String story;
        String opt1s;
        String opt2s;
        Tree right;
        Tree left;
        boolean game = false;
    }
}
