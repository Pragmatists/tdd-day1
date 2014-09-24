package $11_mocks.answers;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import domain.Bar;
import domain.Foo;


@RunWith(MockitoJUnitRunner.class)
public class SmartNullsTest {
	
	@Mock(answer = Answers.RETURNS_SMART_NULLS) Foo mockFoo;

    @Ignore
	@Test
	public void nullTest_shouldFail() {
		Bar b = new Foo().getBar();
		
		String result = b.getName(); //throws null pointer
	}

    @Ignore
	@Test
	public void smartNullTest_shouldFail() {
		Bar b = mockFoo.getBar();
		
		String result = b.getName(); //throws "smart" null pointer
	}

}
