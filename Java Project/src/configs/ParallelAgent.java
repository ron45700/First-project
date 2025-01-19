package configs;

import graph.Agent;
import graph.Message;

//package test;
//import test.Agent;
//import test.Message;

public class ParallelAgent implements Agent {
    private final Agent agent;

    public ParallelAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String getName() {
        return agent.getName();
    }

    @Override
    public void reset() {
        agent.reset();
    }

    @Override
    public void callback(String topic, Message msg) {
        agent.callback(topic, msg);
    }

    @Override
    public void close() {
        agent.close();
    }
}
