/* Definir uma variavel de ambiente:
O nome da variável é BASE_URL. Recebeu o caminho do Heroku e da maquina local. 
process.env.REACT_APP_BACKEND_URL é para se comunivar com o Heroku, após implantado.
REACT_APP é padrão React, tem que ser esse nome. _BACKEND_URL é o nome que eu dei.
?? significa que se o nome da variável não estiver implantada no heroku, ele irá fazer o que vem após.
No caso, irá se comunicar com a minha máquina local, atravésa do caminho passado "http://localhost:8080" 
*/
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? "http://localhost:8080";