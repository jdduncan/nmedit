/*
 * Created on Aug 29, 2006
 */
package net.nmedit.nmlibs.jnmprotocol2.test;

import junit.framework.JUnit4TestAdapter;

import net.nmedit.nmlibs.jnmprotocol.test.utils.QueueBufferTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    ProtocolTester.class,
    QueueBufferTest.class
})
public class AllTests
{
    /**
     * For jUnit Backwards compatibility
     */
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(AllTests.class);    
    }
}
