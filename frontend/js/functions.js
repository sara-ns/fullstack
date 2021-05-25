function exibirusuario(){

    var ustr = localStorage.getItem("ulogado");
    if (ustr==null){
        window.location = "login.html";
    }else{
        var ujson = JSON.parse(ustr);
        document.getElementById("dados").innerHTML =
        "<h4>Usuário:" + ujson.nome + "<br>E-mail: " + ujson.email + "</h4>";
        document.getElementById("foto").innerHTML = 
        "<img src=images/" + ujson.foto + ">";
    }
}





function logar() {
    //window.alert("Oi Saroca");
    var carta = {
        email : document.getElementById("txtemail").value ,
        senha : document.getElementById("txtsenha").value
    };

    var envelope = {
        headers : {
            "content-type" : "application/json"
        },
        method : "POST",
        body : JSON.stringify(carta)
        
    };

    fetch("http://localhost:8080/login", envelope)
    .then(res => res.json())
    .then(res => {
        localStorage.setItem("ulogado" , JSON.stringify(res));
        window.location = "user.html";
    })
    .catch(err => {
        window.alert("Email e/ou senha invalido(s)!");
    });


}