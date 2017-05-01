package vg.sales.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import vg.sales.model.CSVFactory;
import vg.sales.model.CSVSheet;
import vg.sales.model.CSVSheetValue;

/**
 *
 * @author konstantinos
 */
public class CSVReader {

//    @Autowired
//    private VGSaleService service;
    public <T extends CSVSheetValue> CSVSheet read(String file, boolean isFirstLineHeaders, Class<? extends CSVSheetValue> cls) throws IOException {
        
        CSVFactory factory = new CSVFactory();
        CSVSheet<T> sheet = new CSVSheet<>(isFirstLineHeaders);
        String line;
        String cvsSplitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] data;
        boolean columnsFlag = false;
        boolean headersFlag = false;
        int numberOfColumns = 0;

        while ((line = br.readLine()) != null) {

            // use comma as separator
            data = line.split(cvsSplitBy);
            T value = factory.create(cls);

            // init number of columns
            if (!columnsFlag) {
                numberOfColumns = data.length;
                columnsFlag = true;
            }

            if (sheet.isIsFirstLineHeaders() && !headersFlag) {
                // add headers to sheet here
                Arrays.asList(data).forEach(header -> sheet.addHeader(header));

                headersFlag = true;
                continue;
            }

            // data length validation
            if (data.length != numberOfColumns) {
                continue;
            }

            value.extractValue(data);
            
            sheet.addValue(value);
            System.out.println(value);
        }

        return sheet;
    }

//    public void readAndSaveToDB(String file, boolean isFirstLineHeaders, int size) throws IOException {
//
//        List<VGSale> buffer = new ArrayList<>(size);
//
//        String line;
//        String cvsSplitBy = ";";
//
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        VGSale sale;
//        String[] data;
//        boolean flag = false;
//        int numberOfColumns = 0;
//        
//        while ((line = br.readLine()) != null) {
//
//            if (isFirstLineHeaders) {
//                isFirstLineHeaders = false;
//                continue;
//            }
//
//            // use comma as separator
//            data = line.split(cvsSplitBy);
//            sale = new VGSale();
//            
//            // init number of columns
//            if (!flag) {
//                numberOfColumns = data.length;
//                flag = true;
//            }
//            
//            // data length validation
//            if (data.length != numberOfColumns) {
//                continue;
//            }
//
//            // clear buffer
//            if (buffer.size() == size) {
//                // store data to db
//                try {
//                    service.addVGsales(buffer);
//                } catch (DataAccessException ex) {
//                    Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//                }
//                // init buffer
//                buffer = new ArrayList<>(size);
//            }
//
//            // extract sales data
//            sale.setRank(Long.parseLong(data[0]));
//            sale.setName(data[1]);
//            sale.setPlatform(data[2]);
//
//            try {
//                sale.setYear(Integer.parseInt(data[3]));
//            } catch (NumberFormatException ex) {
//                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//            }
//
//            sale.setGenre(data[4]);
//            sale.setPublisher(data[5]);
//
//            try {
//                sale.setNaSales(Double.parseDouble(data[6]));
//            } catch (NumberFormatException ex) {
//                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//            }
//
//            try {
//                sale.setEuSales(Double.parseDouble(data[7]));
//            } catch (NumberFormatException ex) {
//                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//            }
//
//            try {
//                sale.setJpSales(Double.parseDouble(data[8]));
//            } catch (NumberFormatException ex) {
//                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//            }
//
//            try {
//                sale.setOtherSales(Double.parseDouble(data[9]));
//            } catch (NumberFormatException ex) {
//                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//            }
//
//            try {
//                sale.setGlobalSales(Double.parseDouble(data[10]));
//            } catch (NumberFormatException ex) {
//                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//            }
//
//            System.out.println(sale);
//
//            buffer.add(sale);
//        }
//
//        // store rest data to db
//        try {
//            if (service == null) {
//                System.out.println("null");
//            }
//            service.addVGsales(buffer);
//        } catch (DataAccessException ex) {
//            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
//        }
//    }
}
