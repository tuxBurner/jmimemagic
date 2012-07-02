package net.sf.jmimemagic;

import java.io.File;

import junit.framework.TestCase;

public class MovieFileTest extends TestCase {

    public static void main(String args[]) {
        junit.textui.TestRunner.run(MagicTest.class);
    }
    
    public void testMp4Android() {
        System.out.print("\ntesting Fkk Movie ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/test_android_galaxys2.mp4"), true, false);
            if (match != null) {
                assertEquals("video/mp4", match.getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testMp4Android()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testMp4Android(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testMp4Android(). message: " + e.getMessage());
        }
    }
    
    public void testMicMovie() {
        System.out.print("\ntesting Jo Movie ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/MicromataTest.mov"), true, false);
            if (match != null) {
                assertEquals("video/mp4", match.getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testMicMovie()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testMicMovie(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testMicMovie(). message: " + e.getMessage());
        }
    }
    
    public void testAviMovie() {
        System.out.print("\ntesting Test Avi ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/test.avi"), true, false);
            if (match != null) {
                assertEquals("video/avi", match.getSubMatches().get(0).getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testAviMovie()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testAviMovie(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testAviMovie(). message: " + e.getMessage());
        }
    }
    
    public void testXvidAviMovie() {
        System.out.print("\ntesting Test Xvid Avi ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/xvid.avi"), true, false);
            if (match != null) {
                assertEquals("video/avi", match.getSubMatches().get(0).getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testXvidAviMovie()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testXvidAviMovie(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testXvidAviMovie(). message: " + e.getMessage());
        }
    }
    
    public void testDivxAviMovie() {
        System.out.print("\ntesting Test Divx Avi ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/divx.avi"), true, false);
            if (match != null) {
                assertEquals("video/avi", match.getSubMatches().get(0).getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testDivxAviMovie()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testDivxAviMovie(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testDivxAviMovie(). message: " + e.getMessage());
        }
    }
    
    public void testMpgMovie() {
        System.out.print("\ntesting Test Mpg ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/test.mpg"), true, false);
            if (match != null) {
                assertEquals("video/mpeg", match.getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testMpgMovie()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testMpgMovie(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testMpgMovie(). message: " + e.getMessage());
        }
    }
    
    public void testProresMovie() {
        System.out.print("\ntesting Test Prores ...");
        try {
            MagicMatch match = Magic.getMagicMatch(new File("test_docs/pores.mov"), true, false);
            if (match != null) {
                assertEquals("video/mp4", match.getMimeType());
            } else {
                System.out.print("failed");
                fail("no match in testProresMovie()");
            }
            System.out.print("ok");
        } catch (Exception e) {
            e.printStackTrace();
            fail("exception in testProresMovie(). message: " + e);
        } catch (Error e) {
            e.printStackTrace();
            fail("error in testProresMovie(). message: " + e.getMessage());
        }
    }

    
}
