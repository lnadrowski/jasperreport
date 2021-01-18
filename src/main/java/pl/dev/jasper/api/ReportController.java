package pl.dev.jasper.api;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dev.jasper.service.ReportService;

@RestController
@RequestMapping ("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<byte[]> report () throws JRException {
        return new ResponseEntity<>(reportService.getReport() ,HttpStatus.OK );
    }

}
