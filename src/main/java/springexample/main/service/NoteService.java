package springexample.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import springexample.main.model.Note;

public interface NoteService {

	public List<Note> getAllNotes();

	public Note createNote(Note note);

	public Note getNoteById(Long noteId);

	public Note updateNote(Long noteId, Note noteDetails);

	public ResponseEntity<?> deleteNote(Long noteId);
}
