package springexample.main.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import springexample.main.controller.NoteController;
import springexample.main.model.Note;
import springexample.main.service.NoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
@ContextConfiguration(classes = { NoteController.class })
public class HelloControllerTest {

	private static final String api_get_notes = "/api/notes";
	private static final String api_get_specific_note = "/api/notes/1";
	
	@Autowired
	private MockMvc mvc;

	@SpyBean
	private NoteService noteService;
	
	@MockBean
	private NoteService notes;
	
	@Test
	public void getNotes() throws Exception {

		List<Note> noteLists = mockGetNoteList();
		Note noteResponse = getExpectedNoteResponse();
		when(notes.getAllNotes()).thenReturn(noteLists);
		mvc.perform(get(api_get_notes).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(noteResponse.getId().intValue()))
				.andExpect(jsonPath("$[0].title").value(noteResponse.getTitle()))
				.andExpect(jsonPath("$[0].content").value(noteResponse.getContent()))
				.andExpect(jsonPath("$[0].createdAt").value("2018-12-31T18:07:50.000+0000"))
				.andExpect(jsonPath("$[0].updatedAt").value("2018-12-31T18:07:50.000+0000"));
		verify(notes).getAllNotes();
		verify(noteService, times(1)).getAllNotes();
		verifyNoMoreInteractions(noteService);
	}

	@Test
	public void getNotesById() throws Exception {

		Note specificNote = mockGetNoteSpecific();
		Note noteResponse = getExpectedNoteResponse();
		when(notes.getNoteById(1L)).thenReturn(specificNote);
		mvc.perform(get(api_get_specific_note).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(noteResponse.getId().intValue()))
				.andExpect(jsonPath("$.title").value(noteResponse.getTitle()))
				.andExpect(jsonPath("$.content").value(noteResponse.getContent()))
				.andExpect(jsonPath("$.createdAt").value("2018-12-31T18:07:50.000+0000"))
				.andExpect(jsonPath("$.updatedAt").value("2018-12-31T18:07:50.000+0000"));
		verify(notes).getNoteById(1L);
		verify(noteService, times(1)).getNoteById(1L);
		verifyNoMoreInteractions(noteService);
	}

	private Note mockGetNoteSpecific() {
		Note note = new Note();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		note.setId(1L);
		note.setTitle("my First Note");
		note.setContent("the thing about daily life");
		try {
			note.setCreatedAt(dateFormat.parse("2018-12-31T18:07:50.000+0000"));
			note.setUpdatedAt(dateFormat.parse("2018-12-31T18:07:50.000+0000"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}

	private List<Note> mockGetNoteList() {
		List<Note> notes = new ArrayList<>();
		Note note = new Note();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		note.setId(1L);
		note.setTitle("my First Note");
		note.setContent("the thing about daily life");
		try {
			note.setCreatedAt(dateFormat.parse("2018-12-31T18:07:50.000+0000"));
			note.setUpdatedAt(dateFormat.parse("2018-12-31T18:07:50.000+0000"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notes.add(note);
		return notes;
	}

	private Note getExpectedNoteResponse() {
		Note note = new Note();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		note.setId(1L);
		note.setTitle("my First Note");
		note.setContent("the thing about daily life");
		try {
			note.setCreatedAt(dateFormat.parse("2018-12-31T18:07:50.000+0000"));
			note.setUpdatedAt(dateFormat.parse("2018-12-31T18:07:50.000+0000"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}

}
