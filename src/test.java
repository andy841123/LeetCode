import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) throws IOException{
        try (Stream<Path> paths = Files.walk(Paths.get("src/Medium/"))) {
			paths
			.filter(Files::isRegularFile)
			.forEach(System.out::println);
		} 
    }
}
