import React from 'react';
import {Link} from 'react-router-dom';

const BookTerm = (props) => {
    if (props.term.availableCopies>0){
        return (
            <tr>
                <td>{props.term.name}</td>
                <td>{props.term.category}</td>
                <td>{props.term.author.name} {props.term.author.surname}</td>
                <td>{props.term.availableCopies}</td>
                <td className={"text-right"}>
                    <a title={"Delete"} className={"btn btn-danger"}
                       onClick={() => props.onDelete(props.term.id)}>
                        Delete
                    </a>
                    <Link className={"btn btn-info ml-2"}
                          onClick={() => props.onEdit(props.term.id)}
                          to={`/books/edit/${props.term.id}`}>
                        Edit
                    </Link>

                    <a title={"Rent"}  className={"btn btn-danger"}
                       onClick={() => props.onRent(props.term.id)}>
                        Rent
                    </a>
                </td>
            </tr>
        )
    }else{
        return (
            <tr>
                <td>{props.term.name}</td>
                <td>{props.term.category}</td>
                <td>{props.term.author.name} {props.term.author.surname}</td>
                <td>{props.term.availableCopies}</td>
                <td className={"text-right"}>
                    <a title={"Delete"} className={"btn btn-danger"}
                       onClick={() => props.onDelete(props.term.id)}>
                        Delete
                    </a>
                    <Link className={"btn btn-info ml-2"}
                          onClick={() => props.onEdit(props.term.id)}
                          to={`/books/edit/${props.term.id}`}>
                        Edit
                    </Link>

                    <a title={"Rent"} className={"btn btn-danger disabled"}
                       onClick={() => props.onRent(props.term.id)}>
                        Rent
                    </a>
                </td>
            </tr>
        )
    }

}

export default BookTerm;
