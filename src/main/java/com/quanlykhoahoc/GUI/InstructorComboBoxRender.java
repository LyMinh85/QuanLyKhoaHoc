package com.quanlykhoahoc.GUI;

import com.quanlykhoahoc.DTO.InstructorDTO;
import com.quanlykhoahoc.DTO.StudentDTO;

import javax.swing.*;
import java.awt.*;

public class InstructorComboBoxRender extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof InstructorDTO) {
            InstructorDTO instructor = (InstructorDTO) value;
            setText(instructor.getFullName());
        }
        return this;
    }
}
