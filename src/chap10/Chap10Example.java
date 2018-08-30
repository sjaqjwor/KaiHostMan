package chap10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap10Example {
    public static void main(String []args) throws Exception{
//        Runnable hellos =()->{
//            for(int i=1;i<=1000;i++){
//                System.out.println("hello"+i);
//            }
//        };
//        Runnable goodbyes = ()->{
//            for(int i=1;i<=1000;i++){
//                System.out.println("goodbye"+i);
//            }
//        };
//        Executor executor = Executors.newCachedThreadPool();
//        executor.execute(hellos);
//        executor.execute(goodbyes);
        String word = "String";
        Set<Path> paths = descendants(Paths.get("."));
        List<Callable<Long>> tasks = new ArrayList<>();
        for (Path p : paths) tasks.add(
                () -> { return occurrences(word, p); });
        int processors = Runtime.getRuntime().availableProcessors();
        System.err.println(processors);
        ExecutorService executor = Executors.newFixedThreadPool(processors);
        List<Future<Long>> results = executor.invokeAll(tasks);
        long total = 0;
        for (Future<Long> result : results) total += result.get();
        System.out.println("Occurrences of String: " + total);
    }
    public static Set<Path> descendants(Path p) throws IOException {
        try (Stream<Path> entries = Files.walk(p)) {
            return entries.collect(Collectors.toSet());
        }
    }
    public static long occurrences(String word, Path path) {
        try {
            String contents = new String(Files.readAllBytes(path),
                    StandardCharsets.UTF_8);
            return Pattern.compile("\\PL+")
                    .splitAsStream(contents)
                    .filter(Predicate.isEqual(word))
                    .count();
        } catch (IOException ex) {
            return 0;
        }
    }
}
