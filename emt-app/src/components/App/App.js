import './App.css';
import React,{Component,} from 'react';
import {BrowserRouter as Router, Redirect, Route, Routes} from 'react-router-dom'
import Header from '../Header/header';

import Countries from '../Countries/Countries';
import emtAppService from '../../repository/emtappRepository';
import Books from "../Books/Books";
import Categories from "../Categories/Categories";
import Authors from "../Authors/Authors";
import BookEdit from "../Books/BookEdit";
import BooktAdd from "../Books/BookAdd";
import emtappRepository from "../../repository/emtappRepository";

class App extends Component{

  constructor(props){
    super(props)
    this.state={
      countries:[],
      books:[],
      authors:[],
      categories:[],
        selectedBook:{}
    }
  }
  render() {

    return(

        <Router>
          <Header/>
          <main>
            <div className="container">
              <Routes>


                  <Route path={"/countries"} element={
                      <Countries countries={this.state.countries}/>
                  }/>
                <Route path={"/authors"} element={
                    <Authors authors={this.state.authors}/>
                }/>

                <Route path={"/categories"} exact render={() =>
                    <Categories categories={this.state.categories}/>}/>

                <Route path={"/books/add"} element={
                    <BooktAdd categories={this.state.categories}
                              authors={this.state.authors}
                              onAddProduct={this.addBook}
                    />
                }/>

                <Route path={"/books/edit/:id"} element={
                    <BookEdit categories={this.state.categories}
                              authors={this.state.authors}
                              onEditProduct={this.editBook}
                              book={this.state.selectedBook}/>
                }/>

                <Route path={"/books"} element={
                    <Books books={this.state.books}
                           onFilter={this.loadFilteredBooks}
                           onDelete={this.deleteBooks}
                           onEdit={this.getBook}
                           onRent={this.rentBook}
                    />
                }/>
              </Routes>



            </div>
          </main>
        </Router>

    )
  }




  componentDidMount() {
    this.fetchData()
  }

  fetchData = () => {
    this.loadAuthors();
    this.loadCategories();
    this.loadBooks();
    this.loadCountries()
  }

    loadCountries = () => {
        emtAppService.fetchContries()
            .then((data) => {
                this.setState({
                    countries : data.data
                })
            });
    }
  loadAuthors = () => {
    emtAppService.fetchAuthors()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        });
  }

  loadBooks = () => {
          emtAppService.fetchBooks()
              .then((data) => {
                  this.setState({
                      books: data.data
                  })
              });


  }
  loadFilteredBooks=(name)=>{
      emtAppService.fetchBooksFilter(name)
          .then((data) => {
              this.setState({
                  books: data.data
              })
          });
  }

  loadCategories = () => {
    emtAppService.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

  deleteBooks = (id) => {
    emtAppService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addBook = (name, price, quantity, category, manufacturer) => {
    emtAppService.addBook(name, price, quantity, category, manufacturer)
        .then(() => {
          this.loadBooks();
        });
  }

  getBook = (id) => {
    emtAppService.getBook(id)
        .then((data) => {
          this.setState({
            selectedBook: data.data
          })
        })
  }

  editBook = (id, name, price, quantity, category, manufacturer) => {
    emtAppService.editBook(id, name, price, quantity, category, manufacturer)
        .then(() => {
          this.loadBooks();
        });
  }
  rentBook=(id)=>{
      emtAppService.rentBook(id)
          .then(() => {
              this.loadBooks();
          });
  }



}

export default App;
