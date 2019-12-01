import java.util.ArrayList;
import java.util.List;

public class GAC {



    public GAC(List<domains> dom, List<variable> Vs, List<constraint> Cs)
    {
        List<arc> to_do = new ArrayList<>();
        for(constraint c : Cs)
        {
            to_do.add(new arc(c.getVariable1(), c));                //Initialisierung der to_do Liste
            to_do.add(new arc(c.getVariable2(), c));
            to_do.add(new arc(c.getVariable3(), c));
        }

        List<domains> result = GAC2(dom, Vs, Cs, to_do);
        for (domains d : result)
        {
            System.out.print("Position" + d.getVariable().getPosition() + ":");
            for(char c : d.getOptions())
            {
                System.out.print(c+ ",");
            }
            System.out.println("");
        }
    }

    public List<domains> GAC2(List<domains> dom, List<variable> Vs, List<constraint> Cs,  List<arc> to_do)
    {
        while(!to_do.isEmpty())
        {
            System.out.println("Still running");
            variable V1;
            variable V2;
            variable V3;
            arc tmp = to_do.get(0);             //wählt einen Knoten aus der To-Do-Liste aus
            to_do.remove(0);             // Entfernt diesesn Knoten aus der To-Do-Liste
            constraint tmpc = tmp.getConstraint();
            V1 = tmp.getVariable();
            List<Character> SatPos = new ArrayList<>();  // In der Liste SatPos werden bei der Überprüfung die möglichen Belegungen für die Variable gespiechert
            if(tmpc.getVariable1() == V1) {                 //Hier wird geprüft, welche Elemente der Domain den Constraint erfüllen, sollte V1 die erste Variable eines Constraints sein
                for(char c1 : V1.getDomain().getOptions()) {
                    for(char c2 : tmpc.getVariable2().getDomain().getOptions()) {
                        for(char c3 : tmpc.getVariable3().getDomain().getOptions()) {
                            if(tmpc.satisfied(c1, c2, c3)) {
                                if(!SatPos.contains(c1)) {
                                    SatPos.add(c1);
                                }
                            }
                        }
                    }
                }
            }

            if(tmpc.getVariable2() == V1) {              //Hier wird geprüft, welche Elemente der Domain den Constraint erfüllen, sollte V1 die zweite Variable eines Constraints sein
                for(char c1 : tmpc.getVariable1().getDomain().getOptions()) {
                    for(char c2 : V1.getDomain().getOptions()) {
                        for(char c3 : tmpc.getVariable3().getDomain().getOptions()) {
                            if(tmpc.satisfied(c1, c2, c3)) {
                                if(!SatPos.contains(c2)) {
                                    SatPos.add(c2);
                                }
                            }
                        }
                    }
                }

            }
            if(tmpc.getVariable3() == V1) {                      //Hier wird geprüft, welche Elemente der Domain den Constraint erfüllen, sollte V1 die dritte Variable eines Constraints sein
                for(char c1 : tmpc.getVariable1().getDomain().getOptions()) {
                    for(char c2 : tmpc.getVariable2().getDomain().getOptions()) {
                        for(char c3 : V1.getDomain().getOptions()) {
                            if(tmpc.satisfied(c1, c2, c3)) {
                                if(!SatPos.contains(c3)) {
                                    SatPos.add(c3);
                                }
                            }
                        }
                    }
                }
            }
            domains ND = new domains(SatPos, V1);                                             // Die neue Domain wird erzeugt.
            if(ND.getOptions().size() != V1.getDomain().getOptions().size())              //Vergleicht die Größe der Domainen und ersetzt sie gegebenenfalls. Da wir nur Elemente aus einer Domaine entfernen,
            {                                                                             //muss wenn die Domainen ungleich sind auch die Größe ungleich sein.
                dom.remove(V1.getDomain());                                               //Wenn die Domains ungleich sind wird die alte gelöscht und durch die neue ersetzt.
                V1.setDomain(ND);
                dom.add(ND);
                for(constraint c : Cs)                                                    // Die Arcs welche durch das Prunning inkonsitent geworden seinen können, kommen wieder in die to_do-Liste
                {
                    if(c.containsVariable(V1))
                    {
                        if(c != tmpc)
                        {
                            to_do.add(new arc(V1, c));
                        }
                    }
                }
            }
        }
        return dom;
    }

}
