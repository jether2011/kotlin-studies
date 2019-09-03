### GET

`http://localhost:8080/persons`

### POST

##### Request

```json
curl -X POST \
  http://localhost:8080/persons \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 64' \
  -H 'Content-Type: application/json' \
  -H 'Cookie: JSESSIONID=vurQVDo4nzRu2MuaVMJ10aowdvCfKqGbmnIWrApR' \
  -H 'Host: localhost:8080' \
  -H 'cache-control: no-cache' \
  -d '{
	"firstName": "Jether",
	"lastName": "Rodrigues",
	"age": 37
}'
```
##### Response

```json
{
     "name": "Jether Rodrigues",
     "age": 37
 }
```