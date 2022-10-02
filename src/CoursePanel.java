/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 *
 * @author tylerliu
 */
public class CoursePanel extends javax.swing.JPanel {

    private ArrayList<Course> courseList;
    /**
     * Creates new form CoursePanel
     */
    public CoursePanel(JPanel mainPanel) {
        initComponents();
        setSize(mainPanel.getSize());
        setLayout(new BorderLayout());
        add(jTextField1, BorderLayout.NORTH);
        add(mainContentPanel, BorderLayout.CENTER);
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(2);
        //gl.setHgap(50);
        //gl.setVgap(50);
        mainContentPanel.setLayout(gl);
        courseList = new ArrayList<Course>();
        
        // add courses and topics 
        ArrayList<Topic> algTopics = new ArrayList<Topic>();
        algTopics.add(new Algebra("All Algebra Concepts"));
        algTopics.add(new Quadratic("Quadratic"));
        algTopics.add(new Linear("Linear"));

        
        ArrayList<Topic> geoTopics = new ArrayList<Topic>();
        geoTopics.add(new PythagoreanTheorem("Pythagorean Theorem"));
        geoTopics.add(new Trigonometry("Trigonometry"));
        
        ArrayList<Topic> calc1Topics = new ArrayList<Topic>();
        ArrayList<Topic> calc2Topics = new ArrayList<Topic>();
        
        courseList.add(new Course("Algebra", algTopics));
        courseList.add(new Course("Geometry", geoTopics));
        courseList.add(new Course("Calculus I", calc1Topics));
        courseList.add(new Course("Calculus II", calc2Topics));
        
        // create CourseIcons for each course 
        for (int i = 0; i < courseList.size(); i++) {
            mainContentPanel.add(new CourseIcon(this, courseList.get(i).getName(), courseList.get(i)));
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        mainContentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(51, 51, 51));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(32, 49, 74));
        jTextField1.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Courses");
        jTextField1.setBorder(null);
        jTextField1.setMinimumSize(new java.awt.Dimension(64, 50));

        mainContentPanel.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout mainContentPanelLayout = new javax.swing.GroupLayout(mainContentPanel);
        mainContentPanel.setLayout(mainContentPanelLayout);
        mainContentPanelLayout.setHorizontalGroup(
            mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainContentPanelLayout.setVerticalGroup(
            mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainContentPanel;
    // End of variables declaration//GEN-END:variables
}
