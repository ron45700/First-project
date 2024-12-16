package graph;
//package test;


import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

// Main constructor for Message by receiving String, setting all fields
    public Message(String newMessage) {

        if (newMessage == null) { // if the String is null, it will make in time error when it tries to Downcast it
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.asText = newMessage;
        double tempAsDouble = Double.NaN;
        try { // if the string is including charts and not only numbers, its will make error in runtime because it's not possible to cast char to number
            tempAsDouble = Double.parseDouble(newMessage);
        } catch (NumberFormatException e) {
        }
        this.asDouble = tempAsDouble;
        this.data = newMessage.getBytes();
        this.date = new Date();
    }
    // constructor for Message by receiving byte[] Obj
    public Message(byte[] newMessage) {
        this(new String(newMessage));
    }
    // constructor for Message by receiving double Obj
    public Message(double newMessage){
        this(String.valueOf(newMessage));
    }



}
