package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;





    //  Book Class
    public class Book {
        // Attributes
        private String authorsName;
        private int publicationDate;
        private String bookTitle;


        // Constructor
        public Book(String bookTitle, String authorsName, int publicationDate) {
            if (bookTitle == null || bookTitle.isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be null or empty.");
            }
            if (authorsName == null || authorsName.isEmpty()) {
                throw new IllegalArgumentException("Author's name cannot be null or empty.");
            }
            if (String.valueOf(publicationDate) == null) {
                throw new IllegalArgumentException("Publication date cannot be null or empty.");
            }

            this.bookTitle = bookTitle;
            this.authorsName = authorsName;
            this.publicationDate = publicationDate;
        }

        // Getters and Setters
        public String getTitle() {
            return bookTitle;
        }

        public void setBookTitle(String bookTitle) {
            if (bookTitle == null || bookTitle.isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be null or empty.");
            }
            this.bookTitle = bookTitle;
        }

        public String getAuthors() {
            return authorsName;
        }

        public void setAuthorsName(String authorsName) {
            if (authorsName == null || authorsName.isEmpty()) {
                throw new IllegalArgumentException("Author's name cannot be null or empty.");
            }
            this.authorsName = authorsName;
        }

        public int getYearPublished() {
            return publicationDate;
        }

        public void setPublicationDate(String publicationDate) {
            if (publicationDate == null || publicationDate.isEmpty()) {
                throw new IllegalArgumentException("Publication date cannot be null or empty.");
            }
            this.publicationDate = Integer.parseInt(publicationDate);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "authorsName='" + authorsName + '\'' +
                    ", publicationDate='" + publicationDate + '\'' +
                    ", bookTitle='" + bookTitle + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Book book = (Book) obj;
            return bookTitle.equals(book.bookTitle) && authorsName.equals(book.authorsName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bookTitle, authorsName);
        }
    }

//  Patron Class


    class Patron {
        private String patronID;
        private String name;
        private String contactInfo;
        private List<Book> borrowedBooks;

        public Patron(String patronID, String name, String contactInfo) {
            if (patronID == null || patronID.isEmpty()) {
                throw new IllegalArgumentException("Patron ID cannot be null or empty.");
            }
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty.");
            }
            if (contactInfo == null || contactInfo.isEmpty()) {
                throw new IllegalArgumentException("Contact information cannot be null or empty.");
            }

            this.patronID = patronID;
            this.name = name;
            this.contactInfo = contactInfo;
            this.borrowedBooks = new ArrayList<>();
        }

        // Getters and Setters
        public String getPatronID() {
            return patronID;
        }

        public void setPatronID(String patronID) {
            if (patronID == null || patronID.isEmpty()) {
                throw new IllegalArgumentException("Patron ID cannot be null or empty.");
            }
            this.patronID = patronID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty.");
            }
            this.name = name;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
            if (contactInfo == null || contactInfo.isEmpty()) {
                throw new IllegalArgumentException("Contact information cannot be null or empty.");
            }
            this.contactInfo = contactInfo;
        }

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }

        public boolean borrowBook(Book book) {
            if (!borrowedBooks.contains(book)) {
                borrowedBooks.add(book);
                return true;
            }
            return false;
        }

        public boolean returnBook(Book book) {
            return borrowedBooks.remove(book);
        }

        @Override
        public String toString() {
            return "Patron{" +
                    "patronID='" + patronID + '\'' +
                    ", name='" + name + '\'' +
                    ", contactInfo='" + contactInfo + '\'' +
                    ", borrowedBooks=" + borrowedBooks +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Patron patron = (Patron) obj;
            return patronID.equals(patron.patronID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(patronID);
        }
    }

        //Library Class


    class Library {
        private String libraryName;
        private List<Book> books;
        private List<Patron> patrons;

        public Library(String libraryName) {
            if (libraryName == null || libraryName.isEmpty()) {
                throw new IllegalArgumentException("Library name cannot be null or empty.");
            }

            this.libraryName = libraryName;
            this.books = new ArrayList<>();
            this.patrons = new ArrayList<>();
        }

        // Getters and Setters
        public String getLibraryName() {
            return libraryName;
        }

        public void setLibraryName(String libraryName) {
            if (libraryName == null || libraryName.isEmpty()) {
                throw new IllegalArgumentException("Library name cannot be null or empty.");
            }
            this.libraryName = libraryName;
        }

        public void addBook(Book book) {
            if (!books.contains(book)) {
                books.add(book);
            }
        }

        public void removeBook(Book book) {
            books.remove(book);
        }

        public void registerPatron(Patron patron) {
            if (!patrons.contains(patron)) {
                patrons.add(patron);
            }
        }

        public Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }

        public Patron findPatronByID(String title) {
            for (Patron patron : patrons) {
                if (patron.getPatronID().equalsIgnoreCase(title)) {
                    return patron;
            }
        }
            return null;
        }

        public List<Book> findBooksByAuthor(String authorName) {
            List<Book> foundBooks = new ArrayList<>();
            for (Book book : books) {
                if (book.getAuthors().equalsIgnoreCase(authorName)) {
                    foundBooks.add(book);
                }
            }
            return foundBooks;
        }

        public boolean borrowBook(String patronID, String bookTitle) {
            Patron patron = findPatronByID(patronID);
            Book book = findBookByTitle(bookTitle);

            if (patron != null && book != null && books.contains(book)) {
                if (patron.borrowBook(book)) {
                    books.remove(book);
                    return true;
                }
            }
            return false;
        }

        public  void displayBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        public  void displayPatrons() {
            for (Patron patron : patrons) {
                System.out.println(patron);
            }
        }


        public boolean returnBook(String patronID, String bookTitle) {
            Patron patron = findPatronByID(patronID);

            if (patron != null) {
                for (Book book : patron.getBorrowedBooks()) {
                    if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                        if (patron.returnBook(book)) {
                            books.add(book);
                            return true;
                        }

                    }}}
            return false;
        }}