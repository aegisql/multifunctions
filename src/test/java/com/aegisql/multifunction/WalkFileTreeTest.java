package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.Set;

import static java.nio.file.FileVisitOption.FOLLOW_LINKS;
import static java.nio.file.FileVisitResult.CONTINUE;

public class WalkFileTreeTest {

    @Test
    public void valkTreeTest() {

        Function4<Path, Set<FileVisitOption>, Integer, FileVisitor<Path>, Path> fileTreeWalker = Function4.throwing(Files::walkFileTree);

        var noLinkWalker = fileTreeWalker.applyArg2(Collections.emptySet()); // or add FileVisitOption.FOLLOW_LINKS
        var linkWalker = fileTreeWalker.applyArg2(Set.of(FOLLOW_LINKS)); // or add FileVisitOption.FOLLOW_LINKS

        var unlimitedNoLinkWalker = noLinkWalker.applyArg2(Integer.MAX_VALUE);
        var unlimitedLinkWalker = linkWalker.applyArg2(Integer.MAX_VALUE);

        var limit10NoLinkWalker = noLinkWalker.applyArg2(10);

        var printingWalker = limit10NoLinkWalker.applyArg2(new FileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("Directory: " + dir);
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("\tFile: " + file);
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to access: " + file + " due to " + exc);
                return CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (exc != null) {
                    System.err.println("Error after visiting " + dir + ": " + exc.getMessage());
                }
                return CONTINUE;
            }
        });

        Path path = printingWalker.apply(Path.of("./src/main/"));

        System.out.println("Done: "+path);

    }

}
