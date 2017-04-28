package access;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

/**
 * Created by Vladyslav Dovhopol on 4/27/17.
 * Test Greeting Controller.
 */
@RunWith(SpringRunner.class)
public class AccessControllerTest {

    @Test
    public void assertThatNullIsNull() {
        assertThat(null, is(nullValue()));
    }
}
