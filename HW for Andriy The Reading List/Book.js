class Book {

    constructor(title, genre, autor) {
        if(title && genre && autor){
            this.title = title;
            this.genre = genre;
            this.autor = autor;
        }
    }

    title = null;
    genre = null;
    autor = null;
    read = false;
    dateWhenendRead = null;

    finishCurrentBook(bookList) {
        this.read = true;
        this.dateWhenendRead = new Date(Date.now());
        bookList.bookIsRead.push(this);

        const { booksIsNotRead } = bookList;

        bookList.allBooks.map(someBook =>
            someBook.title === this.title && someBook.autor === this.autor ? someBook.read = true : null);

        for (let i = 0; i < booksIsNotRead.length; i++){
            booksIsNotRead[i].title === this.title && booksIsNotRead.splice(i, 1);
        }

    }

    getTime() {
        return `${this.dateWhenendRead.getHours() + ':'
                    + this.dateWhenendRead.getMinutes() + ":"
                        + this.dateWhenendRead.getSeconds()}`;
    }

    toString() {
        return `${this.title} ${this.genre} ${this.autor} 
                    ${this.read ? '*is read*' : '*is not read*'}
                        ${this.read ? this.getTime() : ""}`;
    }

}