package com.lotus.jewel.sample.zip;


import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class ZipTestMain {
    public static void main(String[] args) {

        final String resourceDirectory = "texts"; // files

        Path path = FileSearch.getPath(ZipTestMain.class);
        path = path.resolve(resourceDirectory);

        FileSearch search = new FileSearch();
        List<String> fileList = search.getFilePathList(path);

        fileList.forEach(System.out::println);

        String fileStorePath = path.toFile().getAbsolutePath();
        System.out.println("work dir : " + fileStorePath);

        new Zip().makeZip(fileStorePath, "file.zip", fileList);

    }

}

