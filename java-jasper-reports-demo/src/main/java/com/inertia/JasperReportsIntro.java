package com.inertia;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;

public class JasperReportsIntro {
    public static void main(String[] args) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            jasperReport = JasperCompileManager.compileReport(
                    "C:\\Users\\panda\\Git2.0\\tutorials\\java-jasper-reports-demo\\src\\main\\resources\\report.templates\\jasperreports_demo.jrxml");
            jasperPrint = JasperFillManager.fillReport(
                    jasperReport, new HashMap(), new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, "C:\\Users\\panda\\Git2.0\\tutorials\\java-jasper-reports-demo\\src\\main\\resources\\report.templates\\simple_report.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
