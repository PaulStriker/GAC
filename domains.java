import java.util.List;

public class domains
{
    List<Character> options; // Liste der möglichen Belegungen
    variable variable;

    /*
    Konstruktor für die Domains
     */
    public domains(List<Character> PossibleOptions, variable v)
    {
        variable = v;
        options = PossibleOptions;
    }

    /*
   Konstruktor für die Domains
    */
    public domains(List<Character> PossibleOptions)
    {
        options = PossibleOptions;
    }


    /*
    Gibt uns die Liste der möglichen Belegungen aus
     */
    public List<Character> getOptions()
    {
        return options;
    }

    public variable getVariable() {
        return variable;
    }
}
