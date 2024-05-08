package com.aegisql.multifunction;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;

import static java.nio.file.FileVisitOption.FOLLOW_LINKS;
import static java.nio.file.FileVisitResult.CONTINUE;

public class WalkFileTreeTest {

    public static final Function4<Path, Set<FileVisitOption>, Integer, FileVisitor<Path>, Path> FILE_TREE_WALKER = Function4.throwing(Files::walkFileTree);
    public static final Function3<Path, Integer, FileVisitor<Path>, Path> FOLLOW_LINKS_FILE_TREE_WALKER = FILE_TREE_WALKER.applyArg2(Set.of(FOLLOW_LINKS));
    public static final Function2<Path, FileVisitor<Path>, Path> DEEP_FOLLOW_LINKS_FILE_TREE_WALKER = FOLLOW_LINKS_FILE_TREE_WALKER.applyArg2(Integer.MAX_VALUE);
    public static final Function3<Path, Integer, FileVisitor<Path>, Path> NO_FOLLOW_LINKS_FILE_TREE_WALKER = FILE_TREE_WALKER.applyArg2(Collections::emptySet);
    public static final Function2<Path, FileVisitor<Path>, Path> SHALLOW_FILE_TREE_WALKER = NO_FOLLOW_LINKS_FILE_TREE_WALKER.applyArg2(1);
    public static final Function2<Path, FileVisitor<Path>, Path> DEEP_NO_FOLLOW_LINKS_FILE_TREE_WALKER = NO_FOLLOW_LINKS_FILE_TREE_WALKER.applyArg2(Integer.MAX_VALUE);
    public static final Function1<String, Path> PATH_OF = Function1.of(Path::of);

    public static final SupplierExt<Function1<String,Long>> NEW_COUNTING_SHALLOW_FILE_TREE_WALKER = ()->{
        var visitor = new SizeCountingFileVisitor();
        return PATH_OF
                .andThen(SHALLOW_FILE_TREE_WALKER.applyArg2(visitor))
                .andThen(_ -> visitor.getCollectedSize());
    };

    public static final SupplierExt<Function1<String,Long>> NEW_COUNTING_DEEP_FILE_TREE_WALKER = ()->{
        var visitor = new SizeCountingFileVisitor();
        return PATH_OF
                .andThen(DEEP_NO_FOLLOW_LINKS_FILE_TREE_WALKER.applyArg2(visitor))
                .andThen(_ -> visitor.getCollectedSize());
    };

    public static class SizeCountingFileVisitor extends SimpleFileVisitor<Path> {
        private final LongAdder counter = new LongAdder();
        public long getCollectedSize() {return counter.longValue();}
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            counter.add(attrs.size());
            return CONTINUE;
        }
    }


    @Test
    public void walkTreeTest() {
        var shallowWalker = NEW_COUNTING_SHALLOW_FILE_TREE_WALKER.get();
        System.out.println("Shallow Size: "+shallowWalker.apply("./src/main/java/com/aegisql/multifunction/"));
        var deepWalker = NEW_COUNTING_DEEP_FILE_TREE_WALKER.get();
        System.out.println("Deep Size: "+deepWalker.apply("./src/main/java/com/aegisql/multifunction/"));

    }

}
