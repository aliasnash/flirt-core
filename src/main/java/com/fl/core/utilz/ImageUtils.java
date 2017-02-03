package com.fl.core.utilz;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class ImageUtils {
    
    public byte[] scaleImageToWidth(byte[] originalBytes, int scaledWidth, String type) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(originalBytes));
        int originalWidth = originalImage.getWidth();
        if (originalWidth <= scaledWidth) {
            return originalBytes;
        }
        int scaledHeight = (int) (originalImage.getHeight() * ((float) scaledWidth / (float) originalWidth));
        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ImageIO.write(scaledImage, type, byteStream);
        return byteStream.toByteArray();
    }
    
    public byte[] scaleImageToHeight(byte[] originalBytes, int scaledHeight, String type) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(originalBytes));
        int originalHeight = originalImage.getHeight();
        if (originalHeight <= scaledHeight) {
            return originalBytes;
        }
        int scaledWidth = (int) (originalImage.getWidth() * ((float) scaledHeight / (float) originalHeight));
        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ImageIO.write(scaledImage, type, byteStream);
        return byteStream.toByteArray();
    }
}
