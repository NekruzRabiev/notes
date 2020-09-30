package com.task.notes.service;

import java.util.List;

import com.task.notes.entity.Note;

public interface NoteService {

	public List<Note> findAll();

	public void save(Note note);

	public void deleteById(int id);

	public List<Note> searchBy(String name);

	public Note findById(int id);

}
