import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: fc <nome da classe> <dir> [-p]");
            return;
        }

        String className = args[0];
        String dirPath = args[1];
        boolean useParallelStream = args.length > 2 && args[2].equals("-p");

        try {
            long startTime = System.currentTimeMillis();
            String  tewsw = "batata";
            List<Path> classFiles = findClassFiles(Paths.get(dirPath), useParallelStream);
            List<String> foundLocations = findClassInFiles(className, classFiles);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            if (foundLocations.isEmpty()) {
                System.out.println("A classe '" + className + "' não foi encontrada.");
            } else {
                System.out.println("A classe '" + className + "' foi encontrada nos seguintes locais:");
                for (String location : foundLocations) {
                    System.out.println(location);
                }
            }

            System.out.println("Tempo gasto para realizar a busca: " + elapsedTime + " ms");
            System.out.println("Número de arquivos .class consultados: " + classFiles.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Path> findClassFiles(Path directory, boolean useParallelStream) throws IOException {
        List<Path> classFiles = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            stream.forEach(path -> {
                if (Files.isDirectory(path)) {
                    try {
                        List<Path> subDirClassFiles = findClassFiles(path, useParallelStream);
                        if (useParallelStream) {
                            classFiles.addAll(subDirClassFiles.parallelStream().toList());
                        } else {
                            classFiles.addAll(subDirClassFiles);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (path.toString().endsWith(".class")) {
                    classFiles.add(path);
                }
            });
        }

        return classFiles;
    }

    private static List<String> findClassInFiles(String className, List<Path> classFiles) throws IOException {
        List<String> foundLocations = new ArrayList<>();

        for (Path classFile : classFiles) {
            byte[] content = Files.readAllBytes(classFile);
            String fileContent = new String(content);
            System.out.println(fileContent);

            if (fileContent.contains("class " + className)) {
                foundLocations.add(classFile.toString());
            }
        }

        return foundLocations;
    }
}