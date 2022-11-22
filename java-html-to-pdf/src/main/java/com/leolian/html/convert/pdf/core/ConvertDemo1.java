package com.leolian.html.convert.pdf.core;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

public class ConvertDemo1 {

    public static void main(String[] args) {
//        String inputFile = "E:\\Java\\Project\\WeReadScan\\example\\Python量化交易.html";
//        String outputFile = "E:\\Java\\Project\\WeReadScan\\example\\Python量化交易.pdf";
//
//        generatePDF(inputFile, outputFile);
//
//        System.out.println("Done!");

        BigDecimal val = new BigDecimal("2.33");
        System.out.println(val);
    }

    public static void generatePDF(String inputHtmlPath, String outputPdfPath) {
        try {
            String url = new File(inputHtmlPath).toURI().toURL().toString();
            System.out.println("URL: " + url);

            OutputStream out = new FileOutputStream(outputPdfPath);

            //Flying Saucer part
            ITextRenderer renderer = new ITextRenderer();

            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(out);

            out.close();
        } catch (DocumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
