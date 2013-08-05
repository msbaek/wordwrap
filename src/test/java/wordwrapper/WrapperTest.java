package wordwrapper;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    @Test
    public void
    should_wrap() {
        assertThat(wrap(null, 1), is(""));
        assertThat(wrap("", 1), is(""));
        assertThat(wrap("x", 1), is("x"));
    }

    private String wrap(String s, int width) {
        if(s == null)
            return "";
        return s;
    }
}
