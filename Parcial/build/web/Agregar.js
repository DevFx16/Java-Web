function LanzarFormulario() {
    Swal.fire({
        title: 'Agregar',
        html: '<form onsubmit="Submit()" action="javascript:;" method="POST">' +
                '<div class="field">' +
                '<p class="control has-icons-left has-icons-right">' +
                '<input class="input" type="text" placeholder="Nombre" required id="nombre" />' +
                '<span class="icon is-small is-left">' +
                '<i class="fas fa-user"></i>' +
                '</span>' +
                '</p>' +
                '</div>' +
                '<div class="field">' +
                '<p class="control has-icons-left has-icons-right">' +
                '<input class="input" type="text" placeholder="Apellido" required id="apellido" />' +
                '<span class="icon is-small is-left">' +
                '<i class="fas fa-user"></i>' +
                '</span>' +
                '</p>' +
                '</div>' +
                '<div class="field">' +
                '<p class="control has-icons-left has-icons-right">' +
                '<input class="input" type="email" placeholder="Email" required id="email" />' +
                '<span class="icon is-small is-left">' +
                '<i class="fas fa-at"></i>' +
                '</span>' +
                '</p>' +
                '</div>' +
                '<div class="field">' +
                '<label class="label">Lenguaje</label>' +
                '<div class="control has-icons-left">' +
                '<span class="select is-primary is-fullwidth">' +
                '<select id="lenp" class="is-fullwidth">' +
                '<option value="Java">Java</option>' +
                '<option value="JavaScript">JavaScript</option>' +
                '<option value="Python">Python</option>' +
                '<option value="Ruby">Ruby</option>' +
                '</select>' +
                '</span>' +
                '<span class="icon is-small is-left">' +
                '<i class="fas fa-code"></i>' +
                '</span>' +
                '</div>' +
                '</div>' +
                '<div class="field">' +
                '<div class="control">' +
                '<label class="checkbox is-fullwidth">' +
                'Hobbies: <br><br>' +
                '<input type="checkbox" id="cb-autos" value="Autos" name="Autos" class="is-checkradio is-danger">' +
                '<label for="Autos">Autos</label>' +
                '<input type="checkbox" id="cb-deportes" value="Deportes" class="is-checkradio is-danger" name="Deportes">' +
                '<label for="Deportes">Deportes</label>' +
                '<input type="checkbox" id="cb-videojuegos" value="Videojuegos" class="is-checkradio is-danger" name="Videojuegos">' +
                '<label for="Videojuegos">Videojuegos</label>' +
                '<input type="checkbox" id="cb-instrumentos" value="Instrumentos" class="is-checkradio is-danger" name="Instrumentos">' +
                '<label for="Instrumentos">Instrumentos</label>' +
                '<label class="checkbox">' +
                '</div>' +
                '</div>' +
                '<div class="field">' +
                '<p class="control">' +
                '<button class="button is-success is-fullwidth" type="submit">Agregar</button>' +
                '</p>' +
                '</div>' +
                '</form>',
        showCloseButton: true,
        showConfirmButton: false
    })
}

function Submit() {
    var misCabeceras = new Headers();
    var ids = ['cb-autos', 'cb-deportes', 'cb-videojuegos', 'cb-instrumentos'];
    var check = [];
    ids.forEach(function (id) {
        if (document.getElementById(id).checked) {
            check.push(document.getElementById(id).value);
        }
    });

    var miInit = {method: 'POST',
        headers: misCabeceras,
        body: JSON.stringify({
            'Nombres': document.getElementById('nombre').value,
            'Apellidos': document.getElementById('apellido').value,
            'Email': document.getElementById('email').value,
            'Lenguaje': document.getElementById('lenp').value,
            'Hobbies': check
        }),
        cache: 'default'};
    console.log(check);

    fetch('./Peticion', miInit).then(function (response) {
        response.json().then(function (data) {
            if (data.Ok) {
                window.location.href = "/Parcial";
            } else {
                Swal.fire('Error', data.Message.toString(), 'error');
            }
        }).catch(function (error) {
            Swal.fire('Error', error.Message.toString(), 'error');
        });
    }).catch(function (error) {
        Swal.fire('Error', error.Message.toString(), 'error');
    });
}
