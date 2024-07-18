import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
// import java.nio.Buffer;

public class FunctionFile {
    Gui gui;
    String fileName;
    String fileAddress;

    public FunctionFile(Gui gui) {
        this.gui = gui;
    }

    // function to create a new file whenever someone click on the new items
    public void newFile() {
        gui.textArea.setText(""); // erase the current text
        gui.window.setTitle("New"); // set the default new name of the new file
    }

    public void Open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        // logic to open any files
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            // System.out.println(fileName + fileAddress);
            gui.window.setTitle(fileName);
        }
        // display the content of the file
        try {
            // we need to read the address of the file
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Save() {
        if (fileName == null) {
            SaveAs();
        } else {
            try {
                // we need to read the address of the file
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void SaveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            // System.out.println(fileName + fileAddress);
            gui.window.setTitle(fileName);
        }
        try {
            // we need to read the address of the file
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Exit() {
        System.exit(0);
    }
}
