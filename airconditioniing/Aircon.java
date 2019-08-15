package airconditioniing;
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

     public Aircon(double z,double a,double ll,double p, double y)throws URISyntaxException
    {
        
        cpf=z;
        idade=a;
        estadocivil=ll;
        uf=p;
        renda=y;

        File dosya=new File(getClass().getResource("Aircon.fcl").toURI());
        fis=FIS.load(dosya.getPath(),true);
        fis.setVariable("cpf",cpf );
        fis.setVariable("idade", idade);
        fis.setVariable("estadocivil", estadocivil);
        fis.setVariable("uf", uf);
        fis.setVariable("renda", renda);
        fis.evaluate();//hesaplama
        
    }

    public FIS getModel()
    {
        return fis;
    }
    @Override
    public String toString() {
        String cikti="Isitma veya sogutma orani (%):"+Math.round(fis.getVariable("risco").getValue());
        return cikti;
    }
     
}
