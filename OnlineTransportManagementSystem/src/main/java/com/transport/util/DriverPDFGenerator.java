package com.transport.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.transport.model.Driver;

import com.itextpdf.text.BaseColor; 
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DriverPDFGenerator {

    public static void generateDriverListPDF(List<Driver> driverList, OutputStream out) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Paragraph title = new Paragraph("Driver Details", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        // Current Date & Time
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Paragraph date = new Paragraph("Generated on: " + dateTime);
        date.setAlignment(Element.ALIGN_RIGHT);
        date.setSpacingAfter(10);
        document.add(date);
        
        document.add(new Paragraph(" ")); // Empty line

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);

        // Add table headers
        Stream.of("ID", "Name", "License No", "Contact", "NIC")
              .forEach(header -> {
                  PdfPCell cell = new PdfPCell(new Phrase(header));
                  cell.setBorderColor(BaseColor.LIGHT_GRAY);
                  table.addCell(cell);
              });

        // Add driver data
        for (Driver d : driverList) {
            table.addCell(String.valueOf(d.getDriverId()));
            table.addCell(d.getName());
            table.addCell(d.getLicenseNumber());
            table.addCell(d.getContact());
            table.addCell(d.getNic());
        }

        document.add(table);
        document.close();
    }
}