


var urlParams = new 
URLSearchParams(window.location.search);
var id = urlParams.get('id');	


  function pintarFormulario(datos) {
    let html = `<h5>Edita tus datos:</h5>
            

        <form action="actualizar" method="post" id="editarDatos">
        
                <input type="hidden" id="id" name="id" value="${datos.id}">
                
             <div class="form-group">
                <label for="usuario"><h3>Usuario:</h3></label>
                <input type="text" id="usuario" name="usuario" value="${datos.usuario}">
            </div>
            
            <div class="form-group">
                <label for="contrasenia"><h3>Contraseña:</h3></label>
                <input type="text" id="contrasenia" name="contrasenia" value="${datos.contrasenia}">
            </div>
            
            <div class="form-group">
                <label for="email"><h3>Email:</h3></label>
                <input type="text" id="email" name="email" value="${datos.email}">
            </div>
           
            <button id="botonEditar" type="submit">Editar</button>

        </form>`

    document.getElementById("editarUsuario").innerHTML = html;
    }
    
    function llamada(id) {

    fetch('actualizar?id=' + id)
        .then(response => response.json())
        .then(data => pintarFormulario(data))
}
   window.onload = function(){
			llamada(id);
   }
    
    
    
    
    
    
    
    
    