package wordwrapper;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    @Test
    public void
    should_wrap() {
        assertThat(wrap("word word", 4), is("word\nword"));
    }

    private String wrap(String s, int width) {
        return s.replaceAll(" ", "\n");
    }
}
