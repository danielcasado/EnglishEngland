/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function alta(usr, con, tipo){
    sessionStorage["usr"]=usr;
    sessionStorage["con"]=con;
    sessionStorage["tipo"]=tipo;    
}

function ver(){
    if(sessionStorage["usr"]){
        var sup = document.getElementById("superior2");
        sup.innerHTML = "<a id='registrarAlumno' class='inicial'>"+sessionStorage["usr"]+"</a>"
              +"<a id='iniciarSesion' class='inicial' href='salir.html'>Salir</a>";
  }
}
function salir(){
    sessionStorage.removeItem('usr');
    sessionStorage.removeItem('con');
    sessionStorage.removeItem('tipo');
    
}