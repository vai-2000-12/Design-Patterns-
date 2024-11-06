// Basically using the Template Pattern to create the Document ....
abstract class DocumentGenerator{

     public final void GenerateDocument(){
         gatherData();
         FormatData();
         AddFooter();
     }

     public void gatherData(){
         System.out.println("Gatehering the Data....!!");
     }

     public void FormatData(){
        System.out.println("Formating the Data...!!");
     }

     public void AddFooter(){
        System.out.println("Generating footer: Date and Company Info");
     }
}
class TextReportGenerator extends DocumentGenerator{
    public void FormatData(){
        System.out.println("Formatting the Text Data...");
    }
}
class HTMLReportGenerator extends DocumentGenerator{
    public void FormatData(){
        System.out.println("Formatting the HTML Data...");
    }
}

class JSONReportGenerator extends DocumentGenerator{
    @Override
    public void FormatData(){
        System.out.println("Formatting the JSON Data");
    }
}

public class A {
    public static void main(String[] args) {
        // Create different report generators and generate reports
        System.out.println("Generating Text Report:");
        DocumentGenerator textReport = new TextReportGenerator();
        textReport.GenerateDocument();
        
        System.out.println("\nGenerating HTML Report:");
        DocumentGenerator htmlReport = new HTMLReportGenerator();
        htmlReport.GenerateDocument();
        
        System.out.println("\nGenerating JSON Report:");
        DocumentGenerator jsonReport = new JSONReportGenerator();
        jsonReport.GenerateDocument();
    }
}