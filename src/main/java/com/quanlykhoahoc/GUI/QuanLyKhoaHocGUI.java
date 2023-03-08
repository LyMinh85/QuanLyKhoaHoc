/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.quanlykhoahoc.GUI;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 *
 * @author pc
 */
public class QuanLyKhoaHocGUI extends javax.swing.JFrame {

    private ArrayList<JButton> listNavbarBtn;

    /**
     * Creates new form BaseGUI
     */
    public QuanLyKhoaHocGUI() {
        initComponents();
        setLocationRelativeTo(null);
        listNavbarBtn = new ArrayList<>();
        listNavbarBtn.add(btnStudent);
        listNavbarBtn.add(btnInstructor);
        listNavbarBtn.add(btnCourse);
        listNavbarBtn.add(btnCourseInstructor);
        listNavbarBtn.add(btnStudentGrade);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();
        courseInstructorGUI1 = new com.quanlykhoahoc.GUI.CourseInstructorGUI();
        onlineCourseGUI1 = new com.quanlykhoahoc.GUI.OnlineCourseGUI();
        jPanel2 = new javax.swing.JPanel();
        btnStudent = new javax.swing.JButton();
        btnInstructor = new javax.swing.JButton();
        btnCourse = new javax.swing.JButton();
        btnCourseInstructor = new javax.swing.JButton();
        btnStudentGrade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khóa học");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(courseInstructorGUI1, "courseInstructorGUI");
        cardPanel.add(onlineCourseGUI1, "onlineCourseGUI");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnStudent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-student-male-24.png"))); // NOI18N
        btnStudent.setText("Student");
        btnStudent.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnStudent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnStudent.setMargin(new java.awt.Insets(2, 30, 3, 14));
        btnStudent.setOpaque(true);
        btnStudent.setPreferredSize(new java.awt.Dimension(125, 40));
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        jPanel2.add(btnStudent);

        btnInstructor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-teacher-24.png"))); // NOI18N
        btnInstructor.setText("Instructor");
        btnInstructor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnInstructor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInstructor.setMargin(new java.awt.Insets(2, 30, 3, 14));
        btnInstructor.setPreferredSize(new java.awt.Dimension(125, 40));
        jPanel2.add(btnInstructor);

        btnCourse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-e-learning-24.png"))); // NOI18N
        btnCourse.setText("Course");
        btnCourse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnCourse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCourse.setMargin(new java.awt.Insets(2, 30, 3, 14));
        btnCourse.setPreferredSize(new java.awt.Dimension(125, 40));
        btnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseActionPerformed(evt);
            }
        });
        jPanel2.add(btnCourse);

        btnCourseInstructor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCourseInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-course-assign-24.png"))); // NOI18N
        btnCourseInstructor.setText("Course instructor");
        btnCourseInstructor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnCourseInstructor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCourseInstructor.setMargin(new java.awt.Insets(2, 30, 3, 14));
        btnCourseInstructor.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCourseInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseInstructorActionPerformed(evt);
            }
        });
        jPanel2.add(btnCourseInstructor);

        btnStudentGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnStudentGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-scorecard-24.png"))); // NOI18N
        btnStudentGrade.setText("Student grade");
        btnStudentGrade.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        btnStudentGrade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnStudentGrade.setMargin(new java.awt.Insets(2, 30, 3, 14));
        btnStudentGrade.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(btnStudentGrade);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnCourseInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseInstructorActionPerformed
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "courseInstructorGUI");
    }//GEN-LAST:event_btnCourseInstructorActionPerformed

    private void btnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseActionPerformed
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "onlineCourseGUI");
    }//GEN-LAST:event_btnCourseActionPerformed

    public void navbarBtnOnSelect(java.awt.event.ActionEvent evt) {
        listNavbarBtn.forEach(btn -> {
            if (btn.getText().equalsIgnoreCase(evt.getActionCommand())) {
                btn.setSelected(true);
            } else {
                btn.setSelected(false);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatLight look and feel */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhoaHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhoaHocGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourse;
    private javax.swing.JButton btnCourseInstructor;
    private javax.swing.JButton btnInstructor;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnStudentGrade;
    private javax.swing.JPanel cardPanel;
    private com.quanlykhoahoc.GUI.CourseInstructorGUI courseInstructorGUI1;
    private javax.swing.JPanel jPanel2;
    private com.quanlykhoahoc.GUI.OnlineCourseGUI onlineCourseGUI1;
    // End of variables declaration//GEN-END:variables
}
