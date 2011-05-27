package com.mrdzy.dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;

public class Dictionary {
	private Hashtable<String, String> hashFirst = new Hashtable<String, String>();
	private Hashtable<String, String> hashSecond = new Hashtable<String, String>();
	

	Dictionary(InputStream first, InputStream second){
		try {
			
			ObjectInputStream firstIn = new ObjectInputStream(first);
			ObjectInputStream secondIn = new ObjectInputStream(second);
			
			hashFirst = (Hashtable<String, String>)firstIn.readObject();
			hashSecond = (Hashtable<String, String>)secondIn.readObject();
			
			firstIn.close();
			secondIn.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getTransFirst(String inWord){
		
		String outWord = (String) hashFirst.get(inWord);
		
		return outWord;
	}
	public String getTransSecond(String inWord){
		
		String outWord = (String) hashSecond.get(inWord);
		
		return outWord;
	}
}
