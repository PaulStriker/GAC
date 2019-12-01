public class arc
{
    variable Variable;
    constraint constraint;

    /*
    Konstruktor für die Arcs
     */
    public arc(variable variable, constraint c)
    {
        Variable = variable;
        constraint = c;
    }

    /*
    Gibt die Constraint aus
     */
    public constraint getConstraint()
    {
        return constraint;
    }

    /*
    Gibt die Variable aus
     */
    public variable getVariable()
    {
        return Variable;
    }
}
