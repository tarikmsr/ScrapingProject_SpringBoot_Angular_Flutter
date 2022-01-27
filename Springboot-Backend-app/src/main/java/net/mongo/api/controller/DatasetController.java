package net.mongo.api.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import net.mongo.api.model.Dataset;
import net.mongo.api.repository.DatasetRepository;



@CrossOrigin
@RestController
public class DatasetController {
	@Autowired
    private DatasetRepository rep;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/FlutterTest")
    public List<HashMap> getAppartement(){
    	ArrayList<String> aList = new ArrayList<String>();
    	ArrayList<String> pieces = new ArrayList<String>();
    	List<Dataset> apps=rep.findAll();
    	for (Dataset ap : apps) {
    	String s=ap.getLocalisation();
    	aList.add(s);
    	
    	}
    	int frequenceMozart = Collections.frequency(aList,"Mozart à              Tanger");
    	int frequenceMarjane = Collections.frequency(aList,"Marjane à              Tanger");
    	int frequenceMalabata = Collections.frequency(aList,"Malabata à              Tanger");
    	int frequenceTanger = Collections.frequency(aList,"Tanger");
    	int frequenceDeLaPlage= Collections.frequency(aList,"De La Plage à              Tanger");
    	int frequenceAdministratif= Collections.frequency(aList,"Administratif à              Tanger");
    	int frequenceMedina= Collections.frequency(aList,"Médina à              Tanger");
    	int frequenceCityCenter= Collections.frequency(aList,"Tanger City Center à              Tanger");
    	int frequenceCentre = Collections.frequency(aList,"Centre à              Tanger");
    	List<HashMap> list=new ArrayList<HashMap>();
    	
    	HashMap<String, Integer> capitalCities = new HashMap<String, Integer>();
        capitalCities.put("Tanger",frequenceTanger);
        capitalCities.put("Malabata", frequenceMalabata);
        capitalCities.put("Marjane", frequenceMarjane );
        capitalCities.put("Mozart", frequenceMozart);
        capitalCities.put("Medina", frequenceMedina);
        capitalCities.put("DeLaPlage", frequenceDeLaPlage);
        capitalCities.put("Administratif", frequenceAdministratif);
        capitalCities.put("CityCenter", frequenceCityCenter);
        capitalCities.put("Center", frequenceCentre );
        
        list.add(capitalCities);
    	return list;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/FlutterDataPrices")
    public List<HashMap> getData(){
    	HashMap<String, Double> prices = new HashMap<String, Double>();
    	HashMap<String, Integer> annonces = new HashMap<String, Integer>();
    	List<HashMap> list=new ArrayList<HashMap>();
    	List<String> adresses=new ArrayList<String>();
    	adresses.add("Tanger");
    	adresses.add("Centre à              Tanger");
    	adresses.add("Tanger City Center à              Tanger");
    	adresses.add("Médina à              Tanger");
    	adresses.add("Administratif à              Tanger");
    	adresses.add("De La Plage à              Tanger");
    	adresses.add("Marjane à              Tanger");
    	adresses.add("Mozart à              Tanger");
    	adresses.add("Malabata à              Tanger");
    	int i=0;
    	for(String ad: adresses) {
    		ArrayList<Double> pieceTanger = new ArrayList<Double>();
        	List<Dataset> apps=rep.findAll();
        	for (Dataset ap : apps) {
        	if(ap.getLocalisation().equals(ad)) {
        		pieceTanger.add(ap.getPrice());
        	}
        	}
        	Double som=0.0;
        	for(Double p: pieceTanger) {
        		som=som+p;
        	}
        	i++;
        	prices.put("item"+i,som/pieceTanger.size());
        	annonces.put("annonce"+i,pieceTanger.size());
    	}
    	list.add(prices);
    	list.add(annonces);
    	//prices.clear();
    	return list;
    }
    

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/saveData")
    public Dataset save(@RequestBody  Dataset newData){
    	Dataset data=new Dataset();
    	newData.setId(data.getId());
    	System.out.println(newData.toString());
    	return rep.save(newData);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/findAllDataSet")
    public List<Dataset> getAllAppartement(){
    	return rep.findAll();
    }
       
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/updateData/{id}")
    public Dataset update(@PathVariable String id,@RequestBody  Dataset newData){
    	Dataset data= rep.findById(id)
    			.orElseThrow(RuntimeException::new);
    	data.setTitre(newData.getTitre());
    	data.setLocalisation(newData.getLocalisation());
    	data.setNb_chambre(newData.getNb_chambre());
    	data.setNb_Salles_bain(newData.getNb_Salles_bain());
    	data.setNb_pieces(newData.getNb_pieces());
    	data.setPrice(newData.getPrice());
    	data.setSize(newData.getSize());
    	data.setEtat(newData.getEtat());
    	return rep.save(data);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/deleteDataLine/{id}")
    public void delete(@PathVariable String id) {
    	Dataset data= rep
    			.findById(id)
    			.orElseThrow(RuntimeException::new);
    	rep.delete(data);;
    }
    
    
    	

}