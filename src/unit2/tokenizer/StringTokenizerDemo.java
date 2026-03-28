package unit2.tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        System.out.println("=== StringTokenizer Demonstration ===\n");
        
        System.out.println("1. Basic Tokenization:");
        demonstrateBasicTokenization();
        
        System.out.println("\n2. Custom Delimiters:");
        demonstrateCustomDelimiters();
        
        System.out.println("\n3. Including Delimiters:");
        demonstrateIncludeDelimiters();
        
        System.out.println("\n4. Counting Tokens:");
        demonstrateTokenCounting();
        
        System.out.println("\n5. Advanced Examples:");
        demonstrateAdvancedExamples();
        
        System.out.println("\n6. Comparison with String.split():");
        compareWithSplit();
    }
    
    public static void demonstrateBasicTokenization() {
        String sentence = "Java is a powerful programming language";
        System.out.println("Original sentence: \"" + sentence + "\"");
        
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        
        System.out.println("Tokens using default delimiter (whitespace):");
        int tokenCount = 0;
        while (tokenizer.hasMoreTokens()) {
            tokenCount++;
            String token = tokenizer.nextToken();
            System.out.println("Token " + tokenCount + ": \"" + token + "\"");
        }
        
        System.out.println("Total tokens: " + tokenCount);
    }
    
    public static void demonstrateCustomDelimiters() {
        String data = "John,25;Jane,30;Bob,35;Alice,28";
        System.out.println("Original data: \"" + data + "\"");
        
        // Using comma and semicolon as delimiters
        StringTokenizer tokenizer1 = new StringTokenizer(data, ",;");
        
        System.out.println("Tokens using ',' and ';' as delimiters:");
        int tokenCount = 0;
        while (tokenizer1.hasMoreTokens()) {
            tokenCount++;
            String token = tokenizer1.nextToken();
            System.out.println("Token " + tokenCount + ": \"" + token + "\"");
        }
        
        System.out.println("\nProcessing as name-age pairs:");
        StringTokenizer tokenizer2 = new StringTokenizer(data, ";");
        int pairCount = 0;
        while (tokenizer2.hasMoreTokens()) {
            pairCount++;
            String pair = tokenizer2.nextToken();
            StringTokenizer nameAgeTokenizer = new StringTokenizer(pair, ",");
            String name = nameAgeTokenizer.nextToken();
            String age = nameAgeTokenizer.nextToken();
            System.out.println("Person " + pairCount + ": " + name + " is " + age + " years old");
        }
    }
    
    public static void demonstrateIncludeDelimiters() {
        String expression = "x+y*z/w-p";
        System.out.println("Mathematical expression: \"" + expression + "\"");
        
        // Without delimiters
        StringTokenizer tokenizer1 = new StringTokenizer(expression, "+-*/");
        System.out.println("Tokens without delimiters:");
        while (tokenizer1.hasMoreTokens()) {
            System.out.println("  \"" + tokenizer1.nextToken() + "\"");
        }
        
        // With delimiters
        StringTokenizer tokenizer2 = new StringTokenizer(expression, "+-*/", true);
        System.out.println("Tokens with delimiters included:");
        while (tokenizer2.hasMoreTokens()) {
            System.out.println("  \"" + tokenizer2.nextToken() + "\"");
        }
    }
    
    public static void demonstrateTokenCounting() {
        String text = "The quick brown fox jumps over the lazy dog";
        System.out.println("Text: \"" + text + "\"");
        
        StringTokenizer tokenizer = new StringTokenizer(text);
        
        System.out.println("Using countTokens() method:");
        int initialCount = tokenizer.countTokens();
        System.out.println("Initial token count: " + initialCount);
        
        System.out.println("Processing tokens:");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("  \"" + token + "\" (remaining: " + tokenizer.countTokens() + ")");
        }
        
        System.out.println("Final token count: " + tokenizer.countTokens());
    }
    
    public static void demonstrateAdvancedExamples() {
        System.out.println("=== Advanced Tokenization Examples ===\n");
        
        // Example 1: CSV parsing
        System.out.println("1. CSV Parsing:");
        String csvData = "Apple,Fruit,1.50;Banana,Fruit,0.75;Bread,Bakery,2.25";
        StringTokenizer csvTokenizer = new StringTokenizer(csvData, ";");
        
        while (csvTokenizer.hasMoreTokens()) {
            String item = csvTokenizer.nextToken();
            StringTokenizer itemTokenizer = new StringTokenizer(item, ",");
            String name = itemTokenizer.nextToken();
            String category = itemTokenizer.nextToken();
            String price = itemTokenizer.nextToken();
            System.out.println("  " + name + " (" + category + "): $" + price);
        }
        
        // Example 2: File path parsing
        System.out.println("\n2. File Path Parsing:");
        String filePath = "C:\\Users\\John\\Documents\\report.pdf";
        StringTokenizer pathTokenizer = new StringTokenizer(filePath, "\\", true);
        
        System.out.println("Path components:");
        while (pathTokenizer.hasMoreTokens()) {
            System.out.println("  \"" + pathTokenizer.nextToken() + "\"");
        }
        
        // Example 3: Sentence word analysis
        System.out.println("\n3. Word Analysis:");
        String longSentence = "Programming in Java is fun and challenging at the same time";
        StringTokenizer wordTokenizer = new StringTokenizer(longSentence);
        
        int wordCount = 0;
        int totalLength = 0;
        String longestWord = "";
        
        while (wordTokenizer.hasMoreTokens()) {
            String word = wordTokenizer.nextToken();
            wordCount++;
            totalLength += word.length();
            
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        double averageLength = (double) totalLength / wordCount;
        System.out.println("Total words: " + wordCount);
        System.out.println("Average word length: " + String.format("%.2f", averageLength));
        System.out.println("Longest word: \"" + longestWord + "\"");
        
        // Example 4: URL parsing
        System.out.println("\n4. URL Parsing:");
        String url = "https://www.example.com/path/to/page?param1=value1&param2=value2";
        
        // Extract protocol
        StringTokenizer protocolTokenizer = new StringTokenizer(url, ":");
        String protocol = protocolTokenizer.nextToken();
        System.out.println("Protocol: " + protocol);
        
        // Extract domain
        String remaining = url.substring(protocol.length() + 3); // Skip "://"
        StringTokenizer domainTokenizer = new StringTokenizer(remaining, "/");
        String domain = domainTokenizer.nextToken();
        System.out.println("Domain: " + domain);
        
        // Extract path
        StringTokenizer pathTokenizer = new StringTokenizer(remaining.substring(domain.length()), "?");
        String path = pathTokenizer.hasMoreTokens() ? pathTokenizer.nextToken() : "";
        System.out.println("Path: " + path);
        
        // Extract parameters
        if (pathTokenizer.hasMoreTokens()) {
            String params = pathTokenizer.nextToken();
            StringTokenizer paramTokenizer = new StringTokenizer(params, "&");
            System.out.println("Parameters:");
            while (paramTokenizer.hasMoreTokens()) {
                String param = paramTokenizer.nextToken();
                StringTokenizer keyValueTokenizer = new StringTokenizer(param, "=");
                String key = keyValueTokenizer.nextToken();
                String value = keyValueTokenizer.nextToken();
                System.out.println("  " + key + " = " + value);
            }
        }
    }
    
    public static void compareWithSplit() {
        System.out.println("=== StringTokenizer vs String.split() Comparison ===\n");
        
        String data = "apple,banana,,cherry,,date";
        System.out.println("Test data: \"" + data + "\"");
        
        System.out.println("\nStringTokenizer approach:");
        StringTokenizer tokenizer = new StringTokenizer(data, ",");
        int tokenCount = 0;
        while (tokenizer.hasMoreTokens()) {
            tokenCount++;
            System.out.println("Token " + tokenCount + ": \"" + tokenizer.nextToken() + "\"");
        }
        
        System.out.println("\nString.split() approach:");
        String[] tokens = data.split(",");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println("Token " + (i + 1) + ": \"" + tokens[i] + "\"");
        }
        
        System.out.println("\nKey Differences:");
        System.out.println("StringTokenizer:");
        System.out.println("- Legacy class (Java 1.0)");
        System.out.println("- Doesn't return empty tokens");
        System.out.println("- More memory efficient for large strings");
        System.out.println("- Can include delimiters in results");
        System.out.println();
        
        System.out.println("String.split():");
        System.out.println("- Modern approach (Java 1.4+)");
        System.out.println("- Returns empty tokens");
        System.out.println("- Supports regular expressions");
        System.out.println("- More flexible and powerful");
        System.out.println();
        
        System.out.println("When to use StringTokenizer:");
        System.out.println("- Processing very large strings");
        System.out.println("- Need memory efficiency");
        System.out.println("- Want to include delimiters");
        System.out.println("- Working with legacy code");
        System.out.println();
        
        System.out.println("When to use String.split():");
        System.out.println("- Need regular expression support");
        System.out.println("- Want to preserve empty tokens");
        System.out.println("- Modern Java applications");
        System.out.println("- More complex parsing needs");
    }
}
