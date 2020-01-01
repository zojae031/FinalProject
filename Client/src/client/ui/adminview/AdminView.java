package client.ui.adminview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface AdminView {
    JPanel adminStartPanel = new JPanel();



    void addAdminListener(ActionListener listener);
}
