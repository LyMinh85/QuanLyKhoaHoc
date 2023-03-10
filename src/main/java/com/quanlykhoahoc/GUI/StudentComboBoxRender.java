package com.quanlykhoahoc.GUI;

import com.quanlykhoahoc.DTO.DepartmentDTO;
import com.quanlykhoahoc.DTO.StudentDTO;

import javax.swing.*;
import java.awt.*;

public class StudentComboBoxRender extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof StudentDTO) {
            StudentDTO student = (StudentDTO) value;
            setText(student.getFullName());
        }
        return this;
    }
}
