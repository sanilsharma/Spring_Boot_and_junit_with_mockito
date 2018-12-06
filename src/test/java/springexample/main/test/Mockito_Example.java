package springexample.main.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Mockito_Example {

	@Mock
	List<String> mockedList;
	
	@Test
	public void WhenUsingMockAnnotation() {
		when(mockedList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockedList.size());
		assertEquals(3, mockedList.size());
	}
	
	@Test
	public void WhenUsingMockAnnotation_forGetMethodOfMock() {
		when(mockedList.get(0)).thenReturn("The element at the 0th position");
		assertEquals("The element at the 0th position", mockedList.get(0));
	}
}
