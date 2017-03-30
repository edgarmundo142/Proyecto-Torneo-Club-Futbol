package com.ipn.mx.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.Part;

/**
 *
 * @author rafal
 */
public class FileUpload extends Thread {
    private final Part file;
    private final String path = "/usuarios/";
    private final byte[] buffer = new byte[1024];
    private String name;
    private OutputStream out;
    private InputStream in;
    
    public FileUpload(Part file, String name) {
        this.file = file;
        this.name = name;
    }
    
    public static FileUpload createUploadFile(Part file, String name) {
        return new FileUpload(file, name);
    }
    
    private static String getFileExtension(Part part) {
        String temp;
        for (String s : part.getHeader("content-disposition").split(";")) {
            if (s.trim().startsWith("filename")) {
                temp = s.substring(s.indexOf('=') + 1).trim().replace("\"", "");
                return temp.substring(temp.lastIndexOf('.'),temp.length());
            }
        }
        return null;
    } 
    
    @Override
        public void run() {
            try {
                this.in = this.file.getInputStream();
                this.out = new java.io.FileOutputStream(new File(
                        new File("").getAbsolutePath()
                        + this.path + File.separator + this.name
                        + getFileExtension(this.file)
                ));
                int read;
                while((read = this.in.read(this.buffer)) != -1){
                    this.out.write(this.buffer,0,read);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
}
