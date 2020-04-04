package com.bj.invoiceLoader.services;


import com.bj.invoiceLoader.entity.Bj;
import com.bj.invoiceLoader.entity.Tmobile;
import com.bj.invoiceLoader.exception.FileStorageException;
import com.bj.invoiceLoader.poi.ExcelPOIHelper;
import com.bj.invoiceLoader.repositories.BjRepository;
import com.bj.invoiceLoader.repositories.FileRepository;
import com.bj.invoiceLoader.repositories.TmobileRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private TmobileRepository tmobileRepository;

    @Autowired
    private ExcelPOIHelper excelPOIHelper;

    @Autowired
    private BjRepository bjRepository;

    public void parseFile(File fileToRead, String date, String dataType) throws IOException {

        if (dataType.equals("tmobile")) {
            Map<Integer, List<String>> data = excelPOIHelper.readExcel(fileToRead);
            //Remove header of table
            data.remove(0);

            //remove last line, formula.
            data.remove(data.size());

            //store data to DB
            for (List<String> temp : data.values()) {
                Tmobile tmobileObject = new Tmobile();
                tmobileObject.setPhoneNumber(temp.get(0));
                tmobileObject.setTariff(temp.get(1));
                tmobileObject.setInvoiceGroup(temp.get(2));
                tmobileObject.setIco(temp.get(3));
                tmobileObject.setCustomerCompanyName(temp.get(4));
                tmobileObject.setRecipientCompanyName(temp.get(5));
                tmobileObject.setNumberOfItems(Double.valueOf(temp.get(6)));
                tmobileObject.setPriceBeforeSale(Double.valueOf(temp.get(7)));
                tmobileObject.setSale(Double.valueOf(temp.get(8)));
                tmobileObject.setFinalPrice(Double.valueOf(temp.get(9)));
                tmobileObject.setExcelId(date);
                try {
                    tmobileRepository.save(tmobileObject);
                } catch (JDBCException ex) {
                    throw new FileStorageException("Could not store data " + ex);
                }
            }
        }
        if (dataType.equals("bj")) {
            Map<Integer, List<String>> data = excelPOIHelper.readExcel(fileToRead);
            //Remove header of table
            data.remove(0);

            //store data to DB
            for (List<String> temp : data.values()) {
                Bj bj = new Bj();
                //TODO find out how to solve empty fields in excel
                bj.setExcelId(date);
                bj.setIco(String.valueOf(validateInput(temp.get(0))));
                bj.setDic(String.valueOf(validateInput(temp.get(1))));

                bj.setCompany(String.valueOf(temp.get(2)));
                bj.setName(String.valueOf(temp.get(3)));
                bj.setForename(String.valueOf(temp.get(4)));
                bj.setStreet(String.valueOf(temp.get(5)));
                bj.setPsc(String.valueOf(temp.get(6)));
                bj.setCity(String.valueOf(temp.get(7)));
                bj.setEmail(String.valueOf(temp.get(8)));
                bj.setEmail_copy(String.valueOf(temp.get(9)));
                bj.setGroup_flag(ConvertIntToNumeric(temp.get(10)));
                bj.setT1(String.valueOf(temp.get(11)));
                bj.setTar1(String.valueOf(temp.get(12)));
                bj.setM1(ConvertIntToNumeric(temp.get(13)));
                bj.setT2(String.valueOf(temp.get(14)));
                bj.setTar2(String.valueOf(temp.get(15)));
                bj.setM2(ConvertIntToNumeric(temp.get(16)));
                bj.setT3(String.valueOf(temp.get(17)));
                bj.setTar3(String.valueOf(temp.get(18)));
                bj.setM3(ConvertIntToNumeric(temp.get(19)));
                bj.setT4(String.valueOf(temp.get(20)));
                bj.setTar4(String.valueOf(temp.get(21)));
                bj.setM4(ConvertIntToNumeric(temp.get(22)));
                //TODO map rest
                try {
                    bjRepository.save(bj);
                } catch (JDBCException ex) {
                    throw new FileStorageException("Could not store data " + ex);
                }
            }
        }
    }

    private int ConvertIntToNumeric(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception ex) {
            return 0;
        }
    }

    private String validateInput(String temp) {
        if (temp != null) {
            return temp;
        } else {
            return " ";
        }
    }

    public void storeFile(String fileName, String fileType, byte[] bytes) {

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            com.bj.invoiceLoader.entity.File dbFile = new com.bj.invoiceLoader.entity.File(fileName, fileType, bytes);
            fileRepository.save(dbFile);
        } catch (Exception ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}
