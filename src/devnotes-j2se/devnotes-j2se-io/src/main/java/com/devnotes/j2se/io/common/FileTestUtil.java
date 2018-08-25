package com.devnotes.j2se.io.common;

import java.io.File;

public class FileTestUtil {
    public static String getTempDir() {
        return System.getProperty("user.dir") + File.separatorChar + "temp" + File.separatorChar;
    }
}
