import logic.DecimalEncoding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DecimalEncodingTest {
    private DecimalEncoding encoding;

    @BeforeAll
    public void init() {
        encoding = new DecimalEncoding();
    }

    @Test
    public void convert10() {
        long testL = 10L;
        String inDecimal = encoding.fromDecimal(testL, true);
        Assertions.assertEquals("10", inDecimal);
    }

    @Test
    public void convert345678InBinary() {
        long testL = 345678L;
        String inBinary = encoding.toBinary(testL, true);
        Assertions.assertEquals("1010100011001001110", inBinary);
    }

    @Test
    public void convert345678InHex() {
        long testL = 345678L;
        String inHex = encoding.toHex(testL, true);
        Assertions.assertEquals("5464E", inHex);
    }
}

