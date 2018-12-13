package springexample.main.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "ArrayOfNotes")
public class NotesResponse{

	@JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Note")
	List<Note> notes;
	
	

	public NotesResponse(List<Note> noteResponse) {
		super();
		this.notes = noteResponse;
	}

	public List<Note> getNotes() {
		return notes;
	}
}
