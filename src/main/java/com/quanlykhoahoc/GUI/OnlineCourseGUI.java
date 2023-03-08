package com.quanlykhoahoc.GUI;

import com.quanlykhoahoc.BUS.OnlineCourseBUS;
import com.quanlykhoahoc.DTO.OnlineCourseDTO;
import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.DepartmentDTO;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class OnlineCourseGUI extends javax.swing.JPanel {
    private class ItemDepartmentName {
        private int id;
        private String name;

        public ItemDepartmentName(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public class MyObjectListCellRenderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            if (value instanceof ItemDepartmentName) {
                value = ((ItemDepartmentName)value).getName();
            }
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            return this;
        }
    }


    OnlineCourseBUS onlineCourseBUS = new OnlineCourseBUS();

    public OnlineCourseGUI() {
        initComponents();
        showTableData();
        populateDepartmentNameComboBox();
    }

    private void populateDepartmentNameComboBox() {
        ArrayList<DepartmentDTO> departments = onlineCourseBUS.getDepartments();
        cbDepartmentName = new JComboBox<>();
        departments.forEach(d -> {
            cbDepartmentName.addItem(new ItemDepartmentName(d.getDepartmentId(), d.getName()));
        });
        cbDepartmentName.setRenderer(new MyObjectListCellRenderer());
    }

    private boolean isNullOrEmptyString(String str) {
        return str == null || str.trim().isEmpty();
    }

    private void showTableData() {
        DefaultTableModel model = (DefaultTableModel) tableOnlineCourse.getModel();
        model.setRowCount(0);
        ArrayList<OnlineCourseDTO> onlineCourses = onlineCourseBUS.getOnlineCourses();

        for (OnlineCourseDTO onlineCourse : onlineCourses) {
            Object[] row = onlineCourse.toObject();
            model.addRow(row);
        }
    }

    private void showTableData(ArrayList<OnlineCourseDTO> onlineCourses) {
        DefaultTableModel model = (DefaultTableModel) tableOnlineCourse.getModel();
        model.setRowCount(0);
        for (OnlineCourseDTO onlineCourse : onlineCourses) {
            Object[] row = onlineCourse.toObject();
            model.addRow(row);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableOnlineCourse = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbDepartmentName = new javax.swing.JComboBox<ItemDepartmentName>();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtTitle = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCredits = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 32767));
        setMinimumSize(new java.awt.Dimension(800, 0));
        setPreferredSize(new java.awt.Dimension(814, 600));

        tableOnlineCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CourseID", "Title", "Credits", "Department Name", "URL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOnlineCourse.setPreferredSize(new java.awt.Dimension(842, 300));
        jScrollPane1.add(tableOnlineCourse);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x < 5; x++){
            tableOnlineCourse.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        tableOnlineCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOnlineCoursetableOnClick(evt);
            }
        });
        jScrollPane1.setViewportView(tableOnlineCourse);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Credits:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Department Name");

        cbDepartmentName.setMinimumSize(new java.awt.Dimension(72, 25));
        cbDepartmentName.setPreferredSize(null);

        btnSearch.setText("Search");
        btnSearch.setPreferredSize(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchOnClick(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search by Titlle: ");

        txtSearch.setPreferredSize(null);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(72, 25));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOnClick(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(72, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOnClick(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setPreferredSize(new java.awt.Dimension(72, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditOnClick(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(72, 25));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetOnClick(evt);
            }
        });

        txtTitle.setPreferredSize(null);
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        txtUrl.setPreferredSize(null);
        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("URL:");

        txtCredits.setPreferredSize(null);
        txtCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditsActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Title:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý khóa học");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCredits, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableOnlineCoursetableOnClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOnlineCoursetableOnClick

        int selectedRow = tableOnlineCourse.getSelectedRow();

        if (selectedRow != -1) {
            String title = (String) tableOnlineCourse.getValueAt(selectedRow, 1);
            int credits = (int) tableOnlineCourse.getValueAt(selectedRow, 2);
            String departmentName = (String) tableOnlineCourse.getValueAt(selectedRow, 3);
            String url = (String) tableOnlineCourse.getValueAt(selectedRow, 4);

            txtTitle.setText(title);
            txtCredits.setText(String.valueOf(credits));
            cbDepartmentName.setSelectedItem(departmentName);
            txtUrl.setText(url);

        }

    }//GEN-LAST:event_tableOnlineCoursetableOnClick

    private void txtCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditsActionPerformed

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrlActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void btnResetOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetOnClick
        cbDepartmentName.setSelectedItem(null);
        txtTitle.setText(null);
        txtCredits.setText(null);
        txtUrl.setText(null);
        txtSearch.setText("");
        showTableData();
    }//GEN-LAST:event_btnResetOnClick

    private void btnEditOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditOnClick
        String title = txtTitle.getText();
        String creditsStr = txtCredits.getText();
        String url = txtUrl.getText();

        int selectedRow = tableOnlineCourse.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please choose a row to edit.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int courseId = (int) tableOnlineCourse.getValueAt(selectedRow, 0);

        if (isNullOrEmptyString(title)) {
            JOptionPane.showMessageDialog(this,
                    "The title field cannot be empty.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isNullOrEmptyString(creditsStr)) {
            JOptionPane.showMessageDialog(this,
                    "The credits field cannot be empty.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isNullOrEmptyString(url)) {
            JOptionPane.showMessageDialog(this,
                    "The url field cannot be empty.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isNumeric(creditsStr)) {
            JOptionPane.showMessageDialog(this,
                    "The credits field only accept number.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isNumeric(creditsStr)) {
            JOptionPane.showMessageDialog(this,
                    "The credits field only accept number.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int credits = Integer.parseInt(creditsStr);
        DepartmentDTO department = new DepartmentDTO();
        department.setDepartmentId(7);
        CourseDTO course = new CourseDTO(courseId, title, credits, department);
        OnlineCourseDTO onlineCourse = new OnlineCourseDTO(course, url);
        boolean success = onlineCourseBUS.update(onlineCourse);
        if (success) {
            JOptionPane.showMessageDialog(this, "Successfully edited a row.");
            showTableData();
            return;
        }
        JOptionPane.showMessageDialog(this, "Failed to edit a row.");


    }//GEN-LAST:event_btnEditOnClick

    private void btnDeleteOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOnClick
        int selectedRow = tableOnlineCourse.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int courseId = (int) tableOnlineCourse.getValueAt(selectedRow, 0);
        boolean success = onlineCourseBUS.delete(courseId);
        if (success) {
            JOptionPane.showMessageDialog(this, "Successfully deleted a row.");
            showTableData();
            return;
        }
        JOptionPane.showMessageDialog(this, "Failed to delete a row");
    }//GEN-LAST:event_btnDeleteOnClick

    private void btnAddOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOnClick
        String title = txtTitle.getText();
        String creditsStr = txtCredits.getText();
        String url = txtUrl.getText();

        if (isNullOrEmptyString(title)) {
            JOptionPane.showMessageDialog(this,
                    "The title field cannot be empty.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isNullOrEmptyString(creditsStr)) {
            JOptionPane.showMessageDialog(this,
                    "The credits field cannot be empty.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isNullOrEmptyString(url)) {
            JOptionPane.showMessageDialog(this,
                    "The url field cannot be empty.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isNumeric(creditsStr)) {
            JOptionPane.showMessageDialog(this,
                    "The credits field only accept number.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int credits = Integer.parseInt(creditsStr);
        DepartmentDTO department = new DepartmentDTO();
        department.setDepartmentId(7);
        CourseDTO course = new CourseDTO(-1, title, credits, department);
        OnlineCourseDTO onlineCourse = new OnlineCourseDTO(course, url);
        boolean success = onlineCourseBUS.addOnlineCourse(onlineCourse);
        if (success) {
            JOptionPane.showMessageDialog(this, "Successfully added 1 row.");
            showTableData();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add 1 row.");
        }
    }//GEN-LAST:event_btnAddOnClick

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchOnClick
        String name = txtSearch.getText();

        if (isNullOrEmptyString(name)) {
            JOptionPane.showMessageDialog(this, "Please enter name to search.",
                    "Error message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        showTableData(onlineCourseBUS.findByCourseTitle(name));
    }//GEN-LAST:event_btnSearchOnClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private JComboBox<ItemDepartmentName> cbDepartmentName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableOnlineCourse;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
