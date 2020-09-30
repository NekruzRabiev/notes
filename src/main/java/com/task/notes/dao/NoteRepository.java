package com.task.notes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.task.notes.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

	@Query("SELECT n FROM Note n WHERE n.title LIKE %:keyword% OR n.content LIKE %:keyword%")
	public List<Note> searchBy(@Param("keyword") String keyword);
}
