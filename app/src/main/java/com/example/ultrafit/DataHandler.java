package com.example.ultrafit;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class DataHandler {

    public static void saveData(Context context, Object obj) throws IOException {
        FileOutputStream outputStream = context.openFileOutput("userData.txt", Context.MODE_PRIVATE);
        byte[] data = toByteArray(obj);
        outputStream.write(data);
        outputStream.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Object loadData(Context applicationContext) throws IOException, ClassNotFoundException {
        File file = new File("userData.txt");
        byte[] fileContent = Files.readAllBytes(file.toPath());

        return toObject(fileContent);

    }
    public static byte[] toByteArray(Object obj) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return bytes;
    }

    public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
        return obj;
    }

}
