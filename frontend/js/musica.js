function filtrar(){

}



function preencherartistas(){

    fetch("http://localhost:8080/artistas")
        .then(res => res.json())
        .then(res =>{
            for(i=0;i<res.length;i++){
                document.getElementById("cmbartistas").innerHTML += 
                "<option value='"+res[i].id+"'>" + res[i].nomeArtistico + "</option>";
            }
        })
        .catch(err => {
            window.alert("Não existem artistas");
            window.location = "gravarartistas.html";
        });

    }