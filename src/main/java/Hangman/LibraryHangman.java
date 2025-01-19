package Hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class LibraryHangman {
    public static void main(String[] args) throws IOException {
        // throws is exception = :
        String line = Files.readString(Path.of("C:\\Stefan\\Itvitae\\Codework\\library\\Projecten\\Hangman\\Library"));
        //System.out.println(line);
        line = line.replaceAll("\"","");
        List<String> words = List.of(line.split(","));
        Random random = new Random();
        for(int i = 0;i < 10;i++)
            System.out.println(words.get(random.nextInt(words.size())));
        // words.size is alle woorden binnen de file
    }
}
