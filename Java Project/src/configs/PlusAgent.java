package configs;

import graph.Agent;
import graph.Message;
import graph.Topic;
import graph.TopicManagerSingleton.TopicManager;
import graph.TopicManagerSingleton;

//package test;
//
//import test.Agent;
//import test.Message;
//import test.Topic;
//import test.TopicManagerSingleton.TopicManager;
//import test.TopicManagerSingleton;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlusAgent implements Agent {
    private  String AgentName;
    private final Topic[] subs;
    private final Topic output;
    private double x =0;
    private double y = 0;

    public PlusAgent(String[] subs , String[] pubs){
        if(subs.length<2 || pubs.length <1){
            throw new IllegalArgumentException("PlusAgent requires at least 2 subs and 1 pub.");
        }
        this.AgentName = "PlusAgent";
        TopicManager manager = TopicManagerSingleton.get();
        this.subs = new Topic[]{manager.getTopic(subs[0]) , manager.getTopic(subs[1])};
        this.output = manager.getTopic(pubs[0]);

        this.subs[0].subscribe(this);
        this.subs[1].subscribe(this);
        this.output.addPublisher(this);
    }

    @Override
    public String getName(){
        return this.AgentName;
    }

    @Override
    public void reset(){
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void callback(String topic , Message msg) {
        if (topic.equals(subs[0].name)) {
            x = msg.asDouble;
        } else if (topic.equals(subs[1].name)) {
            y = msg.asDouble;
        }
        if (!Double.isNaN(x) && !Double.isNaN(y)) {
            double result = x + y;
            output.publish(new Message(result));
        }
    }
        @Override
        public void close(){
            this.subs[0].unsubscribe(this);
            this.subs[1].unsubscribe(this);
            this.output.removePublisher(this);
        }
    }






