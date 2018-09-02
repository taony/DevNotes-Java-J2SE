package com.devnotes.j2se.io.common;

import java.io.File;

/**
 * @author Administrator
 */
public class FileTestUtil {
    public static String getTempDir() {
        return System.getProperty("user.dir") + File.separatorChar + "devnotes-j2se-io\\src\\main\\resources\\temp" + File.separatorChar;
    }
}
