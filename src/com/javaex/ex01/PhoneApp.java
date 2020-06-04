package com.javaex.ex01;

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
import java.util.Scanner;

public class PhoneApp {

    public static void main(String[] args) throws IOException{
    	
    	Scanner sc = new Scanner(System.in);
    	InputStream is = new FileInputStream("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
    	InputStreamReader isr = new InputStreamReader(is,"UTF-8");
    	BufferedReader br = new BufferedReader(isr);
    	Writer fw = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt",true);
      	BufferedWriter bw = new BufferedWriter(fw);
      	//파일 삭제를 위한 fw1,fr1
		
	
		
    	List<Person> PL = new ArrayList<Person>();
    	String b;
    	
    	System.out.println("***********************************************");
    	System.out.println("*            전화번호 관리 프로그램           *");
    	System.out.println("***********************************************");
    	
    
    	while(true)
    	{
    		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
    		System.out.println("------------------------------------------");
    		System.out.print(">메뉴번호: ");
    		System.out.print("");
    		int a = sc.nextInt();
    		if(a==1)
    		{
    			while(true)
    			{
    				String str = br.readLine();
    				try
    				{
    					String[] s = str.split(",");
    					Person p = new Person(s[0],s[1],s[2]);		
    					PL.add(p);
    				}
    				catch(NullPointerException n)
    				{

    				}
    				if(str==null)
    				{
    					break;
    				}
    			}
    			System.out.println("1.리스트");
    			int i=1;
    			for(Person p : PL)
				{
    				
					System.out.print(i+".");
					p.showinfo();
					++i;
				}
    		}
    		else if(a==2)
    		{
    			Person p1 = new Person();
				System.out.print("이름 : ");
				p1.setName(sc.next());
				System.out.print("휴대전화 : ");
				p1.setHp(sc.next());
				System.out.print("회사전화 : ");
				p1.setCompany(sc.next());
				System.out.print("[등록되었습니다.]");
				System.out.println("");
				String c = p1.getName()+","+p1.getHp()+","+p1.getCompany();
				PL.add(p1);
				System.out.println(c);
				bw.write(c);
				bw.write("\n");
			
    		}
    		else if(a==3)
    		{
    			Writer fw1 = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
    	      	BufferedWriter bw1 = new BufferedWriter(fw1);
    			int i;
    			System.out.println("<3.삭제>");
    			System.out.println(">번호 : ");
    			i = sc.nextInt();
    			PL.remove(i-1);
    			for(Person p : PL)
    			{
    				String c = p.getName()+","+p.getHp()+","+p.getCompany();
    				bw1.write(c);
    				bw1.write("\n");
    			}
    			System.out.println("[삭제되었습니다.]");	

    	    	bw1.close();
    		}
    		
    		else if(a==4)
    		{
    			System.out.println("4.검색");
    			System.out.println("이름 : ");
    			b = sc.next();
    			for(Person p :PL)
    			{
    				if((p.getName()).contains(b))	
    				{
    					p.showinfo();
    				}
    			}
    			
    		}
    		else if(a==5)
    		{
    			System.out.println("***********************************************");
    	    	System.out.println("*                  감사합니다                 *");
    	    	System.out.println("***********************************************");
    			break;
    		}
    		else
    		{
	    		System.out.println("잘못 입력 하셨습니다.");	
	    		System.out.println("다시 입력해 주세요.");
    		}
    		
    	}
    	bw.close();
    }

}