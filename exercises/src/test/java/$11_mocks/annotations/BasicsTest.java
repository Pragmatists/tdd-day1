package $11_mocks.annotations;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import domain.Bar;
import domain.Foo;

@RunWith(MockitoJUnitRunner.class)
public class BasicsTest {
	
	@Mock Bar bar;

	@Test
	public void simpleStub() {
		Foo foo = new Foo();
		foo.setBar(bar);
		when(bar.getName()).thenReturn("foobar");
		
		String result = foo.getBarName();
		
		assertThat(result, containsString("foo"));
	}
	
	@Test
	public void simpleVerify() {
		Foo foo = new Foo();
		foo.setBar(bar);

		foo.getBarName();
		
		verify(bar).getName();
	}
	
}
