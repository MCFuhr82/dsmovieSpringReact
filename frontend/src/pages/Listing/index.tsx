import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    // FORMA ERRADA
    /* .get é para pegar o conteudo desejado.
    .then é o que eu vou fazer com conteudo que pegou
    No caso dei um nome de response (poderia ser qualquer outro) e com a expressão lambda do JS, disse que gostaria que imprimisse no console log os dados que vieram na resposta
   

    axios.get(`${BASE_URL}/movies?size=12&page=0`)
        .then(response => {
            console.log(response.data);
        });

         */
    
    const [pageNumber, setPageNumber] = useState(0);

    /* O useEffect recebe dois argumentos.
    Uma função para ser executada e uma lista de objetos que ele vai observar.
    Sempre que alterar uma coisa no objeto, ele executa a função de novo.
    Assim, no caso, ele vai fazer a requisição apenas uma vez.
    */

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=2`)
            .then(resposta => {
                const data = resposta.data as MoviePage;
                console.log(data);
                setPageNumber(data.number);
            })
    }, []);

    return (
        <>
            <p>{pageNumber}</p>
            <Pagination />
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                </div>
            </div>
        </>
    );
}

export default Listing;