Examen Final - Integración de Aplicaciones

Alumno: Jeremy Iian Aquino Papaffava

Proyecto: FriendFools
Modulo client: Aqui es donde cree la clase Cliente y la clase Doctor, 
               con sus respectivos CRUD. Así el cliente puede resgitrarse
               y consultar los doctores disponibles con su especialidad.
Modulo appointment: Aqui es donde el cliente pide su cita, la cita tiene un id,
                    junto a su fecha y hora designada, y la lista de doctores que lo
                    atenderan(sus datos). A la par se reflejerá que el pedido a llegado
                    a la cola de friendfools.appointment.queue en ActiveMQ.
Modulo notification: Aqui es donde se enviará la notificacion al cliente de que la cita
                     ha sido registrada con éxito, también se verá que el pedio ya salió 
                     de la cola de friendfools.appointment.queue en ActiveMQ.
                     
En postMan: Para ingresar una nueva cita puede guiarse de este modelo.

{
    "id":"APP12231",
    "appointmentDate":"2020-07-21",
    "appointmentTime":"20:00",
    "client":{
        "codClient":"CLI120",
        "nomClient":"Jeremy",
        "apeClient":"Aquino",
        "email":"jeremy10000ap@hotmail.com"
    },
    "doctors":[
        {
            "id":"DOC120",
            "nomDoctor":"Jose",
            "apeDoctor":"Nuñez",
            "speciality":"Urología"
        },
        {
            "id":"DOC121",
            "nomDoctor":"Ana",
            "apeDoctor":"Aquino",
            "speciality":"Traumatología"
        }
    ]
}

Gracias por todo Profesor, nos vemos en el sgt curso!!!                  