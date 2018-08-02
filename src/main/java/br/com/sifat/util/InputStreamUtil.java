package br.com.sifat.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamUtil {

    public static byte[] toByteArray(InputStream inputStream) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int reads;
        while ((reads = inputStream.read()) > 0) {
            byteArrayOutputStream.write(reads);
        }

        return byteArrayOutputStream.toByteArray();
    }
}
