package springexample.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springexample.main.exception.ResourceNotFoundException;
import springexample.main.model.Note;
import springexample.main.repository.NoteRepository;

@Service("noteService")
public class NoteServiceImp implements NoteService {

	@Autowired
	NoteRepository noteRepository;

	@Override
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	@Override
	public Note createNote(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public Note getNoteById(Long noteId) {
		// TODO Auto-generated method stub
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}

	@Override
	public Note updateNote(Long noteId, Note noteDetails) {
		// TODO Auto-generated method stub
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());

		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}

	@Override
	public ResponseEntity<?> deleteNote(Long noteId) {
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		noteRepository.delete(note);
		return ResponseEntity.ok().build();
	}

}
