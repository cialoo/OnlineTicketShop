package pl.kacperSniadek.OnlineTicketShop.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.kacperSniadek.OnlineTicketShop.service.PDFMakerService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/orderComplete")
public class PDFMakerController {
    private final PDFMakerService pdfMakerService;

    @Autowired
    public PDFMakerController(PDFMakerService pdfMakerService) {
        this.pdfMakerService = pdfMakerService;
    }

    @GetMapping
    public String showOrderCompletePage() {
        return "orderComplete";
    }

    @GetMapping("/generatePDF")
    public void generatePDF(HttpServletResponse response, @SessionAttribute String name,
                            @SessionAttribute String firstName, @SessionAttribute String lastName, @SessionAttribute String location) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Ticket_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfMakerService.export(response, name, firstName, lastName, location);
    }
}
