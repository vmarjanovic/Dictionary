package com.mrdzy.dictionary;


import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.util.TimingLogger;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

	

public class AndroidDictionary extends Activity{
    /** Called when the activity is first created. */
	String mWord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//        TimingLogger timings = new TimingLogger("TopicLogTag",
 //       "loading Dicitionary");

        InputStream first = getResources().openRawResource(R.raw.sp_en_hb);
        InputStream second = getResources().openRawResource(R.raw.en_sp_hb);
//        timings.addSplit("load file from memory");
        
        final Dictionary spanEnglish = new Dictionary(first, second);
//        timings.addSplit("call constructor");
//        timings.dumpToLog();

		
        setContentView(R.layout.main);
        
        final Button button1 = (Button) findViewById(R.id.sp_en);
        button1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
                // Perform action on clicks
        		TextView tv;
        		EditText ed;
        		ed = (EditText) findViewById(R.id.entry);
        		tv = (TextView) findViewById(R.id.output);
        		
        		
        		mWord = ed.getText().toString();
        		
        		mWord = mWord.replaceAll("\\s+", " ");
        		mWord = mWord.trim();
        		
        		String one = spanEnglish.getTransFirst(mWord);
 		
            	tv.setText(one);
           
        	}
        });
        
        final Button button2 = (Button) findViewById(R.id.en_sp);
        button2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
                // Perform action on clicks
        		TextView tv;
        		EditText ed;
        		ed = (EditText) findViewById(R.id.entry);
        		tv = (TextView) findViewById(R.id.output);
 	
        		mWord = ed.getText().toString();
        		
        		mWord = mWord.replaceAll("\\s+", " ");
        		mWord = mWord.trim();
        		
        		String one = spanEnglish.getTransSecond(mWord);        		        		
     		         		
            	tv.setText(one);
           
        	}
        });
  
        
    
    }
}