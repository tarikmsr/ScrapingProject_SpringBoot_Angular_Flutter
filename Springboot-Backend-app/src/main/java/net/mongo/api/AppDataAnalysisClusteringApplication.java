package net.mongo.api;

import javax.el.ELException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import net.mongo.api.model.Dataset;
import net.mongo.api.model.Utilisateur;
import net.mongo.api.repository.DatasetRepository;
import net.mongo.api.repository.Utilisateurrepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppDataAnalysisClusteringApplication implements CommandLineRunner {
	@Autowired
	private  Utilisateurrepository repository;
	@Autowired
	private DatasetRepository rep;

	public static void main(String[] args) {
		SpringApplication.run(AppDataAnalysisClusteringApplication.class, args);
		
		
	}
	@Override
	public void run(String... args) throws Exception {

		/*Document doc = Jsoup.connect("https://news.ycombinator.com/").timeout(6000).get();
		Elements body = doc.select("table.itemlist");
		System.out.println(body.select("tr").size());
		int i=0;*/
		Utilisateur a =new Utilisateur();
		Dataset s=new Dataset();

		/*for(Element e : body.select("tr"))
		{
		   // String img = e.select("td.posterColumn img").attr("src");
		    //System.out.println(img);
		    String title = e.select("a.titlelink").text();
		    System.out.println(title);
		    if(i==0) {*/
		/*DataSet d=new DataSet();
		s.setId();
		s.setData("hhhhhhh");
		rep.save(s);*/

		
		
		    	
		    	//repository.save(a);
		    	/*i++;
		    }
		}*/
		
	}


}