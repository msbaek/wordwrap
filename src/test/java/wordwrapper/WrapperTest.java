package wordwrapper;

import org.junit.Test;

public class WrapperTest {
    @Test public void
    should_wrap() {
        assertThat(wrap("word word", 4), is("word\nword"));
    }
}
