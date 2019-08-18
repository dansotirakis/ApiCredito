package com.zallpy.credit.fuzzy;
import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Airconditioniing {

    public static void main(String[] args) throws URISyntaxException {
        Scanner in =new Scanner(System.in);
        System.out.println("cpf (0-10):");
        double z =in.nextDouble();
        System.out.println("idade (0-10):");
        double a =in.nextDouble();
        System.out.println("estadocivil (0-10):");
        double l =in.nextDouble();
        System.out.println("uf (0-10):");
        double p =in.nextDouble();
        System.out.println("renda (0-10):");
        double t =in.nextDouble();
        System.out.println("dependentes (0-10):");
        double s =in.nextDouble();
        
        
                Aircon aircon=new Aircon(z,a,l,p,t,s);
                JFuzzyChart.get().chart(aircon.getModel());
                System.out.println(aircon);

    }
    
}
