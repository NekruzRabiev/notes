package com.task.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.notes.entity.Note;
import com.task.notes.service.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {

	private NoteService noteService;
	
	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping("/list")
	public String getListOfNotes(Model model) {
		List<Note> notes = noteService.findAll();
		model.addAttribute("notes", notes);
		return "list-notes";
	}
	
	@GetMapping("/all")
	public String all() {
		return "list-notes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Note note = new Note();
		theModel.addAttribute("note", note);
		return "note-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("noteId") int id,
									Model theModel) {
		Note note = noteService.findById(id);
		theModel.addAttribute("note", note);
		return "note-form";			
	}
	
	@PostMapping("/save")
	public String saveNote(@ModelAttribute("note") Note note) {
		noteService.save(note);
		return "redirect:/notes/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("noteId") int id) {
		noteService.deleteById(id);
		return "redirect:/notes/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword,
						 Model theModel) {
		List<Note> notes = noteService.searchBy(keyword);
		theModel.addAttribute("notes", notes);
		return "search-notes";
	}
}
