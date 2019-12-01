import java.util.ArrayList;
import java.util.List;

public class mainClass
{
    public static void main(String args[])
    {
        Initialisierung i = new Initialisierung();
        GAC Raetsel = new GAC(i.getDomains(),i.getVariablen(),i.getConstraints());
    }


}
