# DepartBank

Aplicación en Java para crear y gestionar una cuenta bancaria.
Permanencia de datos mediante Json.

## Las posibles acciones son:

	• Crear una nueva cuenta con número de IBAN, titular y saldo.
	• Eliminar una cuenta.
	• Ingresar un importe.
	• Retirar un importe.
	• Mostrar el titular de la cuenta.
	• Mostrar el saldo de la cuenta.
	• Mostrar el historial de movimientos.

## Datos a considerar:

	• El número de IBAN debe comenzar con dos letras mayúsculas seguidas de 22 digitos numéricos.
	• El titular admite los caracteres del alfabeto español.
	• El importe a ingresar o retirar ha de ser un número positivo.
	• El saldo mínimo permitido es -50€.
	• Los datos de todas cuentas se guardan en el fichero "./src/main/resources/accounts.json"