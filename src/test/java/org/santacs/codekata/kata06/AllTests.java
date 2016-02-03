package org.santacs.codekata.kata06;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ WordTest.class, AnagramCollectorTest.class, AnagramPrinterTest.class,
        FileWordStreamTest.class, AnagramSystemTest.class })

public class AllTests {

}
