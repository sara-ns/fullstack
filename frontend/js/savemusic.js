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
    
    function gravar(){
    
        var carta = {
            titulo : document.getElementById("txttitulo").value ,
            cadastro : document.getElementById("txtcadastro").value ,
            lancamento : document.getElementById("txtlancamento").value ,
            artista :{
                id : document.getElementById("cmbartistas").value ,
            }
        }
    
        var envelope = {
            method : "POST",
            body : JSON.stringify(carta),
            headers : {
                "content-type" : "application/json"
            }
        };
    
        fetch("http://localhost:8080/novamusica", envelope)
            .then(res => res.json())
            .then(res => {
                window.alert("A musica n: " + res.id + " foi cadastrado com sucesso");
                window.location = "gravarmusica.html";
            })
            .catch(err => {
                window.alert("Não foi possivel realizar o cadastro");
            });
    }