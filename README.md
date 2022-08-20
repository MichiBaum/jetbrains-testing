# jetbrains-testing

## create db
```shell
docker run --rm --name jazz -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
```

## create table

```mysql
    CREATE TABLE users (
    id int,
    name varchar(255)
    );
```