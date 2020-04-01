package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;


@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		Persona p = new Persona();
		
        int i = Integer.valueOf(name);
        int iii = 0;        
        while (true) {         
            i++;
            p.setIdPersona(i);
    		p.setNombre("ManySIES  " + i );
    		repo.save(p);
    		model.addAttribute("name",name); 
    		
    		for (int ii = 0; ii < 10; ii++) {
    	        while (true) {
    			    iii =getRandomNumberInRange(1, 200000);
    	            if (iii==1974) { break;}
    	        }
    		}    		
            if (i==Integer.valueOf(name) + 10) { break;}
        }
        
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model) {
				
		model.addAttribute("personas",repo.findAll());
		
		return "greeting";
	}
	
	private static int getRandomNumberInRange(int min, int max) {
		
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
		
	}	
	

}
