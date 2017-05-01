package vg.sales.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import vg.sales.exception.MergeException;
import vg.sales.reader.CSVReader;

/**
 *
 * @author konstantinos
 */
public class VGSale implements CSVSheetValue {

    private long rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private double naSales;
    private double euSales;
    private double jpSales;
    private double otherSales;
    private double globalSales;

    public VGSale() {
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getNaSales() {
        return naSales;
    }

    public void setNaSales(double naSales) {
        this.naSales = naSales;
    }

    public double getEuSales() {
        return euSales;
    }

    public void setEuSales(double euSales) {
        this.euSales = euSales;
    }

    public double getJpSales() {
        return jpSales;
    }

    public void setJpSales(double jpSales) {
        this.jpSales = jpSales;
    }

    public double getOtherSales() {
        return otherSales;
    }

    public void setOtherSales(double otherSales) {
        this.otherSales = otherSales;
    }

    public double getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(double globalSales) {
        this.globalSales = globalSales;
    }

    @Override
    public String toString() {
        return "VGSale{" + "rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre=" + genre + ", publisher=" + publisher + ", naSales=" + naSales + ", euSales=" + euSales + ", jpSales=" + jpSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + '}';
    }

    @Override
    public String mergeValue() throws MergeException {
        StringBuilder builder = new StringBuilder();

        try {
            builder.append(rank).append(",");
            builder.append("\"").append(name).append("\"").append(",");
            builder.append("\"").append(platform).append("\"").append(",");
            builder.append(year).append(",");
            builder.append("\"").append(genre).append("\"").append(",");
            builder.append("\"").append(publisher).append("\"").append(",");
            builder.append(naSales).append(",");
            builder.append(euSales).append(",");
            builder.append(jpSales).append(",");
            builder.append(otherSales).append(",");
            builder.append(globalSales);
        } catch (Exception ex) {
            throw new MergeException("Merge to CSV exception for " + this.toString(), ex);
        }

        return builder.toString();
    }

    @Override
    public void extractValue(String[] data) {
        
        // extract sales data
        rank = Long.parseLong(data[0]);
        name = data[1];
        platform = data[2];
        
        try {
            year = Integer.parseInt(data[3]);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        genre = data[4];
        publisher = data[5];
        
        try {
            naSales = Double.parseDouble(data[6]);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

        try {
            euSales = Double.parseDouble(data[7]);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

        try {
            jpSales = Double.parseDouble(data[8]);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

        try {
            otherSales = Double.parseDouble(data[9]);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

        try {
            globalSales = Double.parseDouble(data[10]);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }

}
