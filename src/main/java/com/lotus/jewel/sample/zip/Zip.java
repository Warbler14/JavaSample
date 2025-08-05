package com.lotus.jewel.sample.zip;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void makeZip(String filePath, String zipName, List<String> fileNames) {
        File zipFile = new File(filePath, zipName);

        if (zipFile.exists()) {
            System.out.println("file exists : " + zipFile.getAbsolutePath());
            return;
        }

        byte[] buf = new byte[4096];

        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile))){
            for(String fileName : fileNames){
                File file = new File(fileName);

                try(FileInputStream in = new FileInputStream(file)){
                    ZipEntry zf = new ZipEntry(file.getName());
                    out.putNextEntry(zf);
                    int len = 0;
                    while((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }

                    out.closeEntry();
                }

                System.out.println("file : " + zipName + ", size : " + zipFile.length() + " bytes");

            }
        } catch (FileNotFoundException e) {
            System.out.println("file now found");
        } catch (IOException e) {
            System.out.println("IOException occurred");
        }
    }
}
