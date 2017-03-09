# AndroidEltechatApp
Chat for Eltech university students 


## Сервер API
### Сообщения с сервера 

Простое сообщение: 
```JSON

{"flag":"message", "messageId":0, "name":"megalok", "message":"text"}
```

Пользователь зашёл удачно:

```JSON

{"flag":"loginSuccess"}
```

Пользователь не смог зайти из-за ника:

```JSON

{"flag":"loginFailureNickname"}
```

Пользователь не смог зайти ошибка сервера:

```JSON

{"flag":"loginServerFailure"}
```

Другой пользователь зашёл:

```JSON

{"flag":"newUserConnect", "name":"Komdosh", "online":1}
```

Другой пользователь вышел:

```JSON

{"flag":"userDisconnect", "name":"Komdosh", "online":2}
```

### Сообщения на сервер 
Простое сообщение: 

```JSON

{"flag":"message", "name":"megalok",  "message":"text"} 
```
