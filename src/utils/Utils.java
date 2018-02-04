package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Utils {
    public static BufferedImage loadImage(String url) {
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T parseJsonToObject(String path, Class<T> cls) {
        try {
            FileReader fileReader = new FileReader(path);
            Gson gson = new Gson();
//            Type type = new TypeToken<T>(){}.getType();
            return gson.fromJson(fileReader, cls);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> parseJsonToList(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            Gson gson = new Gson();
            Type type = new TypeToken<List<T>>() {
            }.getType();
            return gson.fromJson(fileReader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
