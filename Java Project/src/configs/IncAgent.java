package configs;

import graph.Agent;
import graph.Message;
import graph.Topic;
import graph.TopicManagerSingleton;
import graph.TopicManagerSingleton.TopicManager;

//package test;
//
//import test.Agent;
//import test.Message;
//import test.Topic;
//import test.TopicManagerSingleton;
//import test.TopicManagerSingleton.TopicManager;


public class IncAgent implements Agent {
    private final String AgentName;
    private final Topic sub;
    private final Topic output;


    public IncAgent(String[]subs , String[]pubs){

        if(subs.length<1)
        {
            throw new IllegalArgumentException("subs list must be at least with one topic");
        }
        this.AgentName = "IncAgent";
        TopicManager manger = TopicManagerSingleton.get();
        this.sub = manger.getTopic(subs[0]);
        this.output = manger.getTopic(pubs[0]);

        this.sub.subscribe(this);
        this.output.addPublisher(this);

    }

    @Override
    public String getName(){
        return  this.AgentName;
    }

    @Override
    public void reset(){}

    @Override
    public void callback(String topic , Message msg){
        if (topic.equals(sub.name)) {
            double incrementedValue = msg.asDouble + 1;
            output.publish(new Message(incrementedValue));
        }
    }

    @Override
    public void close(){
        sub.unsubscribe(this);
        output.removePublisher(this);
    }


}
