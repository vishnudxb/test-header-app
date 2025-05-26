# Testing the header

```

docker compose up --build

OR

docker build -t test-header-app .

```

```

docker run -p 8080:8080 test-header-app

```


## Testing

```

➜  ~
➜  ~ curl -H "x-forwarded-for: fake-ip" http://localhost:8080/test
x-forwarded-for: fake-ip
remoteAddr: 192.168.5.1%                                                                                                         

```