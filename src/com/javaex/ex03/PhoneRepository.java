package com.javaex.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class PhoneRepository {

    
    //phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList() throws IOException{
	InputStream is = new FileInputStream("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
	InputStreamReader isr = new InputStreamReader(is,"UTF-8");
	BufferedReader br = new BufferedReader(isr);
	List<Person> phoneList = new ArrayList<Person>();
	
	while(true)
	{
		String str = br.readLine();
		try
		{
			String[] s = str.split(",");
			Person p = new Person(s[0],s[1],s[2]);
			phoneList.add(p);
		}catch(NullPointerException n)
		{
			
		}
		if(str==null)
		{
			break;
		}
	}
	return phoneList;
	}
	
	//기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드 
	public void addInfo(Person phoneVO) throws IOException{
		Writer fw = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt",true);
    	BufferedWriter bfw = new BufferedWriter(fw);
    	List<Person> phoneList = new ArrayList<Person>();
    	phoneList.add(phoneVO);
    	for(Person p : phoneList)
    	{
    		String c = p.getName()+","+p.getHp()+","+p.getCompany();
    		bfw.write(c);
    	}
    	bfw.close();
	}

	//선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) throws IOException{
		InputStream is = new FileInputStream("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		/*
    
      	*/
      	List<Person> phoneList = new ArrayList<Person>();
      	
      	while(true)
    	{
    		String str = br.readLine();
    		try
    		{
    			String[] s = str.split(",");
    			Person p = new Person(s[0],s[1],s[2]);
    			phoneList.add(p);
    		}catch(NullPointerException n)
    		{
    			
    		}
    		if(str==null)
    		{
    			break;
    		}
    	}
      	for(Person p : phoneList)
      	{
      		p.showinfo();
      	}
      	System.out.println(num);
      	phoneList.remove(num-1);
      	Writer fw1 = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
      	BufferedWriter bw1 = new BufferedWriter(fw1);
		for(Person p : phoneList)
		{
			String c = p.getName()+","+p.getHp()+","+p.getCompany();
			bw1.write(c);
			bw1.write("\n");
		}
		
		bw1.close();
		
	}
	

}
