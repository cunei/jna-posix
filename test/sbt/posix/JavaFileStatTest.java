/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sbt.posix;

import junit.framework.TestCase;

import sbt.posix.util.Platform;

/**
 *
 * @author nicksieger
 */
public class JavaFileStatTest extends TestCase {
    public void testSetup() {
        JavaFileStat fs = new JavaFileStat(null, null);
        if (Platform.IS_WINDOWS) {
            fs.setup("c:/");
        } else {
            fs.setup("/");
        }
        assertFalse(fs.isSymlink());
    }
}
