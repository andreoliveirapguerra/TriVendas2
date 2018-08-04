package br.ufrpe.trivendas.beans;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.*;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class PersistenceLayer implements Serializable{
    Path path = FileSystems.getDefault().getPath("C:\\Users\\andre\\IdeaProjects\\IP2\\TriCoisas\\TriVendas\\r4");
    Charset s = Charset.forName("US-ASCII");

    {
        try {
                InputStream in = Files.newInputStream(path);
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(in));
                String line = "DATABASE IM LIVING IN A DATABASE WOOOOOWOOOOO";

                byte data[] = line.getBytes();

                reader1 = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                try(OutputStream out = new BufferedOutputStream(
                        Files.newOutputStream(path, CREATE, APPEND))){
                    out.write(data, 0, data.length);
                } catch (IOException x){
                    err.println(x);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
