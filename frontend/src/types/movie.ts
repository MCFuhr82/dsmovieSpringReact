/* arquivo normal de TypeScript. Não é arquivo react. É somente .ts
Esse valores foram buscados no retorno no Postman.
Esses dados casam com os dados do retorno do GET, para ter a mesma estrutura JSON.
*/

export type Movie = {
    id: number;
    title: string;
    score: number;
    count: number;
    image: string;
}

export type MoviePage = {
    content: Movie[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}