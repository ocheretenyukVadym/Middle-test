class BookList{

    constructor(name){
        this.name = name;
    }
    
    name = "";
    bookIsRead = [];
    booksIsNotRead = [];
    allBooks = [];

    nextBookToRead = () => this.booksIsNotRead[0];  
    
    currentBookBeingRead = () => this.booksIsNotRead[1];
    
    lastBookRead = () => this.bookIsRead[this.bookIsRead.length-1];
    
    getArrayOfAllBooks = () => this.allBooks;
    
    addBook(book){
        this.allBooks.push(book);
        this.booksIsNotRead.push(book);
    }
}
