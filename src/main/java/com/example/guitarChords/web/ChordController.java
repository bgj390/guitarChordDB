package com.example.guitarChords.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.guitarChords.model.Chord;
import com.example.guitarChords.model.ChordRepository;
import com.example.guitarChords.model.StringA2Repository;
import com.example.guitarChords.model.StringD3Repository;
import com.example.guitarChords.model.StringE1Repository;
import com.example.guitarChords.model.StringE6Repository;
import com.example.guitarChords.model.StringG4Repository;
import com.example.guitarChords.model.StringH5Repository;

@Controller
public class ChordController {
    
	@Autowired
	private ChordRepository cRep;
	@Autowired
	private StringE1Repository e1Rep;
	@Autowired
	private StringA2Repository a2Rep;
	@Autowired
	private StringD3Repository d3Rep;
	@Autowired
	private StringG4Repository g4Rep;
	@Autowired
	private StringH5Repository h5Rep;
	@Autowired
	private StringE6Repository e6Rep;

	// Log in
/*	@RequestMapping(value="/")
	public String login() {
		return "login";
	}
*/	// Show all chords
	@RequestMapping(value="/chordlist", method = RequestMethod.GET)
	public String chordlist(Model model) {
		model.addAttribute("chords", cRep.findAll());
		return "chordlist";
	}
	
	@RequestMapping("/apipage")
	public String apipage(Model model) {
		return "apipage";
	}	
	// RESTful service to get all chords
    @RequestMapping(value="/chords", method = RequestMethod.GET)
    public @ResponseBody List<Chord> chordListRest() {	
        return (List<Chord>) cRep.findAll();
    } 
	// RESTful service to get a chord by id
    @RequestMapping(value="/chord/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Chord> findChordRest(@PathVariable("id") Long chordId) {	
    	return cRep.findById(chordId);
    } 
    // Add a chord
    @RequestMapping(value="/add")
    public String addChord(Model model) {
    	model.addAttribute("chords", cRep.findAll());
    	model.addAttribute("chord", new Chord());
    	model.addAttribute("stringE6s", e6Rep.findAll());
    	model.addAttribute("stringH5s", h5Rep.findAll());
    	model.addAttribute("stringG4s", g4Rep.findAll());
    	model.addAttribute("stringD3s", d3Rep.findAll());
    	model.addAttribute("stringA2s", a2Rep.findAll());
    	model.addAttribute("stringE1s", e1Rep.findAll());
        return "addchord";
    }
    // Save a chord
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Chord chord) {
        cRep.save(chord);
        return "redirect:chordlist";
    }
    // Delete a chord
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteChord(@PathVariable("id") Long chordId, Model model) {
    	cRep.deleteById(chordId);
        return "redirect:../chordlist";
    } 
    // Edit a chord
    @RequestMapping(value="/edit/{id}")
    public String editChord(@PathVariable("id") Long chordId, Model model) {
    	model.addAttribute("chord", cRep.findById(chordId));
    	model.addAttribute("stringE6s", e6Rep.findAll());
    	model.addAttribute("stringH5s", h5Rep.findAll());
    	model.addAttribute("stringG4s", g4Rep.findAll());
    	model.addAttribute("stringD3s", d3Rep.findAll());
    	model.addAttribute("stringA2s", a2Rep.findAll());
    	model.addAttribute("stringE1s", e1Rep.findAll());
    	return "editchord";
    }
/*     // View a chord
    @RequestMapping(value="/view/{id}")
    public String addChordtoCart(@PathVariable("id") Long chordId, Model model) {
    	model.addAttribute("chord", cRep.findById(chordId));
   // 	model.addAttribute("ids", cRep.findIdByName(chordName));
    	model.addAttribute("stringE6s", e6Rep.findAll());
    	model.addAttribute("stringH5s", h5Rep.findAll());
    	model.addAttribute("stringG4s", g4Rep.findAll());
    	model.addAttribute("stringD3s", d3Rep.findAll());
    	model.addAttribute("stringA2s", a2Rep.findAll());
    	model.addAttribute("stringE1s", e1Rep.findAll());
    	return "shortchordlist";
    }	*/
}
