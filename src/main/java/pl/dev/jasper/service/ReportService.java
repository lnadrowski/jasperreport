package pl.dev.jasper.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import pl.dev.jasper.model.Employee;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public byte[] getReport () throws JRException {
        final InputStream stream = this.getClass().getResourceAsStream("/report.jrxml");
        final JasperReport report = JasperCompileManager.compileReport(stream);

        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(getEmployees());

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "javacodegeek.com");

        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, source);



        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    private static List<Employee> getEmployees () {

        var result = new ArrayList<Employee>();

        result.add(Employee.builder()
                .id(1)
                .name("Adam")
                .department("A")
                .designation("X")
                .build());

        result.add(Employee.builder()
                .id(1)
                .name("Zenon")
                .department("B")
                .designation("Y")
                .build());
        return result;
    }
}
