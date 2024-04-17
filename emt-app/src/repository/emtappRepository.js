import axios from "../custom-axios/axios";

const emtAppService={
    fetchContries:()=>{
        return axios.get("/countries")
    },
    fetchAuthors:()=>{
        return axios.get("/authors")
    },
    fetchBooks:()=>{
        return axios.get("/books")
    },
    fetchBooksFilter:(name)=>{
        return axios.get(`/books?name=${name}`)
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },

    fetchCategories:()=>{
        return axios.get("/books/categories")
    },
    deleteBook: (id) => {
        return axios.post(`/books/delete/${id}`);
    },
    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        });
    },
    editBook: (id,name, category, authorId, availableCopies) => {
        return axios.post(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        });
    },
    rentBook: (id) => {
        return axios.post(`/books/rent/${id}`);
    },




}

export default emtAppService