package ca.drsystems.lockscreen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CheckPassword extends AppCompatActivity {
    Integer[] numericOptions = new Integer[]{0,1,2,3,4,5,6,7,8,9};
    Integer[] shapeOptions = new Integer[]{0,1,2};
    Integer[] colourOptions = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    ArrayList<Integer> numericList = new ArrayList();
    ArrayList<Integer> shapeList = new ArrayList();
    ArrayList<Integer> colourList = new ArrayList();

    PasswordBlock[] displayArray = new PasswordBlock[29];

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_password);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        populateGrid();
    }
    public void populateGrid(){


        numericList.addAll(Arrays.asList(numericOptions));
        shapeList.addAll(Arrays.asList(shapeOptions));
        colourList.addAll(Arrays.asList(colourOptions));

        for (int i = 0; i > displayArray.length;i++){
            displayArray[i] = GenerateBlock();
        }
    }
    public PasswordBlock GenerateBlock(){
        int num = 0;int sha = 0; int col = 0;
        if(numericList.isEmpty()){
            numericList.addAll(Arrays.asList(numericOptions));
        }
        else {
            num = numericList.remove(rand.nextInt(numericList.size() - 1));
        }
        if(shapeList.isEmpty()){
            shapeList.addAll(Arrays.asList(shapeOptions));
        }
        else {
            num = shapeList.remove(rand.nextInt(shapeList.size() - 1));
        }
        if(colourList.isEmpty()){
            colourList.addAll(Arrays.asList(colourOptions));
        }
        else {
            num = colourList.remove(rand.nextInt(colourList.size() - 1));
        }
        PasswordBlock block = new PasswordBlock(num,sha,col);

        return block;
    }
    public static class PasswordBlock {
        public int numeric, shape, colour;

        public PasswordBlock(int n,int s,int c){
            this.numeric = n;
            this.shape = s;
            this.colour = c;
        }
        public int getNumeric() {
            return this.numeric;
        }
        public int getShape(){
            return this.shape;
        }
        public int getColour(){
            return this.colour;
        }
    }

}