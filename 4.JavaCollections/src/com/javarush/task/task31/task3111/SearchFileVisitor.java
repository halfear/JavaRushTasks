package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (minSize > 0) {
            byte[] content = Files.readAllBytes(file); // размер файла: content.length
            if (content.length < minSize) return FileVisitResult.CONTINUE;
        }

        if (maxSize > 0) {
            byte[] content = Files.readAllBytes(file); // размер файла: content.length
            if (content.length > maxSize) return FileVisitResult.CONTINUE;
        }

        if (partOfName != null) {
            String filename = file.getFileName().toString();
            if (!filename.contains(partOfName)) return FileVisitResult.CONTINUE;
        }

        if (partOfContent !=  null) {
            boolean contains = false;
            List<String> contentsStrings = Files.readAllLines(file);
            for (String string : contentsStrings) {
                if (string.contains(partOfContent)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) return FileVisitResult.CONTINUE;
        }

        foundFiles.add(file);
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
