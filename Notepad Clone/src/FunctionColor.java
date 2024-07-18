import java.awt.Color;

public class FunctionColor {
    Gui gui;

    public FunctionColor(Gui gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {
        switch (color) {
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                break;

            case "Blue":
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.white);
                break;

            case "Cyan":
                gui.window.getContentPane().setBackground(Color.cyan);
                gui.textArea.setBackground(Color.cyan);
                gui.textArea.setForeground(Color.red);
                break;

            default:
                break;
        }
    }
}
