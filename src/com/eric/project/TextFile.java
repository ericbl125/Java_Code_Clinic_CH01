package com.eric.project;

import java.io.File;
import java.io.FilenameFilter;

public class TextFile extends File {

    private File[] files;
    private static final String delimiter = ",";

   /* public TextFile() {
        String cwd = System.getProperty("user.dir");
        super(cwd);
        File dir = new File(cwd);
        FilenameFilter textFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        files = dir.listFiles(textFilter);
    }*/

    public TextFile(String pathname) {
        super(pathname);
        FilenameFilter textFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        files = this.listFiles(textFilter);
    }

    public File[] getFiles() {
        return files;
    }

    public static String getDelimiter() {
        return delimiter;
    }

    public String getAsString() {
        StringBuffer sb = new StringBuffer();
        for (File file : files) {
            sb.append(file.toString() + delimiter);
        }
        return sb.toString();
    }
}
