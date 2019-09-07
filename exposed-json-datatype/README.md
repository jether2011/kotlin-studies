# Exposed JSON Datatype

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