package com.javaex.ex02;

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

import com.javaex.ex01.Person;

public class PhoneManager {
	
	private List<Person> pList;
	private Scanner sc;

	public PhoneManager() throws IOException{
	
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
		
	}

	// 시작준비 (시작화면 출력과 리스트 가져온다)
	public void showTitle() {
		
    	System.out.println("***********************************************");
    	System.out.println("*            전화번호 관리 프로그램           *");
    	System.out.println("***********************************************");
    	
	}

	// 메뉴 출력과 입력을 받는다.
	public int showMenu() {
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호: ");
		System.out.print("");
		int a = sc.nextInt();
		return a;
	}

	// 1.리스트선택시
	public void showList() throws IOException{
		System.out.println("1.리스트");
		int i=1;
		for(Person p : pList)
		{
			System.out.print(i+".");
			p.showinfo();
			++i;
		}
	}

	// 2.등록선택시
	public void showAdd() throws IOException{
		Writer fw = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt",true);
      	BufferedWriter bw = new BufferedWriter(fw);
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
		pList.add(p1);
		System.out.println(c);
		bw.write(c);
		bw.write("\n");
		bw.close();
	}

	// 3.삭제선택시
	public void showRemove() throws IOException{
		Writer fw1 = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
      	BufferedWriter bw1 = new BufferedWriter(fw1);
		int i;
		System.out.println("<3.삭제>");
		System.out.println(">번호 : ");
		i = sc.nextInt();
		pList.remove(i-1);
		for(Person p : pList)
		{
			String c = p.getName()+","+p.getHp()+","+p.getCompany();
			bw1.write(c);
			bw1.write("\n");
		}
		System.out.println("[삭제되었습니다.]");	
		bw1.close();
	}

	// 4.검색선택시
	public void showSearch() throws IOException{
		String b;
		System.out.println("4.검색");
		System.out.println("이름 : ");
		b = sc.next();
		for(Person p :pList)
		{
			if((p.getName()).contains(b))	
			{
				p.showinfo();
			}
		}
		
	}

	// 5.종료시
	public void showEnd() {
		System.out.println("***********************************************");
    	System.out.println("*                  감사합니다                 *");
    	System.out.println("***********************************************");
	}
	
	
	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {

		System.out.println("잘못 입력 하셨습니다.");	
		System.out.println("다시 입력해 주세요.");
	}
	
	
	// 파일을 읽어 리스트에 담아 전달한다.
	private List<Person> getList() throws IOException{
		
		InputStream is = new FileInputStream("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
    	InputStreamReader isr = new InputStreamReader(is,"UTF-8");
    	BufferedReader br = new BufferedReader(isr);
		
		while(true)
		{
			String str = br.readLine();
			try
			{
				String[] s = str.split(",");
				Person p = new Person(s[0],s[1],s[2]);		
				pList.add(p);
			}
			catch(NullPointerException n)
			{
				
			}
			if(str==null)
			{
				break;
			}
		}
		return pList;
	}

	// 리스트를 파일에 저장한다.
	private void saveList() throws IOException{
		Writer fw = new FileWriter("c:\\javaStudy\\workspace\\minipro\\PhoneDB.txt",true);
    	BufferedWriter bfw = new BufferedWriter(fw);
    	
    	for(Person p : pList)
    	{
    		String c = p.getName()+","+p.getHp()+","+p.getCompany();
    		bfw.write(c);	
    	}
	}


	
}
