package com.example.blackstoriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView image;
    private ToggleButton answer;
    private static int images[][] = ImagesArray.image();  //import array of images
    private int randomNumber=0;
    private int newImage;

    public static int randomImage() {
        int num=(int)(Math.random()*images[0].length);
        //System.out.print(num);	//check random number outcome
        return num;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.card);
        answer = (ToggleButton) findViewById(R.id.answer);

        button = (Button) findViewById(R.id.nextCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = randomImage();
                //newImage=images[0][randomNumber];
                newImage = images[0][randomNumber];

                image.setImageResource(newImage);
                answer.setChecked(false);

            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.isChecked()){
                    newImage = images[1][randomNumber];
                    image.setImageResource(newImage);
                    answer.setTextColor(0xDCDC143C);
                    answer.setBackgroundColor(0xffffffff);
                }else{
                    newImage = images[0][randomNumber];
                    image.setImageResource(newImage);
                    answer.setTextColor(0xffffffff);
                    answer.setBackgroundColor(0xDCDC143C);
                }
            }
        });

    }
}
