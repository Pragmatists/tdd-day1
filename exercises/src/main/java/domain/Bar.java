package domain;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bar {

    private String name;

    public String getName() {
        return name;
    }

    public void wuzzle(Bar bar) {
        //do something fantastic
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() throws IOException {
        Path path = FileSystems.getDefault().getPath("logs", "access.log");

        return new String(Files.readAllBytes(path));
    }

    public void log() {
        //logging something
    }
}
