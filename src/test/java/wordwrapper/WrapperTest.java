package wordwrapper;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    @Test
    public void
    should_wrap() {
        assertThat(wrap("word word", 4), is("word\nword"));
        assertThat(wrap("a dog", 5), is("a dog"));
        assertThat(wrap("a dog with a bone", 6), is("a dog\nwidth a\nbone"));
    }

    private String wrap(String s, int width) {
        return s.length() > width ? s.replaceAll(" ", "\n") : s;
    }
}
