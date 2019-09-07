# Exposed JSON Datatype

### UP Necessaries Services

There is a file: `up.sh` and executing it, the docker services (PGADMIN4 and POSTGRESQL 9) will start and after that, the application will be able to run.

Execute:

```shell_script
sh up.sh
```

To access PGADMIN4 go to the local url `http:localhost:5555` and use the credentials below to access the service:

```json
{
  "username": "dev@gmail.com",
  "password": "PgAdmin2019!"
}
```

### GET

##### ALL
```shell script
curl -X GET \
  http://localhost:7000/users \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:7000' \
  -H 'cache-control: no-cache'
```

##### BY ID

```shell script
curl -X GET \
  http://localhost:7000/users/{{id}} \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:7000' \
  -H 'cache-control: no-cache'
```


### POST

```shell script
curl -X POST \
  http://localhost:7000/users \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 106' \
  -H 'Content-Type: application/json'
  -H 'Host: localhost:7000' \
  -H 'cache-control: no-cache' \
  -d '{
	"name": "Jether Rodrigues",
	"email": "jetherrodrigues@gmail.com",
	"roles": [
		"ADMIN",
		"ROOT"
	]
}'

curl -X POST \
  http://localhost:7000/users \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 106' \
  -H 'Content-Type: application/json'
  -H 'Host: localhost:7000' \
  -H 'cache-control: no-cache' \
  -d '{
	"name": "Denise Cristina",
	"email": "denise.cristina@gmail.com",
	"roles": [
		"USER"
	]
}'
```