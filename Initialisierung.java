import java.util.ArrayList;
import java.util.List;

public class Initialisierung {

    private List<String> Woerter;
    private List<variable> Variablen;
    private List<domains> Domains;
    private List<Character> Options;
    private List<constraint> Constraints;


    public Initialisierung()
    {
        setWoerter();
        setOptions();
        setDomain();
        setVariablen();
        setConstraints();
    }


    public List<variable> getVariablen(){return Variablen;}

    public List<domains> getDomains() { return Domains; }

    public List<constraint> getConstraints() { return Constraints;}

    /*
            Initialisiert die Liste an Woertern
             */
    public void setWoerter() {
        Woerter = new ArrayList<>();
        Woerter.add("add");
        Woerter.add("ado");
        Woerter.add("age");
        Woerter.add("ago");
        Woerter.add("aid");
        Woerter.add("ail");
        Woerter.add("aim");
        Woerter.add("air");
        Woerter.add("and");
        Woerter.add("any");
        Woerter.add("ape");
        Woerter.add("apt");
        Woerter.add("arc");
        Woerter.add("are");
        Woerter.add("ark");
        Woerter.add("arm");
        Woerter.add("art");
        Woerter.add("ash");
        Woerter.add("ask");
        Woerter.add("auk");
        Woerter.add("awe");
        Woerter.add("awl");
        Woerter.add("aye");
        Woerter.add("bad");
        Woerter.add("bag");
        Woerter.add("ban");
        Woerter.add("bat");
        Woerter.add("bee");
        Woerter.add("boa");
        Woerter.add("ear");
        Woerter.add("eel");
        Woerter.add("eft");
        Woerter.add("far");
        Woerter.add("fat");
        Woerter.add("fit");
        Woerter.add("lee");
        Woerter.add("oaf");
        Woerter.add("rat");
        Woerter.add("tar");
        Woerter.add("tie");
    }

    public void setOptions()
    {
        Options = new ArrayList<>();
        Options.add('a');
        Options.add('d');
        Options.add('o');
        Options.add('g');
        Options.add('e');
        Options.add('i');
        Options.add('l');
        Options.add('m');
        Options.add('r');
        Options.add('n');
        Options.add('y');
        Options.add('p');
        Options.add('t');
        Options.add('c');
        Options.add('k');
        Options.add('s');
        Options.add('h');
        Options.add('u');
        Options.add('w');
        Options.add('f');
        Options.add('b');
    }

    public void setDomain()
    {
        Domains = new ArrayList<>();
        for(int i = 0; i < 9; i++)
        {
            domains domain = new domains(Options);
            Domains.add(domain);
        }
    }

    public void setVariablen()
    {
        Variablen = new ArrayList<>();
        for(int i=0; i < 9; i++)
        {
            variable v = new variable(i,Domains.get(i));
            Variablen.add(v);
        }
    }

    public void setConstraints()
    {
       Constraints = new ArrayList<>();
       constraint c = new constraint(Woerter, Variablen.get(0), Variablen.get(1), Variablen.get(2));
       Constraints.add(c);
       c = new constraint(Woerter, Variablen.get(3), Variablen.get(4), Variablen.get(5));
       Constraints.add(c);
       c = new constraint(Woerter, Variablen.get(6), Variablen.get(7), Variablen.get(8));
       Constraints.add(c);
       c = new constraint(Woerter, Variablen.get(0), Variablen.get(3), Variablen.get(6));
       Constraints.add(c);
       c = new constraint(Woerter, Variablen.get(1), Variablen.get(4), Variablen.get(7));
       Constraints.add(c);
       c = new constraint(Woerter, Variablen.get(2), Variablen.get(5), Variablen.get(8));
       Constraints.add(c);
    }
}
