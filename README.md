# api-center-medical

Api encargada de gestionar informacion de pacientes y medicos:



## Uso básico
```http
GET /getAllPatients                    : Obtiene la lista completa de pacientes
GET /historicalMedicalRecords/{name}   : Obtiene el historial del patient filtrado por su nombre 
GET /allMedicalRecords                 : Obtiene el listado completo de medicos
GET /findDoctor/{name}                 : Obtiene un medico filtrado por nombre
```


### Obtiene la lista completa de pacientes

GET /getAllPatients

Respuesta:

```json
[
  {
    "id": "1",
    "name": "John",
    "age": 30,
    "address": "Avenida 456",
    "historialMedicos": [
      {
        "date": "2022-01-15",
        "doctor": {
          "id": "D001",
          "name": "Dr. Smith",
          "specialization": "Cardiología",
          "phoneNumber": "+123456789",
          "email": "dr.smith@example.com",
          "consultationHours": "Lunes a Viernes 9:00-17:00",
          "hospital": "Hospital Central"
        },
        "diagnosis": "Gripe",
        "treatment": "Descanso y medicación"
      },
      {
        "date": "2022-02-05",
        "doctor": {
          "id": "D002",
          "name": "Dr. Johnson",
          "specialization": "Pediatría",
          "phoneNumber": "+987654321",
          "email": "dr.johnson@example.com",
          "consultationHours": "Lunes a Viernes 8:00-16:00",
          "hospital": "Hospital Infantil"
        },
        "diagnosis": "Esguince de tobillo",
        "treatment": "Inmovilización y fisioterapia"
      },
      {
        "date": "2022-03-20",
        "doctor": {
          "id": "D003",
          "name": "Dr. Martinez",
          "specialization": "Neurología",
          "phoneNumber": "+112233445",
          "email": "dr.martinez@example.com",
          "consultationHours": "Martes y Jueves 10:00-18:00",
          "hospital": "Hospital Neurológico"
        },
        "diagnosis": "Dolor abdominal",
        "treatment": "Estudios para diagnóstico"
      }
    ]
  },
  {
    "id": "2",
    "name": "Jane",
    "age": 25,
    "address": "Calle Principal",
    "historialMedicos": [
      {
        "date": "2022-04-10",
        "doctor": {
          "id": "D004",
          "name": "Dra. Garcia",
          "specialization": "Dermatología",
          "phoneNumber": "+554433221",
          "email": "dra.garcia@example.com",
          "consultationHours": "Lunes, Miércoles y Viernes 8:30-16:30",
          "hospital": "Hospital Dermatológico"
        },
        "diagnosis": "Fiebre alta",
        "treatment": "Antibióticos y reposo"
      },
      {
        "date": "2022-05-22",
        "doctor": {
          "id": "D005",
          "name": "Dr. Fernandez",
          "specialization": "Oftalmología",
          "phoneNumber": "+778899001",
          "email": "dr.fernandez@example.com",
          "consultationHours": "Lunes y Jueves 9:30-17:30",
          "hospital": "Hospital Oftalmológico"
        },
        "diagnosis": "Lesión en la rodilla",
        "treatment": "Cirugía reconstructiva"
      },
      {
        "date": "2022-06-18",
        "doctor": {
          "id": "D006",
          "name": "Dra. Lopez",
          "specialization": "Ginecología",
          "phoneNumber": "+112233445",
          "email": "dra.lopez@example.com",
          "consultationHours": "Lunes, Miércoles y Viernes 8:00-16:00",
          "hospital": "Hospital de la Mujer"
        },
        "diagnosis": "Conjuntivitis",
        "treatment": "Gotas oftálmicas y lavados"
      }
    ]
  }
]
```


### Obtiene el historial del patient filtrado por su nombre

GET /historicalMedicalRecords/{name}

Respuesta:

```json
[
    {
        "date": "2022-04-10",
        "doctor": {
            "id": "D004",
            "name": "Dra. Garcia",
            "specialization": "Dermatología",
            "phoneNumber": "+554433221",
            "email": "dra.garcia@example.com",
            "consultationHours": "Lunes, Miércoles y Viernes 8:30-16:30",
            "hospital": "Hospital Dermatológico"
        },
        "diagnosis": "Fiebre alta",
        "treatment": "Antibióticos y reposo"
    },
    {
        "date": "2022-05-22",
        "doctor": {
            "id": "D005",
            "name": "Dr. Fernandez",
            "specialization": "Oftalmología",
            "phoneNumber": "+778899001",
            "email": "dr.fernandez@example.com",
            "consultationHours": "Lunes y Jueves 9:30-17:30",
            "hospital": "Hospital Oftalmológico"
        },
        "diagnosis": "Lesión en la rodilla",
        "treatment": "Cirugía reconstructiva"
    },
    {
        "date": "2022-06-18",
        "doctor": {
            "id": "D006",
            "name": "Dra. Lopez",
            "specialization": "Ginecología",
            "phoneNumber": "+112233445",
            "email": "dra.lopez@example.com",
            "consultationHours": "Lunes, Miércoles y Viernes 8:00-16:00",
            "hospital": "Hospital de la Mujer"
        },
        "diagnosis": "Conjuntivitis",
        "treatment": "Gotas oftálmicas y lavados"
      }
  ]
 
### Obtiene el listado completo de medicos

GET /allMedicalRecords

Respuesta:

```json
[
    {
        "id": "D001",
        "name": "Dr. Smith",
        "specialization": "Cardiología",
        "phoneNumber": "+123456789",
        "email": "dr.smith@example.com",
        "consultationHours": "Lunes a Viernes 9:00-17:00",
        "hospital": "Hospital Central"
    },
    {
        "id": "D002",
        "name": "Dr. Johnson",
        "specialization": "Pediatría",
        "phoneNumber": "+987654321",
        "email": "dr.johnson@example.com",
        "consultationHours": "Lunes a Viernes 8:00-16:00",
        "hospital": "Hospital Infantil"
    },
    {
        "id": "D003",
        "name": "Dr. Martinez",
        "specialization": "Neurología",
        "phoneNumber": "+112233445",
        "email": "dr.martinez@example.com",
        "consultationHours": "Martes y Jueves 10:00-18:00",
        "hospital": "Hospital Neurológico"
    },
    {
        "id": "D004",
        "name": "Dra. Garcia",
        "specialization": "Dermatología",
        "phoneNumber": "+554433221",
        "email": "dra.garcia@example.com",
        "consultationHours": "Lunes, Miércoles y Viernes 8:30-16:30",
        "hospital": "Hospital Dermatológico"
    },
    {
        "id": "D005",
        "name": "Dr. Fernandez",
        "specialization": "Oftalmología",
        "phoneNumber": "+778899001",
        "email": "dr.fernandez@example.com",
        "consultationHours": "Lunes y Jueves 9:30-17:30",
        "hospital": "Hospital Oftalmológico"
    },
    {
        "id": "D006",
        "name": "Dra. Lopez",
        "specialization": "Ginecología",
        "phoneNumber": "+112233445",
        "email": "dra.lopez@example.com",
        "consultationHours": "Lunes, Miércoles y Viernes 8:00-16:00",
        "hospital": "Hospital de la Mujer"
    }
]

### Obtiene un medico filtrado por nombre

GET /findDoctor/{name}

Respuesta:
{
    "id": "D001",
    "name": "Dr. Smith",
    "specialization": "Cardiología",
    "phoneNumber": "+123456789",
    "email": "dr.smith@example.com",
    "consultationHours": "Lunes a Viernes 9:00-17:00",
    "hospital": "Hospital Central"
}