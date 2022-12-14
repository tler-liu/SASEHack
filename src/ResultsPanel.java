/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author tylerliu
 */
public class ResultsPanel extends javax.swing.JPanel implements java.awt.event.ActionListener {

    private Quiz quiz;
    private CoursePanel coursePanel;
    private ArrayList<String> studentAnswers;
    private ArrayList<Boolean> correct;
    
    private JButton newQuizBtn;
    /**
     * Creates new form ResultsPanel
     */
    public ResultsPanel(CoursePanel coursePanel, Quiz quiz,ArrayList<String> sa) throws java.io.IOException {
        initComponents();
        this.coursePanel = coursePanel;
        this.quiz = quiz;
        studentAnswers = sa;
        correct = checkAnswers();
        
        GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(7);
        setLayout(gl);
        
        JTextField title = new JTextField();
        //title.setText(quiz.getQuestions().get(0).getQuestionTopic().getName() + " Quiz Results");
        title.setText("Quiz Results");
        title.setEditable(false);
        title.setForeground(Color.WHITE);
        title.setBackground(new Color(51, 51, 51));
        title.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        title.setBorder(null);
        title.setHorizontalAlignment(JTextField.CENTER);
        add(title);
        
        display();
        
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(new Color(51, 51, 51));
        resultPanel.setLayout(new GridLayout(1, 2));
        
        
        JTextField result = new JTextField();
        result.setEditable(false);
        //result.setBounds(0, (int) Math.round(this.getSize().getHeight()) - 30, (int) Math.round(this.getSize().getWidth()), 30);
        
        int numCorrect = 0;
        for (int i = 0; i < correct.size(); i++) {
            if (correct.get(i)) {
                numCorrect++;
            }
        }
        
        result.setText("Total Score: " + numCorrect + "/" + correct.size());
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        result.setBackground(new Color(51, 51, 51));
        result.setForeground(Color.WHITE);
        result.setBorder(null);
        resultPanel.add(result);
        
        newQuizBtn = new JButton();
        newQuizBtn.setText("Generate new quiz to practice mistakes");
        newQuizBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        newQuizBtn.addActionListener(this);
        
        resultPanel.add(newQuizBtn);
        
        
        add(resultPanel);
        
        
        
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == newQuizBtn) {
            System.out.println("new tailored quiz!");
            int typeMostNeeded = getTopicTypeMostNecessary();
            Quiz newQuiz;
            if (typeMostNeeded == 0) {
                newQuiz = quiz.getQuestions().get(0).getQuestionTopic().getQuiz();

            }
            else {
                newQuiz = quiz.getQuestions().get(0).getQuestionTopic().getQuiz(typeMostNeeded);
            }
            QuizPanel qp = new QuizPanel(coursePanel, newQuiz);
            
            coursePanel.removeAll();
            coursePanel.add(qp);
            coursePanel.validate();
            coursePanel.repaint();
            
        }
    }
    
    private int getTopicTypeMostNecessary() {
        int[] arr = new int[10];
        for (int i = 0; i < correct.size(); i++) {
            if (!correct.get(i)) {
                int type = quiz.getQuestions().get(i).getQuestionType();
                arr[type]++;
            }
        }
        
        int max = 0;
        int type = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                type = i;
            }
        }
        return type;
    }
    
    private ArrayList<Boolean> checkAnswers() throws java.io.IOException {
        ArrayList<Boolean> correct = new ArrayList<Boolean>();
        ArrayList<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getQuestionAnswer().equals(studentAnswers.get(i))) {
                correct.add(true);
            }
            else {
                correct.add(false);
                FileRead.updateInformation(questions.get(i));
            }
        }
        return correct;
    }
    
    private void display() {
        ArrayList<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            // TODO create GUI
            //System.out.println(correct.get(i));
            ResultIcon ri = new ResultIcon(questions.get(i), studentAnswers.get(i), correct.get(i));
            add(ri);
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

        setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
