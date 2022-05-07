package test_data;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {
    //generic type, input T type, return T type
    //param: input String filePath, and dataType
    public static <T> T buildDataObject(String filePath, Class<T> dataType) {
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
        T returnedData = null;
        Exception e = null;
        //read file

        try(Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));)
        {
            Gson gson = new Gson();
            returnedData = gson.fromJson(reader, dataType);
        }
        catch (NoSuchFileException noSuchFiledException)
        {
            throw new RuntimeException("[ERR] Cant locate the file: " + absoluteFilePath);
        }
        catch(Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        }

        return returnedData;
    }
}
