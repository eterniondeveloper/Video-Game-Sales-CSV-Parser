package vg.sales.model;

/**
 *
 * @author konstantinos
 */
public class VGSale {
    
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
    
}
