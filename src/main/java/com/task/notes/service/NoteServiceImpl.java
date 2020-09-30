package com.task.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.notes.dao.NoteRepository;
import com.task.notes.entity.Note;

@Service
public class NoteServiceImpl implements NoteService {

	private NoteRepository noteRepository;

	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@Override
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public void save(Note note) {
		noteRepository.save(note);
	}

	@Override
	public void deleteById(int id) {
		noteRepository.deleteById(id);
	}

	@Override
	public List<Note> searchBy(String keyword) {

		List<Note> results = null;

		if (keyword != null && !keyword.isBlank()) {
			results = noteRepository.searchBy(keyword);
		} else {
			results = findAll();
		}

		return results;
	}

	@Override
	public Note findById(int id) {
		Optional<Note> result = noteRepository.findById(id);

		Note note = null;

		if (result.isPresent()) {
			note = result.get();
		} else {
			throw new RuntimeException("Did not find note id - " + id);
		}

		return note;
	}
}
