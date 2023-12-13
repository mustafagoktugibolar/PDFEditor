
import java.io.File;
import java.io.FileOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;public class Helper {
    public static void createPDF(String fileName, String location){
        try {
            // PDF dosyasını oluştur
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // PDF içeriği ekle
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Merhaba, bu PDF dosyasını imzalıyorum.");
            contentStream.endText();
            contentStream.close();

            // İmza eklemek için bir PDSignature nesnesi oluşturun
            PDSignature signature = new PDSignature();
            signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);
            signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
            signature.setName("İmzacı İsmi");
            signature.setLocation("İmza Konumu");
            signature.setReason("İmza Nedeni");

            // PDF dosyasına imzayı ekleyin
            document.addSignature(signature);

            // PDF dosyasını kaydet
            document.save("imzali_belge.pdf");
            document.close();

            System.out.println("PDF dosyası başarıyla imzalandı.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
