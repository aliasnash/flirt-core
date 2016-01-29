package com.fl.core.utilz;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileUtilz {
    
    public File createDirectory(String filePath) {
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
}
