function filtrar(){
            fetch("http://localhost:8080/artista/" + document.getElementById("cmbartistas").value)
                .then(res => res.json())
                .then(res => {
                    var tabela = 
                    "<table border='1' align='center' width='80%'>" + 
                    "<tr>" + 
                    "<th>Musica</th> <th>Cadastro</th> <th>Lancamento</th>" +
                    "</tr>";
                    
                    for (i=0; i<res.musicas.length;i++){
    
                        var status="NÃO";
                        if (res.musicas[i].lancamento==1){
                            status="SIM"
                        }
                        tabela +=
                            "<tr>" +
                            "<td>" + res.musicas[i].titulo + "</td>"+ 
                            "<td>" + res.musicas[i].cadastro + "</td>"+ 
                            "<td>" + status + "</td>"+ 
                            "</tr>";
                    }
    
                    tabela+="</table>";
                    document.getElementById("tabela").innerHTML = tabela;
                })
                .catch(err => {
                    window.alert("Não existem musicas");
                });
        
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