package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by user on 22.03.2016.
 */
public class ImageReaderFactory {
    static ImageReader getReader(ImageTypes imageTypes) {
        if (imageTypes == null)
            throw new IllegalArgumentException("Неизвестный тип картинки");

        switch (imageTypes) {
            case BMP:
                return new BmpReader();
            case JPG:
                return new JpgReader();
            case PNG:
                return new PngReader();
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
