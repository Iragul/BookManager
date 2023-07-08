package com.service;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
public class NewBook {
	List<String> Book=new ArrayList<>();
	int i=0;
	public void addnewbook(String Book_Input) {
		JSONObject Book_json=new JSONObject(Book_Input);
		String title=Book_json.getString("title");
		String author=Book_json.getString("author");
		String ISBN=Book_json.getString("ISBN");
	    String listadd=title+","+author+","+ISBN;
		Book.add(listadd);
	}
	public  List<String> Retrive_Book() {
		List<String> Book_retrive=new ArrayList<String>();
		for(String book_IS:Book)
		{
			String[] fields=book_IS.split(",");
			String title=fields[0];
			String author=fields[1];
			String ISBN=fields[2];
			String listadd="Title : "+title+","+"\nAuthor : "+author+","+"\nISBN : "+ISBN+"\n";
			Book_retrive.add(listadd);
		}
		return Book_retrive;
	}
	public  List<String> Retrive_Book_ISBN(String ISBN_filter) {
		List<String> Book_ISBN=new ArrayList<String>();
		for(String book_IS:Book)
		{
			String[] fields=book_IS.split(",");
			String title=fields[0];
			String author=fields[1];
			String ISBN=fields[2];
			if(ISBN.equals(ISBN_filter))
			{
				String listadd="Title : "+title+","+"\nAuthor : "+author+","+"\nISBN : "+ISBN+"\n";
				Book_ISBN.add(listadd);
				
			}
			
		}
		return Book_ISBN;
	}
	public String Update(String input)
	{
		JSONObject Book_json=new JSONObject(input);
		String title_update=Book_json.getString("title");
		String author_update=Book_json.getString("author");
		String ISBN_update=Book_json.getString("ISBN");
		int count=0;
		
		for(i=0;i<Book.size();i++)
		{
			String demo=Book.get(i);
			String[] fields=demo.split(",");
			String ISBN=fields[2];
			if(ISBN.equals(ISBN_update))
			{
				String listadd=title_update+","+author_update+","+ISBN_update;
				Book.set(i, listadd);
				count++;
			}
		}
		if(count>0)
		{
			return "Updated Sucessfully!";
		}
		return "No Data found to Update";
	}
    public String Delete(String input) {
    	JSONObject Book_json=new JSONObject(input);
		String ISBN_update=Book_json.getString("ISBN");
		int count=0;
		
		for(i=0;i<Book.size();i++)
		{
			String demo=Book.get(i);
			String[] fields=demo.split(",");
			String ISBN=fields[2];
			if(ISBN.equals(ISBN_update))
			{
				
				Book.remove(i);
				count++;
			}
		}
		if(count>0)
		{
			return "Deleted Sucessfully!";
		}
		return "No Data found to Delete";
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
