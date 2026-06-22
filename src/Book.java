import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String bookId;
    private int bookCopies;



    public Book(String title, String author, String bookId, int bookCopies){
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.bookCopies = bookCopies;
    }


    // setters

    public  String getBookByauthor(){
        return author;
    }

    public  String getBookByTitle(){
        return title;
    }


    public int getBookByCopies(){
          return bookCopies;
    }

    public int setBookByCopies(int bookCopies){
        return this.bookCopies = bookCopies;
    }

    public String getBookById() {
        return bookId;
    }



    public void setTitle(String title){
        this.title = title;
    }
}


// abstract

abstract class User{
    private String name;
    private int userId;


    abstract void displayRole();
}


// interface

interface Borrow {

    void borrowBook(Book book);

    void returnBook(Book book);
}



class LibraryBorrowServices implements Borrow {

    @Override
    public void borrowBook(Book book){
        System.out.println(book.getBookByTitle() + " and " + " " + book.getBookByCopies() + "borrowed successfully" );
    }

    @Override
    public void returnBook(Book book){
        System.out.println("book returned sucessfully");
    }

}



// composition

class Member extends User{

    private Borrow borrowService;

     public Member(Borrow borrowService){
         this.borrowService = borrowService;
     }


    public void borrowBook(Book book){
        if(book.getBookByCopies() > 0){
         book.setBookByCopies(book.getBookByCopies() - 1);
            System.out.println("borrowed successfully");
        }else {
            System.out.println("book not available");
        }
    }

    public void returnBook(Book book){
         borrowService.returnBook(book);
    }




     @Override
    public void displayRole(){
         System.out.println("I'm a member");
     }
}


class Librarian extends User{

    @Override
    public void displayRole(){
        System.out.println("I'm a librarian");
    }

}



class Library{
    private  final ArrayList<Book> books = new ArrayList<>();


    public void addBook(Book book){
        books.add(book);

        System.out.println(book.getBookByTitle() + " book was added successfully");
    }




    public  void viewAllBooks(){
        for(Book b : books){
            System.out.println(b.getBookByTitle() +" " + b.getBookByCopies() + " " + b.getBookById() + " " + b.getBookByauthor() );
        }
    }



    public void updateBook(String bookId, int newCopies, String title){
        for(Book bId: books){
            if(bId.getBookById().equals(bookId)){
                bId.setBookByCopies(newCopies);
                bId.setTitle(title);


            }
        }
    }


    public void removeBook(String bookId){

        for(Book bId: books){
            if(bId.getBookById().equals(bookId)){
                books.remove(bId);


                System.out.println("book deleted successfully");
                return;
            }
        }
        System.out.println("book not found");

    }


}









