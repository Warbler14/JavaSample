package com.lotus.jewel.sample.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileSearch {

    public static Path getPath(Class<?> target) {
        return Paths.get(target.getProtectionDomain().getCodeSource().getLocation().getPath());
    }

    public List<File> getFiles(Path samplePath) {
        List<File> fileList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(samplePath)){
            stream.forEach(path -> {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.toFile());
                }
            });
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

        return fileList;
    }

    public List<String> getFilePathList(Path samplePath) {
        List<File> fileList = getFiles(samplePath);

        List<String> filePathList = new ArrayList<>();
        for(File file : fileList) {
            filePathList.add(file.getAbsolutePath());
        }
        return filePathList;
    }

    /*
    public static void filesWalk(Path samplePath) {
        List<Path> pathList = new ArrayList<>();
        try (Stream<Path> pathStream = Files.walk(samplePath)) {
            pathList = pathStream.map(Path::normalize)
                    .filter(Files::isRegularFile)
                    .toList();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

        pathList.forEach(System.out::println);
    }
    */

}
