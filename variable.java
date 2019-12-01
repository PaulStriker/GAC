public class variable
{
    int position;
    domains domain;
    public variable(int Position, domains Domain)
    {
        position = Position;
        domain = Domain;
    }

    //Die Methode gibt die Domain einer Variable aus.
    public domains getDomain(){return domain;}

    //Ersetzt die Domain
    public void setDomain(domains Domain){domain = Domain;}

    public int getPosition(){return position;}
}
