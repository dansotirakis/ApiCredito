package com.zallpy.credit.fuzzy;
import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

public class Aircon {
    private FIS fis;
    private double cpf;
    private double idade;
    private double estadocivil;
    private double uf;
    private double renda;
    private double dependentes;

    public Aircon(double z,double a,double l,double p, double t, double s)throws URISyntaxException
    {
        
        cpf=z;
        idade=a;
        estadocivil=l;
        uf=p;
        renda=t;
        dependentes=s;
        
        FIS fis = FIS.load("Aircon.fcl", true);
        File dosya=new File(getClass().getResource("Aircon.fcl").toURI());
        fis=FIS.load(dosya.getPath(),true);
        fis.setVariable("cpf", cpf);
        fis.setVariable("idade", idade);
        fis.setVariable("estadocivil", estadocivil);
        fis.setVariable("uf", uf);
        fis.setVariable("renda", renda);
        fis.setVariable("dependentes", dependentes);
        fis.evaluate();
        
    }

    public FIS getModel()
    {
        return fis;
    }
    @Override
    public String toString() {
        String result=String.valueOf(Math.round(fis.getVariable("risco").getValue()));
        return result;
    }
}
