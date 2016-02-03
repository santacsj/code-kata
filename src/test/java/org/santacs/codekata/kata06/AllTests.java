package org.santacs.codekata.kata06;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ WordTest.class, AnagramsTest.class, AnagramsPrinterTest.class,
        AnagramsSystemTest.class })
public class AllTests {

}
