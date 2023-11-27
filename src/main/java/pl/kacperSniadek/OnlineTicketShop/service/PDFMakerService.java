package pl.kacperSniadek.OnlineTicketShop.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PDFMakerService {
    public void export(HttpServletResponse response, String NameOfTicket, String firstName, String lastName, String location ) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph(NameOfTicket, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("Your ticket to show!", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph3 = new Paragraph(location, fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph4 = new Paragraph(firstName + " " + lastName, fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);

        document.close();
    }
}
