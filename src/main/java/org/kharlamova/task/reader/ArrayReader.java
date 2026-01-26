package org.kharlamova.task.reader;

import org.kharlamova.task.exception.CustomArrayException;

import java.util.List;

public interface ArrayReader {
    List<String> readLines(String fileName, String dirName) throws CustomArrayException;
}
