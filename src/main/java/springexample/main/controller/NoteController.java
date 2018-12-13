package springexample.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springexample.main.model.Note;
import springexample.main.model.NotesResponse;
import springexample.main.service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteController extends BaseController {

	@Autowired
	NoteService noteService;

	@GetMapping("/notes")
	public ResponseEntity<?> getAllNotes() {
		List<Note> noteResponse = noteService.getAllNotes();
		if (isXmlRequested()) {
			return ResponseEntity.ok(new NotesResponse(noteResponse));
        }
		else {
			return ResponseEntity.ok(noteResponse) ;
		}
	}

	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note) {
		return noteService.createNote(note);
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<?> getNoteById(@PathVariable(value = "id") Long noteId) {
		return ResponseEntity.ok(noteService.getNoteById(noteId));
	}

	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {
		return noteService.updateNote(noteId, noteDetails);
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
		return noteService.deleteNote(noteId);
	}
}
