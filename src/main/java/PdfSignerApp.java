import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PdfSignerApp extends JFrame {
    private JButton createPdfButton;
    private JButton signPdfButton;

    public PdfSignerApp() {
        super("PDF Signer App");
        initializeUI();
    }

    private void initializeUI() {
        createPdfButton = new JButton("Create New PDF");
        signPdfButton = new JButton("Add to Existing PDF");

        createPdfButton.addActionListener(e -> createPdf("deneme", "Desktop"));

        signPdfButton.addActionListener(e -> signPdf());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createPdfButton);
        buttonPanel.add(signPdfButton);

        add(buttonPanel, BorderLayout.CENTER);

        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createPdf(String fileName, String location) {
        // PDF Creation Process
        System.out.println("Creating PDF...");
        Helper.createPDF(fileName, location);
        // After Creation Open The Blank File to Edit
    }

    private void signPdf() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected PDF : " + selectedFile.getAbsolutePath());

            // Adding Signature to the PDF Process : NOT DONE!!!
            System.out.println("Adding Signature to the PDF...");

        }
    }

}
