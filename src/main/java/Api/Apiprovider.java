package Api;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import com.service.*;

public class Apiprovider {
	public static void main(String args[])
	{
		final NewBook bok=new NewBook();
       port(9090);
       post("/create", (req,res) ->{
    	   String Book_add=req.body();
    	  
    	   bok.addnewbook(Book_add);
    	   
    	   return "Added sucessfully ";
       });
       get("/Viewbook", (req,res) -> {
    	   return bok.Retrive_Book();
       });
       get("/Viewbook_ISBN", (req,res) -> {
    	   String ISBN;
    	   ISBN=req.queryParams("ISBN");
    	  return bok.Retrive_Book_ISBN(ISBN);
       });
       post("/Update", (req,res) ->{
    	   String update_in=req.body();
    	   return bok.Update(update_in);
       });
       post("/Delete", (req,res) ->{
    	   String update_in=req.body();
    	   return bok.Delete(update_in);
       });
	}

	
}
