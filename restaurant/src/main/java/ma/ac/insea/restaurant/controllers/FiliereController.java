package ma.ac.insea.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ma.ac.insea.restaurant.entities.Filiere;
import ma.ac.insea.restaurant.services.FiliereService;

@Controller
@RequestMapping("/filiere")
public class FiliereController {
		
	@Autowired
	private FiliereService filiereService; 
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPage(Model model) {
		model.addAttribute("filiere",new Filiere());
		return "filiere/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute Filiere filiere, Model model) {
		filiereService.save(filiere);			
		return "redirect:list";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String find(Model model,@PathVariable("id") Long id) {
		model.addAttribute("filiere",this.filiereService.getById(id));
		return "filiere/add";
	}
	
	@RequestMapping(value="/remove/{id}",method=RequestMethod.GET)
	public String remove(@PathVariable("id") Long id, Model model) {
		this.filiereService.delete(id);
		//return "redirect:list";
		return "redirect:/filiere/list";
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<Filiere> filieres=filiereService.read();
		model.addAttribute("filieres",filieres);
		return "filiere/list";
	}

	
}
