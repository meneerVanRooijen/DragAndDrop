package scratchpad;

import apple.laf.JRSUIUtils.Images;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DragAndDrop extends JFrame {
    JLabel pic1,pic2,pic3;
    
    public DragAndDrop(){
        super("Drag and Drop Images");
        pic1 = new JLabel();
        pic2 = new JLabel();
        pic3 = new JLabel();
        
        pic1.setBounds(20, 30, 270, 270);
        pic2.setBounds(350, 30, 270, 270);
        pic3.setBounds(20, 350, 270, 270);
        
        // SetIcon is nu aangepast voor apple.
        // Hieronder de 'windows style' hoe een icon toe te voegen
        // Deze dient natuurlijk ook voor pic2 en pic3 aangepast te worden
        //pic1.setIcon(new ImageIcon("C:\\Users\\samsng\\Desktop\\j.png"));
        pic1.setIcon(new ImageIcon(Images.class.getResource("/resources/like-icon.png")));
        pic2.setIcon(new ImageIcon(Images.class.getResource("/resources/apple-icon.png")));
        pic3.setIcon(new ImageIcon(Images.class.getResource("/resources/apple-icon.png")));
        
        MouseListener ml = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                lbl.setIcon(new ImageIcon(Images.class.getResource("/resources/like-icon.png")));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent)e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        
        pic1.addMouseListener(ml);
        pic2.addMouseListener(ml);
        pic3.addMouseListener(ml);
        
        pic1.setTransferHandler(new TransferHandler("icon"));
        pic2.setTransferHandler(new TransferHandler("icon"));
        pic3.setTransferHandler(new TransferHandler("icon"));
        
        add(pic1);
        add(pic2);
        add(pic3);
        
        setLayout(null);
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
       
  public static void main(String[] args){ 
      new DragAndDrop();
  }
}