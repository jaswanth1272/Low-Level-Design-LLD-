// Abstract class with a template method
abstract class DocumentProcessor {
    
    // Template method defining the overall process
    public final void processDocument() {
        loadDocument();
        parseDocument();
        saveDocument();
    }
    
    // Abstract methods for the steps that will be implemented by subclasses
    protected abstract void loadDocument();
    protected abstract void parseDocument();
    protected abstract void saveDocument();
}

// Concrete subclass for Word document
class WordDocumentProcessor extends DocumentProcessor {
    
    @Override
    protected void loadDocument() {
        System.out.println("Loading Word document...");
    }

    @Override
    protected void parseDocument() {
        System.out.println("Parsing Word document...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving Word document...");
    }
}

// Concrete subclass for PDF document
class PDFDocumentProcessor extends DocumentProcessor {

    @Override
    protected void loadDocument() {
        System.out.println("Loading PDF document...");
    }

    @Override
    protected void parseDocument() {
        System.out.println("Parsing PDF document...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving PDF document...");
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentProcessor wordProcessor = new WordDocumentProcessor();
        wordProcessor.processDocument();  // Process Word document
        
        System.out.println(); 
        
        DocumentProcessor pdfProcessor = new PDFDocumentProcessor();
        pdfProcessor.processDocument();  // Process PDF document
    }
}
