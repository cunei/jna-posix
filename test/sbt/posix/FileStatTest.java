
package sbt.posix;

import java.io.File;
import sbt.posix.util.Platform;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileStatTest {

    public FileStatTest() {
    }

    private static POSIX posix;
    @BeforeClass
    public static void setUpClass() throws Exception {
        posix = POSIXFactory.getPOSIX(new DummyPOSIXHandler(), true);
    }


    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test public void filestat() throws Throwable {
        File f = File.createTempFile("stat", null);
        FileStat st = posix.stat(f.getAbsolutePath());
        f.delete();
        assertNotNull("posix.stat failed", st);
    }

    @Test public void structStatSize() throws Throwable {
        if (Platform.IS_SOLARIS && Platform.IS_32_BIT) {
            assertEquals("struct size is wrong", 144, new SolarisHeapFileStat().getStructSize());
        }
    }
}