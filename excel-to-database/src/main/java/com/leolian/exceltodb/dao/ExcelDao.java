package com.leolian.exceltodb.dao;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/5 20:57
 */
public class ExcelDao {

    public XSSFSheet getXSSFSheet(String sourceFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourceFile);
        XSSFWorkbook rWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet xssfSheet = rWorkbook.getSheetAt(0);
        return xssfSheet;
    }

}
