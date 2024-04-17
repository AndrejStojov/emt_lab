import React from "react";
import ReactPaginate from 'react-paginate'
import {Link,useNavigate} from 'react-router-dom';
import BookTerm from "./BookTerm";
class Books extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 5,
            name:""
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getProductsPage(offset, nextPageOffset);
        console.log(books, pageCount)
        const handleChange=(e)=>{
            e.target.name= e.target.value.trim()
            this.state.name=e.target.name
        }
        const onFormSubmit=(e)=>{
            e.preventDefault()
            const submitName=this.state.name
            this.props.onFilter(submitName);
        }

        return (
            <>
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                        <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                    </div>
                </form>
                <div className={"container mm-4 mt-5"}>
                    <div className={"row"}>
                        <div className={"table-responsive"}>
                            <table className={"table table-striped"}>
                                <thead>
                                <tr>
                                    <th scope={"col"}>Name</th>
                                    <th scope={"col"}>Category</th>
                                    <th scope={"col"}>Author</th>
                                    <th scope={"col"}>Available Copies</th>

                                </tr>
                                </thead>
                                <tbody>
                                {books}
                                </tbody>
                            </table>
                        </div>
                        <div className="col mb-3">
                            <div className="row">
                                <div className="col-sm-12 col-md-12">
                                    <Link className={"btn btn-block btn-dark"} to={"/books/add"}>Add new Book</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    <ReactPaginate previousLabel={"back"}
                                   nextLabel={"next"}
                                   breakLabel={<a href="/#">...</a>}
                                   breakClassName={"break-me"}
                                   pageClassName={"ml-1"}
                                   pageCount={pageCount}
                                   marginPagesDisplayed={2}
                                   pageRangeDisplayed={5}
                                   onPageChange={this.handlePageClick}
                                   containerClassName={"pagination m-4 justify-content-center"}
                                   activeClassName={"active"}/>
                </div>

            </>


        )
    }


    handlePageClick = (data) => {
        let selected = data.selected;
        console.log(selected)
        this.setState({
            page: selected
        })
    }

    getProductsPage = (offset, nextPageOffset) => {
        console.log(offset, nextPageOffset)
        return this.props.books.map((term, index) => {
            return (
                <BookTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit} onRent={this.props.onRent}/>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }
}

export default Books;
