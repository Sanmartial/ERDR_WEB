package com.globaroman.erdr_web.view;

import com.globaroman.erdr_web.view.MessageDisplayer;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component("swingMessageDisplayer")
public class SwingMessageDisplayer implements MessageDisplayer {
    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
