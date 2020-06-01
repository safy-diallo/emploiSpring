package hasa.hafia.controlleur;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hasa.hafia.dao.ICandidat;
import hasa.hafia.entites.Candidat;


@Controller
public class CandidatControlleur {
	

	@Autowired
	private ICandidat candidatdao;
	//recuperation de la liste au niveau de le db
	@RequestMapping(value="/Candidat/liste")
	public String liste(ModelMap model)
	{	
		List<Candidat> candidat=candidatdao.findAll();
		
		model.put("liste_candidats",candidat);
		model.put("candidat",new Candidat());
		
		
		return "candidature/liste";
	}
@RequestMapping(value = "/Candidat/add", method = { RequestMethod.GET, RequestMethod.POST })
	
	public String add(int id,String nom, String prenom,String experience,String Disponibilite,Date date,String niveauEtude,String motivation) 
	{
	
	
		Candidat candidat=new Candidat();
		candidat.setId(id);
		candidat.setNom(nom);
		candidat.setPrenom(prenom);
		candidat.setExperience(Integer.parseInt(experience));
		candidat.setDisponibilite(Disponibilite);
		candidat.setMotivation(motivation);
		candidat.setNiveauEtude(niveauEtude);
		//candidat.setDate(date);
		System.out.println("======================================================");
		System.out.println(Integer.parseInt(experience)+""+Disponibilite+""+date+""+motivation+"");
		System.out.println("======================================================");

		
		
		try {
			candidatdao.save(candidat);//ajout ou mise à jour
			candidatdao.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Candidat/liste";
	}
	
@RequestMapping(value="/Candidat/edit",method = RequestMethod.GET)
public String edit (int id,ModelMap model)
{
	try {
		List<Candidat> candidats = candidatdao.findAll();
		model.put("liste_candidats", candidats);
		Candidat candidat=  candidatdao.getOne(id);
		model.put("candidat", candidat);
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return "candidature/liste";
}


@RequestMapping(value="/Candidat/delete",method = RequestMethod.GET)
public String delete (int id)
{
	try {
		candidatdao.delete(candidatdao.getOne(id));
		candidatdao.flush();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "redirect:/Candidat/liste";
}
	
}

