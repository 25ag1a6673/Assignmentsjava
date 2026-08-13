abstract class LibraryItem {

    // Encapsulation
    protected String title;
    protected int itemId;
    protected boolean isIssued;

    // Constructor
    LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    // Abstract method
    abstract int calculateFine(int daysLate);

    // Concrete method
    public void displayInfo() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Issued: " + isIssued);
    }
}


// Interface
interface Issueable {

    void issueItem();

    void returnItem();
}


// Book subclass
class Book extends LibraryItem implements Issueable {

    Book(String title, int itemId) {
        super(title, itemId);
    }

    // Fine = Rs. 5 per day
    @Override
    int calculateFine(int daysLate) {
        return daysLate * 5;
    }

    @Override
    public void issueItem() {
        isIssued = true;
        System.out.println(title + " (Book) issued.");
    }

    @Override
    public void returnItem() {
        isIssued = false;
        System.out.println(title + " (Book) returned.");
    }

    // Method overriding
    @Override
    public String toString() {
        return "Item: " + title + " (Book)";
    }
}


// Magazine subclass
class Magazine extends LibraryItem implements Issueable {

    Magazine(String title, int itemId) {
        super(title, itemId);
    }

    // Fine = Rs. 2 per day
    @Override
    int calculateFine(int daysLate) {
        return daysLate * 2;
    }

    @Override
    public void issueItem() {
        isIssued = true;
        System.out.println(title + " (Magazine) issued.");
    }

    @Override
    public void returnItem() {
        isIssued = false;
        System.out.println(title + " (Magazine) returned.");
    }

    // Method overriding
    @Override
    public String toString() {
        return "Item: " + title + " (Magazine)";
    }
}


// Main class
public class AssignmentP5 {

    public static void main(String[] args) {

        // Creating 2 Books and 2 Magazines
        Book book1 = new Book("Java Programming", 101);
        Book book2 = new Book("Clean Code", 102);

        Magazine magazine1 = new Magazine("National Geographic", 201);
        Magazine magazine2 = new Magazine("Time Magazine", 202);

        // Issue items
        book1.issueItem();
        book2.issueItem();
        magazine1.issueItem();
        magazine2.issueItem();

        System.out.println("\n--- Fine Details ---");

        // Runtime polymorphism
        LibraryItem[] items = {
            book1,
            magazine1,
            book2,
            magazine2
        };

        int[] lateDays = {4, 4, 2, 2};

        for (int i = 0; i < items.length; i++) {

            System.out.println(
                items[i] +
                " | Fine for " +
                lateDays[i] +
                " days late: Rs." +
                items[i].calculateFine(lateDays[i])
            );
        }

        // Return items
        System.out.println("\n--- Returning Items ---");

        book1.returnItem();
        book2.returnItem();
        magazine1.returnItem();
        magazine2.returnItem();
    }
}