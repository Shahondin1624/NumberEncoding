import logic.HexEncoding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HexEncodingTest {
    private HexEncoding encoding;
    @BeforeAll
    public void init() {
        encoding = new HexEncoding();
    }

    @Test
    public void convert10() {
        long testL = 10L;
        String inHex = encoding.fromDecimal(testL, true);
        Assertions.assertEquals("A", inHex);
    }

    @Test
    public void convert345678() {
        long testL = 345678L;
        String inHex = encoding.fromDecimal(testL, true);
        Assertions.assertEquals("5464E", inHex);
    }

    @Test
    public void convert19FToBinary() {
        String hex = "19F";
        String binary = encoding.toBinary(hex, true);
        Assertions.assertEquals("110011111", binary);
    }

    @Test
    public void convert19FToDecimal() {
        String hex = "19F";
        long decimal = encoding.toDecimal(hex, true);
        Assertions.assertEquals(415, decimal);
    }
}
