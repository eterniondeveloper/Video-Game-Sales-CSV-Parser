package vg.sales;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vg.sales.model.VGSale;
import vg.sales.reader.CSVReader;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        String csvFile = "C:\\Users\\konstantinos\\Desktop\\vgsales.csv";
        List<VGSale> vgSaleList = new CSVReader().read(csvFile, true);
        vgSaleList.forEach(System.out::println);
    }

}
