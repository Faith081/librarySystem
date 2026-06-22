public class LibraryManagementApplication {

    public static  void main(String[] args){


        // dependency inversion priciple
        Borrow service = new LibraryBorrowServices();

        Member faith = new Member(service);


        Library library = new Library();

        Book book1 = new Book("The Forest", "Ken", "B001", 10);

        Book book2 = new Book("The Rivers", "Ben", "B001", 10);


        library.addBook(book1);
        library.addBook(book2);


        Librarian librarian = new Librarian();

        librarian.displayRole();


        faith.returnBook(book1);

      library.viewAllBooks();

    }



}
