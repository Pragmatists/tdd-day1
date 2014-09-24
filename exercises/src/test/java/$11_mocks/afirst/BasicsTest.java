package $11_mocks.afirst;

import domain.Bar;
import domain.Foo;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BasicsTest {

    @Ignore
    @Test
    public void foo_prefixes_data_with_foo_word() throws Exception {
        Foo foo = new Foo();
        Bar bar = new Bar();
        foo.setBar(bar);

        String result = foo.getData();

        assertThat(result).startsWith("foo");
    }

    @Ignore
    @Test
    public void foo_logs_data_calls_with_bar() throws Exception {
        Foo foo = new Foo();
        Bar bar = new Bar();
        foo.setBar(bar);

        String result = foo.getData();

        //sprawdz że bar.log() zostało wykonane;
    }

}
