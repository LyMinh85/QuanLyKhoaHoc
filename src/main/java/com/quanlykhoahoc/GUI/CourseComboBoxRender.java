package com.quanlykhoahoc.GUI;

import com.quanlykhoahoc.DTO.CourseDTO;
import com.quanlykhoahoc.DTO.StudentDTO;

import javax.swing.*;
import java.awt.*;

public class CourseComboBoxRender extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof CourseDTO) {
            CourseDTO coruse = (CourseDTO) value;
            setText(coruse.getTitle());
        }
        return this;
    }
}
