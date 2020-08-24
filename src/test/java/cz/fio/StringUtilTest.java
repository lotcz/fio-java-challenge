package cz.fio;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testTrimToNull() {
        Assert.assertEquals("test", StringUtil.trimToNull(" test    "));
        Assert.assertEquals("trimmed", StringUtil.trimToNull("    trimmed"));
        Assert.assertNull(StringUtil.trimToNull("   "));
        Assert.assertNull(StringUtil.trimToNull(""));
    }

}
