package airconditioniing;
import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Airconditioniing {

    public static void main(String[] args) throws URISyntaxException {
        Scanner in =new Scanner(System.in);
        System.out.println("cpf (0-1):");
        double z =in.nextDouble();
        System.out.println("idade (0-1):");
        double a =in.nextDouble();
        System.out.println("estadocivil (0-1):");
        double ll =in.nextDouble();
        System.out.println("uf (0-1):");
        double p =in.nextDouble();
        System.out.println("renda (0-1):");
        double y =in.nextDouble();
        
        
                Aircon aircon=new Aircon(z,a,ll,p,y);
                JFuzzyChart.get().chart(aircon.getModel());
                System.out.println(aircon);

    }
    
}
