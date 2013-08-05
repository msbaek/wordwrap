package wordwrapper;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    private void assertWraps(String s, int width, String expected) {
        assertThat(wrap(s, width), is(expected));
    }

    @Test
    public void
    should_wrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
    }

    private String wrap(String s, int width) {
        if(s == null)
            return "";
        return s;
    }
}
