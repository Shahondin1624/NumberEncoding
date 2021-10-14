import logic.BinaryEncoding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinaryEncodingTest {
    private BinaryEncoding encoding;
    @BeforeAll
    public void init() {
        encoding = new BinaryEncoding();
    }
    @Test
    public void convert10ToBinary() {
        long testL = 10L;
        String inBinary = encoding.fromDecimal(testL, true);
        Assertions.assertEquals("1010", inBinary);
    }

    @Test
    public void convert345678ToBinary() {
        long testL = 345678L;
        String inBinary = encoding.fromDecimal(testL, true);
        Assertions.assertEquals("1010100011001001110", inBinary);
    }

    @Test
    public void convert11001ToDecimal() {
        String binary = "11001";
        long result = encoding.toDecimal(binary, true);
        Assertions.assertEquals(25L, result);
    }

    @Test
    public void convert11001ToHex() {
        String binary = "11001";
        String result = encoding.toHex(binary, true);
        Assertions.assertEquals("19", result);
    }
}
