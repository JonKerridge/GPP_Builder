package gppBuilder;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * GPPbuilder provides a means of transforming a file containing the definition of a
 * GPP defined application, in which, the process definitions omit the communication and
 * parallel composition definitions.  The program constructs the required definitions
 * automatically.
 *
 * The argument to the program is a \path\filename that has a .gpp suffix.  The
 * supplied argument should omit the suffix.  The output is the \path\filename now
 * with a .groovy suffix.  The outpfile can be executed as a groovy script.
 * Any errors will be placed in the output file at the place where they were detected.
 *
 */
public class GPPbuilder  extends JPanel{

    /**
     *
     * @param args args[0] contains the full path name of a the file to be converted,
     *             excluding the .gpp suffix
     *
     */
    public static void main(String[] args) {
        String fileRoot = args[0];
//        String inFile = fileRoot +  "_gpp.groovy";
        String inFile = fileRoot +  ".gpp";
        String outFile = fileRoot + ".groovy";
        GPPlexFileHanding gppLexer = new GPPlexFileHanding();
        gppLexer.openFiles(inFile, outFile);
        System.out.println( "Transforming: " + inFile);
        System.out.println( "Into: " + outFile);
        String error = gppLexer.parse();
        if ( error == ""){
            System.out.println("Build Successful: " + outFile);
        }
        else System.out.println("Build failed:" + error);
    }

    /**
     * A method that calls the GPPbuilder program.
     *
     * @param fileRoot the name of the root of the file to be transformed without the _gpp.groovy suffix, the output
     * is a file with the a .groovy suffix that can be executed as a groovy script.
     */
    public static void runBuilder(String fileRoot){
//        String inFile = fileRoot +  "_gpp.groovy";
        String inFile = fileRoot +  ".gpp";
        String outFile = fileRoot + ".groovy";
        GPPlexFileHanding gppLexer = new GPPlexFileHanding();
        gppLexer.openFiles(inFile, outFile);
        System.out.println( "Transforming: " + inFile);
        System.out.println( "Into: " + outFile);
        String error = gppLexer.parse();
        if ( error == ""){
            System.out.println("Build Successful: " + outFile);
        }
        else System.out.println("Build failed:" + error);

    }

    public static void selectingBuilder() {
        JFrame frame = new JFrame("GPP File Processing");
        JTextArea messages = new JTextArea();
        messages.setRows(5);
        frame.getContentPane().add(messages);
        frame.setSize(800,200);
        frame.setLocation(200,200);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setLocation(400,400);
        fileChooser.setSize(1000, 1000);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("GPP Files", "gpp", "cgpp"));
//        fileChooser.setVisible(true);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            frame.setVisible(true);
            messages.append("Processing file    \n");
            String fileName = selectedFile.getAbsolutePath();
            messages.append(fileName + "\n");
        }
    }

}
