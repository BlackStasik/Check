import java.io.*;
import java.sql.Time;
import java.util.Date;

public class Check {

    File file = new File("Check");
    Date date = new Date();

    String good = "";
    double price = 0;
    int num = 0;
    double sum = 0;
    double ppp = 0;

    public Check(){
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter prWr = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));

            try {
                prWr.println("\t\t\t\t" + "Чек" );
                prWr.println("\t" + date.toString() );
                prWr.println("\n");
                prWr.println("\t" + "Товар" + "\t" + "Кіл." +"\t" + "Ціна" );

            } finally {
                prWr.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void write(String good, Double price,int num) {
        this.good = good;
        this.price = price;
        this.num = num;
        System.out.println(good);
        this.sum += price;

        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter prWr = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));

            try {
                prWr.println("\t" + good + "\t" + num + "\t" + price);
            } finally {
                prWr.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCheck(Double ppp) {
        this.ppp = ppp;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter prWr = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));

            try {
                prWr.println("\n");
                prWr.println("\tСума чеку: " + "\t" + sum);
                prWr.println("\tСума оплати: " + "\t" + ppp);
                prWr.println("\tРешта:" + "\t" + (ppp-sum));
                prWr.println("\tБонуси:" + "\t" + (sum * 0.01));
            } finally {
                prWr.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
