# AndroidEltechatApp
Chat for Eltech university students 


## Server API
### Responses

Message from user: 
```JSON
{"flag":"message", "messageId":0, "name":"megalok", "message":"text"}
```

Login successfully:
```JSON
{"flag":"loginSuccess"}
```

Login failure because of nickname:
```JSON
{"flag":"loginFailureNickname"}
```

Login failure because of server internal error:
```JSON
{"flag":"loginServerFailure"}
```

Another user login:
```JSON
{"flag":"newUserConnect", "name":"Komdosh", "online":1}
```

Another user logout:
```JSON
{"flag":"userDisconnect", "name":"Komdosh", "online":2}
```

### Request
Message: 
```JSON
{"flag":"message", "name":"megalok",  "message":"text"} 
```
