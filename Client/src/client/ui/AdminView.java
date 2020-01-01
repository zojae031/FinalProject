package client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface AdminView {
    JPanel adminStartPanel = new JPanel();
    CardLayout AdminCardLayout = new CardLayout();
    Container AdminTab = new Container();

    void addAdminListener(ActionListener listener);
}
