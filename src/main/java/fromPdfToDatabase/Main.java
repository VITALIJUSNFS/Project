//package fromPdfToDatabase;
//import java.io.File;
//import java.io.IOException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        File file = new File("C://Users/vital/Downloads/ENEFIT/202201.pdf");
//        PDDocument document = PDDocument.load(file);
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//        String text = pdfStripper.getText(document);
//        document.close();
//
//        for (String retval: text.split(" ")) {
//            //System.out.print(retval);
//
//            if (retval.startsWith("Rodmuo")){
//                System.out.println(retval.substring(10));
//            }
//        }
////        System.out.println(text);
//    }
//
//}
