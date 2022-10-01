/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.awt.*;
/**
 *
 * @author tylerliu
 */
public class QuestionPanel extends javax.swing.JPanel {

    private Question question;
    /**
     * Creates new form QuestionPanel
     */
    public QuestionPanel(Question q) {
        initComponents();
        question = q;
        GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(3);
        questionTxt.setText(q.getQuestionText());
        System.out.println("created");
    }
    
    public String getAnswerTxt() {
        return answerTxt.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionTxt = new javax.swing.JTextField();
        answerTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(200, 400));
        setSize(new java.awt.Dimension(200, 300));

        questionTxt.setEditable(false);
        questionTxt.setText("jTextField1");

        answerTxt.setText("Enter Answer...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(questionTxt)
            .addComponent(answerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(answerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(174, 174, 174))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerTxt;
    private javax.swing.JTextField questionTxt;
    // End of variables declaration//GEN-END:variables
}
