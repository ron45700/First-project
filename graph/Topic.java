package graph;
//package test;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    public final String name;
    private List <Agent> subs;
    private List <Agent> pubs;
    // optional (1) -->  private Set<Agent> subs;


//--package-private constructor - only classes from the same package have accesses to this constructor
    Topic(String name){
        this.name=name;
        this.subs = new ArrayList<>();
        this.pubs = new ArrayList<>();
        // optional (1) -->this.subs = new HashSet<>();
    }


//-- methods for adding/removing Agent a from subs List

    public void subscribe(Agent a) {
        if (!this.subs.contains(a)) {
            this.subs.add(a);
        }
        }

    public void unsubscribe(Agent a){
        this.subs.remove(a);
    }
//_____________________________________

  //method for sending Message Obj to all Agents who in subs List
    public void publish(Message m) {
        for (Agent agent : this.subs) {
            agent.callback(this.name, m);
     }
}
    //         ___Example for not using for-each___
//-- methods for publishing Message through subs list
//    public void publish(Message m){
//        for(int i=0; i<this.subs.size();i++)
//        {
//            this.subs.get(i).callback(this.name , m);
//        }
//    }
    //_________________________



    // methods for adding/removing Agent a from pubs list
    public void addPublisher(Agent a){
        if (!this.pubs.contains(a)) {
            this.pubs.add(a);
        }
    }

    public void removePublisher(Agent a){
        this.pubs.remove(a);
    }


}
