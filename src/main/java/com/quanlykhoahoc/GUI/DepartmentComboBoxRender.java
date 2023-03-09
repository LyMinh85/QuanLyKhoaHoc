package com.quanlykhoahoc.GUI;

import com.quanlykhoahoc.DTO.DepartmentDTO;

import javax.swing.*;
import java.awt.*;

public class DepartmentComboBoxRender extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof DepartmentDTO) {
            DepartmentDTO department = (DepartmentDTO) value;
            setText(department.getName());
        }
        return this;
    }
}
