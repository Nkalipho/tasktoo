import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;

public class XMLReader {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the field names separated by commas: ");
            String input = scanner.nextLine();
            String[] selectedFields = input.split(",");

            for (String fieldName : selectedFields) {
                String fieldValue = extractFieldData(fieldName.trim()); // Assuming fieldName matches the XML field name
                System.out.println(fieldName + ": " + fieldValue);
            }


            // Your code to process selectedFields
            try {
                // Step 1: Create a DocumentBuilderFactory
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                
                // Step 2: Parse the XML file
                Document document = builder.parse(new File("/home/mthobisi/Desktop/Python Libs/Java/data.xml"));
                
                // Step 3: Traverse through the XML and print field values
                NodeList nodeList = document.getElementsByTagName(input); // Change "field" to the actual tag name
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        String fieldValue = element.getTextContent();
                        System.out.println("Field value: " + fieldValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String extractFieldData(String trim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractFieldData'");
    }
}
