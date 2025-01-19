package graph;
//package test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// Fields:
// - name (String): the name of the Topic.
// - subs (List<Agent>): a list of Agents subscribed to this Topic.

// Methods:
// - subscribe(Agent a): Adds an Agent to the subscription list of this Topic.
// - unsubscribe(Agent a): Removes an Agent from the subscription list of this Topic.
// - publish(Message m): Sends a Message to all Agents in the subscription list of this Topic.
// - getSubs(): returning the Agent subsList of this topic.
// - getPubs(): returning the Agent pubsList of this topic.
// - getName(): returning the name of this topic.

public class Topic {
    public final String name;
    private final List<Agent> subs = new CopyOnWriteArrayList<>();
    private final List<Agent> pubs = new CopyOnWriteArrayList<>();
    private Message lastMessage;


//--package-private constructor - only classes from the same package have accesses to this constructor
    public Topic(String name){
        if(name == null || name.isEmpty()) {
        throw  new IllegalArgumentException("Topic name cannot be null or empty");
        }
        this.name=name;
    }


//-- methods for adding/removing Agent a from subs List

    public void subscribe(Agent a) {
        if (!subs.contains(a)) {
            subs.add(a);
        }
    }

    public void unsubscribe(Agent a){
        subs.remove(a);
//        if (!pubs.contains(a)) {
//            pubs.remove(a);
//        } else {
//            System.out.println("Warning: Agent " + a.getName() + " is already a publisher for topic " + this.name);
//        }
    }


  //method for sending Message Obj to all Agents who in subs List
    public void publish(Message m) {
        lastMessage = m;
        for (Agent agent : subs) {
            try {
                agent.callback(this.name, m);
            } catch (Exception e) {
                System.err.println("Failed to send message to agent: " + agent.getName());
            }
     }
}

    // methods for adding/removing Agent a from pubs list
    public void addPublisher(Agent a) {
        if (!pubs.contains(a)) {
            pubs.add(a);
        }
    }

    public void removePublisher(Agent a){
        pubs.remove(a);
    }


    public List<Agent> getSubs(){ return subs;}
    public List<Agent> getPubs(){return pubs;}

    public String getName(){return  name;}

    public Message getMsg(){return  lastMessage;}

}
