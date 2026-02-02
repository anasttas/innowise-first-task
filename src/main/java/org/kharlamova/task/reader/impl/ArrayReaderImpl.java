package org.kharlamova.task.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kharlamova.task.exception.CustomArrayException;
import org.kharlamova.task.reader.ArrayReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private final static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readLines(String fileName, String dirName) throws CustomArrayException {
        List<String> lines;

        try {
            Path path = FileSystems.getDefault().getPath(dirName, fileName);
            logger.info("Reading file: {}", path);

            lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            logger.info("File read successfully. Lines count: {}", lines.size());
        } catch (IOException e) {
            logger.error("Error reading file: {}",
                    fileName,
                    e
            );

            throw new CustomArrayException("Error reading file %s" + fileName);
        }

        return lines;
    }
}
