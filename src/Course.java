/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
/**
 *
 * @author tylerliu
 */
public class Course {
    
    private String name;
    private ArrayList<Topic> topics = new ArrayList<Topic>();
    
    public Course(String name, ArrayList<Topic> topics) {
        this.name = name;
        this.topics = topics;
    }
    
    public static void main(String[] args) {
        ArrayList<Topic> algebraTopics = new ArrayList<Topic>();
        algebraTopics.add(new Quadratic("quadratic"));
        Course algebra = new Course("algebra", algebraTopics);
        
    }
}
