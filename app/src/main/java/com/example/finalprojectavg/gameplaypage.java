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
        TextView gs = findViewById(R.id.gamedes);
        gs.setText(gamestory.story);
        opt1.setText(gamestory.opt1s);
        opt2.setText(gamestory.opt2s);
        decision(gamestory, gs, opt1, opt2, mng);
        /**opt1.setOnClickListener(unused-> {
            if (gamestory.left.game) {
                mng.setVisibility(View.VISIBLE);
                gotomng(gamestory.left, mng);
            }
            gs.setText(gamestory.left.story);
            opt1.setText(gamestory.left.opt1s);
            opt2.setText(gamestory.left.opt2s);
            //gamestory = gamestory.left;
            opt1.setOnClickListener(used-> {
                gotomng(gamestory.left.left, mng);
                gs.setText(gamestory.left.left.story);
                opt1.setText(gamestory.left.left.opt1s);
                opt2.setText(gamestory.left.left.opt2s);
                //gamestory = gamestory.left;
                opt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (gamestory.left.left.left == null) {
                            opt1.setVisibility(View.GONE);
                            opt2.setVisibility(View.GONE);
                            mng.setVisibility(View.GONE);
                            gs.setText("Game Over");
                        }
                    }
                });
            });
            opt2.setOnClickListener(used-> {
                if (gamestory.left.right.game) {
                    mng.setVisibility(View.VISIBLE);
                    //gotomng();
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
        });*/
    }

    /**
     * decide whether to go to minigame.
     * @param currentgamestory the current positon in the stroy.
     */
    public void gotomng(Tree currentgamestory, Button mng) {
        //Button mng = findViewById(R.id.minigame);
        if (currentgamestory.game) {
            mng.setVisibility(View.VISIBLE);
            currentgamestory.game = false;
        } else {
            mng.setVisibility(View.GONE);
        }
        mng.setOnClickListener(unused-> {
            Intent jumpminigame = new Intent(this, minigame.class);
            //jumpminigame.putExtra("position", currentgamestory);
            startActivity(jumpminigame);
            finish();
        });
    }
    public void decision(Tree story, TextView gs, Button opt1, Button opt2, Button mng) {
        if (story.left == null || story.right == null) {
            if (!story.game) {
                opt1.setVisibility(View.GONE);
                opt2.setVisibility(View.GONE);
                mng.setVisibility(View.GONE);
                gs.setText("GAME OVER\n" + story.story);
            } else {
                opt1.setVisibility(View.GONE);
                opt2.setVisibility(View.GONE);
                mng.setVisibility(View.GONE);
                gs.setText("CHANLLENGE\n" + story.story);
            }
        }

        gotomng(story, mng);

        opt1.setOnClickListener(unused -> {
            gs.setText(story.left.story);
            opt1.setText(story.left.opt1s);
            opt2.setText(story.left.opt2s);
            //decision(story.left, gs, opt1, opt2, mng);
            decision(story.left, gs, opt1, opt2, mng);
        });
        opt2.setOnClickListener(unused -> {
            gs.setText(story.right.story);
            opt1.setText(story.right.opt1s);
            opt2.setText(story.right.opt2s);
            //decision(story.right, gs, opt1, opt2, mng);
            decision(story.right, gs, opt1, opt2, mng);
        });
    }

    /**
     * wofole
     * @param gamestory story.
     */
    public void setStory(Tree gamestory) {
        gamestory.story = "Wake up after a sound sleep, you open your eyes and find nothing to see, surrounding by death-like darkness and silence. You try to move your body, sit up and look around. BUT YOU CAN’T. When you hit something with your head and make a \"bang\", you realize that you are trapped—by a coffin. NOW YOU DECIDE TO";
        gamestory.opt1s = "Whatever, it must be a dream, continue to sleep. ";
        gamestory.opt2s = "Yelling! What if there is someone?";


        gamestory.left = new Tree();//1L(final
        //gamestory.left.game = true;
        gamestory.left.story = "You gradually fell asleep, but you never woke up again. A few days later, the police found your cold body and you died alone in the coffin.";
        //one finale
        //gamestory.left.left = new Tree();
        //gamestory.left.right = new Tree();

        gamestory.right = new Tree();//1R
        gamestory.right.story = "You tried to yell, but unfortunately, the only thing that responded to your shout was silence that could drive people into madness. You start to be panic. ";
        gamestory.right.opt1s = "Groping around.";
        gamestory.right.opt2s = "Keep yelling.";


        gamestory.right.left = new Tree();//2RL
        gamestory.right.left.story = "Congratulations! You found a lighter on the right side of the coffin. You were thus able to ignite the lighter to observe your environment. You lighted the lighter, looked around with the flame, and found a line of words directly above you, the top of the coffin. “Call this number or die.”";
        gamestory.right.left.opt1s = "What?";
        gamestory.right.left.opt2s = "How?";

        gamestory.right.right = new Tree();//2RR
        gamestory.right.right.story = "You kept shouting, but nothing could respond to you, and finally, the oxygen in the coffin became thinner. You start to feel difficulty to breath.";
        gamestory.right.right.opt1s = "Give up.";
        gamestory.right.right.opt2s = "Try to break the top of the coffin.";


        gamestory.right.left.left = new Tree();//3RLL
        gamestory.right.left.left.story = "In a panic, the lighter fell out of your hand. Darkness returned all around. While you were looking for a lighter, there was a vibration at the bottom of the coffin and a faint blue light.";
        gamestory.right.left.left.opt1s = "Investigate.";
        gamestory.right.left.left.opt2s = "Ignore.";

        gamestory.right.left.right = new Tree();//3RLR(final
        gamestory.right.left.right.story = "You wondered how can you call the number without a phone. So you decided to ignore those words. But besides the line of words you couldn't find any other clue. You eventually died because of asphyxia caused by the flame you lighted.";


        gamestory.right.right.left = new Tree();//3RRL(final
        gamestory.right.right.left.story = "You had chosen to give up doing anything. In the dark, you looked forward to someone passing by and detecting anomalies. But unfortunately, as time goes on, the slow suffocation made you realized that your hopes were becoming vaguer. Finally, with the body twitch, you died in despair.";

        gamestory.right.right.right = new Tree();//3RRR(final
        gamestory.right.right.right.story = "You did try everything to overcome all difficulties. But the miracle didn't happen. At your funeral, said the minister.";


        gamestory.right.left.left.left = new Tree();//4RLLL
        gamestory.right.left.left.left.story = "Oh my God! You found a cell phone and you thought it might be a turnaround. But then you find out that this phone can only be used for dialing.";
        gamestory.right.left.left.left.opt1s = "Call the police..";
        gamestory.right.left.left.left.opt2s = "Call the number.";

        gamestory.right.left.left.right = new Tree();//4RLLR(final
        gamestory.right.left.left.right.story = "You didn’t think about the consequences of disregard, and in the slow suffocation you died with pain and regret.";


        gamestory.right.left.left.left.left = new Tree();//5RLLLL
        gamestory.right.left.left.left.left.story = " You called the police and explained to them everything that happened to you. Unfortunately, the police think you are joking and warn you not to call again, or you will be arrested.";
        gamestory.right.left.left.left.left.opt1s = "Call again.";
        gamestory.right.left.left.left.left.opt2s = "Stop Calling.";

        gamestory.right.left.left.left.right = new Tree();//5RLLLR
        gamestory.right.left.left.left.right.story = "You called the number and you found that the other person was the one who buried you in the coffin. You questioned why that person did this to you. \"This is a test,\" the man replied, \"this is a challenge to death. You are just a person picked out by me. I wonder if you can defeat death.\"";
        gamestory.right.left.left.left.right.opt1s = "“Oh yeah? Fxxk you!!!”";
        gamestory.right.left.left.left.right.opt2s = "“What is the challenge?”";


        gamestory.right.left.left.left.left.left = new Tree();//6RLLLLL(final
        gamestory.right.left.left.left.left.left.story = "You angered the police. They vowed to arrest you and to report you to court. You continue to insult the police on the other side of the phone, doing so you think you can be saved therefore.The police did find you, but because of your long abuse, the oxygen in the coffin was consumed a lot. When the police found you, you had been asphyxiated for more than 3 minutes. This caused irreversible damage to your brain. Although you are still alive, you become a vegetative.";

        gamestory.right.left.left.left.left.right = new Tree();//6RLLLLR(final
        gamestory.right.left.left.left.left.right.story = "You stopped calling the police. You then called your home and your wife was on the phone. You wanted to tell your wife that you were trapped in a coffin, but what could she do about it? This would just worry your family. So, you chose to pretend nothing happened, you just wanted to hear her voice. Finally, with your wife's voice, you closed your eyes in the coffin.";

        gamestory.right.left.left.left.right.left = new Tree();//6RLLLRL(final
        gamestory.right.left.left.left.right.left.story = "That person hung up and made the signal on your cell phone lost. You died in despair in darkness and silence.";

        gamestory.right.left.left.left.right.right = new Tree();//6RLLLRR
        gamestory.right.left.left.left.right.right.story = "\"What is the challenge?\" You asked. The man was silent for a long time, and then he told you, \"I said, this is your challenge to death.\" Then he hung up. You look at your phone and decide";
        gamestory.right.left.left.left.right.right.opt1s = "Call the police.";
        gamestory.right.left.left.left.right.right.opt2s = "Observe the coffin with mobile phone light.";

        gamestory.right.left.left.left.right.right.left = new Tree();//7RLLLRRL(final
        gamestory.right.left.left.left.right.right.left.story = "The police did find you, but the oxygen in the coffin was consumed a lot. When the police found you, you had been asphyxiated for more than 3 minutes. This caused irreversible damage to your brain. Although you are still alive, you become a vegetative.";

        gamestory.right.left.left.left.right.right.right = new Tree();//7RLLLRRR
        gamestory.right.left.left.left.right.right.right.story = "You found pull rings on the left and right of the coffin, and you immediately decided to pull the pull rings. As the pull ring was pulled, a crack appeared on the top of the coffin. The size of the crack is not enough for you to escape, but the gravel begins to enter the coffin.";
        gamestory.right.left.left.left.right.right.right.opt1s = "Try to open the crack by pulling.";
        gamestory.right.left.left.left.right.right.right.opt2s = "Try to open the crack by pushing.";


        gamestory.right.left.left.left.right.right.right.left = new Tree();//8RLLLRRRL(minigame
        gamestory.right.left.left.left.right.right.right.left.game = true;
        gamestory.right.left.left.left.right.right.right.left.story = "By pulling, massive mud and gravel poured into the coffin, and soon most of your body was covered by it. Then you suddenly noticed a white thing, you were not sure what it was, but you instinctively grabbed it.";

        gamestory.right.left.left.left.right.right.right.right = new Tree();//8RLLLRRRR(final
        gamestory.right.left.left.left.right.right.right.right.story = "By pushing, massive mud and gravel poured into the coffin, and soon most of your body was covered by it. You tried to keep pushing, but you couldn’t push anymore. You could only watch the mud pouring in, drowning you completely.";




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
