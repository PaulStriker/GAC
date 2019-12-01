import java.util.List;

public class constraint
{
    List<String> Woerter;
    variable Variable1;
    variable Variable2;
    variable Variable3;

    public constraint(List<String> woerter, variable V1, variable V2, variable V3)
    {
        Woerter = woerter;
        Variable1 = V1;
        Variable2 = V2;
        Variable3 = V3;
    }

    public boolean satisfied(char c1, char c2, char c3)
    {
        if(Woerter.contains(""+ c1 + c2 + c3))
        {
            return true;
        }
        return false;

    }

    public variable getVariable1()
    {
        return Variable1;
    }

    public variable getVariable2()
    {
        return Variable2;
    }

    public variable getVariable3()
    {
        return Variable3;
    }

    public boolean containsVariable(variable v)
    {
        if(v == Variable1){return true;}
        if(v == Variable2){return true;}
        if(v == Variable3){return true;}
        return false;
    }
}
