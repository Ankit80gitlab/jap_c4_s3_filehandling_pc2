package com.jap.salesanalyzer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class SalesAnalysisTest
{
    SalesAnalysis salesAnalysis;
    SalesRecord salesRecord;
    SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
    String fileName = "src/main/resources/purchase_details.csv";
    String parseFileName = "src/main/resources/parsePurchase.csv";
    String numberFormatFileName = "src/main/resources/numberFormatPurchase.csv";
    String objectFileName = "src/main/resources/objectPurchase.csv";
    @BeforeEach
    void setUp() throws ParseException { salesAnalysis = new SalesAnalysis();
    salesRecord = new SalesRecord(formatter.parse("20/11/18"),37077,505,"credit", 49.53,12.0,8);}
    @AfterEach
    void tearDown(){salesAnalysis = null;salesRecord=null;}

    @Test
    public void givenSalesDetailsFileCountTheNumberOfRecords()
    {
        assertEquals(24999,salesAnalysis.countOfSalesRecords(fileName),"The file is empty");
    }
    @Test
    public void givenWrongDateThrowParseException(){
        assertThrows(ParseException.class,()->salesAnalysis.readRecords(parseFileName,3),"wrong date format");
    }
    @Test
    public void givenWrongDataFormatThrowsNumberFormatException()
    {
        assertThrows(NumberFormatException.class,()->salesAnalysis.readRecords(numberFormatFileName,3),"wrong data in record");
    }
    @Test
    public void givenSaleDetailsFileReturnTheRecordsAsObjectsOfSalesRecord() throws ParseException {
        SalesRecord expected = new SalesRecord(formatter.parse("20/11/18"),37077,505,"credit",49.53,12,8);
        SalesRecord [] output = salesAnalysis.readRecords(objectFileName,2);
        assertEquals(expected.toString(),output[0].toString(),"Sales record objects not returned correctly");

    }

}
