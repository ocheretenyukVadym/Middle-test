const INPUT_NEW_LIST = document.getElementById("newBookList");
const BUTTON_CREATE_LIST = document.getElementById("createNewList");
const BOOK_LIST_DROPDOWN = document.getElementById("BookLists");
const SELECT_BUTTON = document.getElementById("selectButton");
const MENU = document.getElementById("menu");
const SUBMIT = document.getElementById("submit");
const TITLE_INPUT = document.getElementById("title");
const GENRE_INPUT = document.getElementById("genre");
const AUTOR_INPUT = document.getElementById("autor");
const ALL_BOOKS_BLOCK = document.getElementById("allBooks");
const READ_BOOKS_BLOCK = document.getElementById("read");
const NOT_READ_BOOKS_BLOCK = document.getElementById("notRead");

BUTTON_CREATE_LIST.addEventListener("click", createNewListAction);

const myAllBookLists = [new BookList("myBookList")];
workWithList(myAllBookLists[0]);


function call() {
    let index = indexOfBookListSelected();
    workWithList(myAllBookLists[index]);
}

function indexOfBookListSelected() {
    let index = myAllBookLists.findIndex(el => el.name == String(BOOK_LIST_DROPDOWN.value));
    return index;
}

function createNewListAction() {
    if (INPUT_NEW_LIST.value) {
        let newList = new BookList(INPUT_NEW_LIST.value);
        myAllBookLists.push(newList);
        INPUT_NEW_LIST.value = '';

        const newOption = document.createElement("option");
        newOption.id = myAllBookLists.length;
        newOption.value = newList.name;
        newOption.innerHTML = `${newList.name}`;
        BOOK_LIST_DROPDOWN.appendChild(newOption);
    }
}

function workWithList(myBookList) {
    SUBMIT.addEventListener('click', createNewBookAction);

    SELECT_BUTTON.addEventListener("click", function () {
        call();
        SUBMIT.removeEventListener('click', createNewBookAction);
    });

    let { allBooks } = myBookList;
    let { booksIsNotRead } = myBookList;
    let { bookIsRead } = myBookList;

    clearAllField();
    showAllBooks();
    showBooksIsRead();
    showBooksIsNotRead();
    clickButtonRead();
    clickButtonReadtoNotRead();

    function clearAllField() {
        TITLE_INPUT.value = '';
        GENRE_INPUT.value = '';
        AUTOR_INPUT.value = '';
        ALL_BOOKS_BLOCK.innerHTML = `<div class="allBooks__title"> All books </div>`
        READ_BOOKS_BLOCK.innerHTML = `<div class="read__title"> Read books </div>`
        NOT_READ_BOOKS_BLOCK.innerHTML = `<div class="notRead__title"> Not read books </div>`
    }

    function createNewBookAction() {
        if (TITLE_INPUT.value && GENRE_INPUT.value && AUTOR_INPUT.value) {
            myBookList.addBook(new Book(
                TITLE_INPUT.value,
                GENRE_INPUT.value,
                AUTOR_INPUT.value
            ))
            TITLE_INPUT.value = '';
            GENRE_INPUT.value = '';
            AUTOR_INPUT.value = '';

            ALL_BOOKS_BLOCK.innerHTML = `<div class="allBooks__title"> All books </div>`

            showAllBooks();
            showBooksIsNotRead();
            clickButtonReadtoNotRead();
        }
    }

    function showAllBooks() {
        ALL_BOOKS_BLOCK.innerHTML = `<div class="allBooks__title"> All books </div>`
        for (let i = 0; i < allBooks.length; i++) {
            const NEW_BOOK = document.createElement("div");
            NEW_BOOK.className = 'allBooks__book';

            const newButton = document.createElement('button');
            newButton.disabled = allBooks[i].read;
            newButton.id = `${allBooks[i].autor + i}`;
            newButton.textContent = "Read";

            NEW_BOOK.innerHTML = `${allBooks[i].toString()}`;
            NEW_BOOK.appendChild(newButton);

            ALL_BOOKS_BLOCK.appendChild(NEW_BOOK);
        }
        clickButtonRead();
    }

    function showBooksIsRead() {
        READ_BOOKS_BLOCK.innerHTML = `<div class="read__title"> Read books </div>`

        for (let i = 0; i < bookIsRead.length; i++) {
            const NEW_BOOK = document.createElement("div");

            NEW_BOOK.className = 'read__book';
            NEW_BOOK.innerHTML = `${bookIsRead[i].toString()}`;

            READ_BOOKS_BLOCK.appendChild(NEW_BOOK);
        }
    }

    function showBooksIsNotRead() {
        NOT_READ_BOOKS_BLOCK.innerHTML = `<div class="notRead__title"> Not read books </div>`
        for (let i = 0; i < booksIsNotRead.length; i++) {
            const NEW_BOOK = document.createElement("div");
            const newButton = document.createElement("button");

            newButton.id = `${booksIsNotRead[i].title + String(i)}`;
            newButton.textContent = "Read";

            NEW_BOOK.className = 'notRead__book';
            NEW_BOOK.innerHTML = `${booksIsNotRead[i].toString()}`
            NEW_BOOK.appendChild(newButton);

            NOT_READ_BOOKS_BLOCK.appendChild(NEW_BOOK);
        }
    }

    function clickButtonRead() {
        for (let i = 0; i < allBooks.length; i++) {
            document.getElementById(`${allBooks[i].autor + i}`).addEventListener("click", () => {
                allBooks[i].finishCurrentBook(myBookList);
                showAllBooks();
                showBooksIsRead();
                showBooksIsNotRead();
                clickButtonReadtoNotRead();
            })
        }
    }

    function clickButtonReadtoNotRead() {
        for (let i = 0; i < booksIsNotRead.length; i++) {
            document.getElementById(`${booksIsNotRead[i].title + i}`).addEventListener("click", () => {
                booksIsNotRead[i].finishCurrentBook(myBookList);
                showAllBooks();
                showBooksIsRead();
                showBooksIsNotRead();
                clickButtonReadtoNotRead();
                clickButtonRead();
            })
        }
    }
}